package at.ac.tuwien.dmap.dmapbackend.tiss.projectdatabase.service.impl;

import at.ac.tuwien.dmap.dmapbackend.tiss.addressbook.dto.OrganisationalUnitDetails;
import at.ac.tuwien.dmap.dmapbackend.tiss.addressbook.dto.Person;
import at.ac.tuwien.dmap.dmapbackend.tiss.addressbook.dto.PersonDetails;
import at.ac.tuwien.dmap.dmapbackend.tiss.addressbook.service.AddressBookService;
import at.ac.tuwien.dmap.dmapbackend.tiss.projectdatabase.dto.*;
import at.ac.tuwien.dmap.dmapbackend.tiss.projectdatabase.service.ProjectDatabaseService;
import at.ac.tuwien.dmap.dmapbackend.tiss.common.TissResponseErrorHandler;
import at.ac.tuwien.dmap.dmapbackend.tiss.projectdatabase.rest.exceptions.ProjectDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProjectDatabaseServiceImpl implements ProjectDatabaseService {
    private final RestTemplate restTemplate;
    private AddressBookService addressBookService;
    private final String addressBookBaseUrl = "https://tiss.tuwien.ac.at/api/pdb/rest";

    @Autowired
    public ProjectDatabaseServiceImpl(RestTemplateBuilder restTemplateBuilder, AddressBookService addressBookService) {

        this.restTemplate = restTemplateBuilder.
                rootUri(addressBookBaseUrl)
                .errorHandler(new TissResponseErrorHandler())
                .build();

        this.addressBookService = addressBookService;
    }

    @Override
    public List<ProjectOverview> getProjectsByOrgCriteria(String instituteOid, String projectLeadOid) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("/projectsearch/v2")
                .queryParam("instituteOid", instituteOid);

        if (null != projectLeadOid) {
            builder.queryParam("projectleaderOid", projectLeadOid);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));

        HttpEntity requestEntity = new HttpEntity<>("parameters", headers);

        ResponseEntity<ProjectOverviewList> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                requestEntity,
                ProjectOverviewList.class);

        return response.getBody().getProjects();
    }

    @Override
    public ProjectDetails getProjectDetails(String projectId) {
        Map<String, Object> variables = new HashMap<String, Object>() {{
            put("projectId", projectId);
        }};

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("/project/v3/{projectId}")
                .uriVariables(variables);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));

        HttpEntity requestEntity = new HttpEntity<>("parameters", headers);

        ResponseEntity<ProjectDetailsWrapper> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                requestEntity,
                ProjectDetailsWrapper.class);

        ProjectDetails projectDetails = response.getBody().getProjectDetails();

        if(null == projectDetails) {
            throw new ProjectDetailsNotFoundException(
                    String.format("Project details for project ID %s not found.", projectId));
        }

        return projectDetails;
    }

    /**
     * Suggests projects from the project database the person might be interested in.
     *
     * @param person The person for whom projects shall be suggested.
     * @return Projects from project database where the person is project leader or projects from all
     * organisational units the person is a member of. Sorted by project leader and project begin in
     * descending order (latest projects first).
     */
    @Override
    public List<ProjectOverview> getProjectSuggestionsForPerson(Person person) {
        Map<String, ProjectOverview> projects = new HashMap<>();

        person.getOrganisationalUnits().forEach(orgUnit -> {

            OrganisationalUnitDetails details = addressBookService.getOrgDetailsByTissId(orgUnit.getTissId());
            getProjectsByOrgCriteria(details.getOid(), person.getOid()).forEach(projectOverview -> {
                projectOverview.setProjectLeaderOid(person.getOid());
                projects.put(projectOverview.getProjectId(), projectOverview);
            });

            getProjectsByOrgCriteria(details.getOid(), null).forEach(projectOverview -> {
                projects.putIfAbsent(projectOverview.getProjectId(), projectOverview);
            });
        });

        List<ProjectOverview> suggestedProjects = new ArrayList<>(projects.values());

        Comparator<ProjectOverview> sortByProjectLeader = (o1, o2) -> {
            if (o1.getProjectLeaderOid() != null && o2.getProjectLeaderOid() == null) {
                return -1;
            } else if(o1.getProjectLeaderOid() == null && o2.getProjectLeaderOid() != null) {
                return 1;
            }
            else {
                return 0;
            }
        };

        Comparator<ProjectOverview> sortByProjectBeginDescending = (o1, o2) -> o2.getBegin().compareTo(o1.getBegin());

        return suggestedProjects.stream().sorted(
                sortByProjectLeader.thenComparing(sortByProjectBeginDescending)
        ).collect(Collectors.toList());
    }

    @Override
    public List<ProjectMemberDetails> getProjectStaff(String projectId) {
        ProjectDetails projectDetails = getProjectDetails(projectId);
        List<ProjectMemberDetails> projectMemberDetailsList = new ArrayList<>();

        projectDetails.getInstitutes().forEach(institute -> institute.getProjectMembers().forEach(projectMember -> {
            PersonDetails personDetails = addressBookService.getPersonDetailsById(projectMember.getOid());
            projectMemberDetailsList.add(ProjectMemberDetails.fromProjectMemberAndPersonDetails(projectMember, personDetails));
        }));
        return projectMemberDetailsList;
    }
}
