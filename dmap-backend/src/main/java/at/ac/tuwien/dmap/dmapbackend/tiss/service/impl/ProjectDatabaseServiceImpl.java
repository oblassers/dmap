package at.ac.tuwien.dmap.dmapbackend.tiss.service.impl;

import at.ac.tuwien.dmap.dmapbackend.tiss.dto.ProjectDetails;
import at.ac.tuwien.dmap.dmapbackend.tiss.dto.ProjectDetailsWrapper;
import at.ac.tuwien.dmap.dmapbackend.tiss.dto.ProjectOverview;
import at.ac.tuwien.dmap.dmapbackend.tiss.dto.ProjectOverviewList;
import at.ac.tuwien.dmap.dmapbackend.tiss.rest.exceptions.ProjectDetailsNotFoundException;
import at.ac.tuwien.dmap.dmapbackend.tiss.service.ProjectDatabaseService;
import at.ac.tuwien.dmap.dmapbackend.tiss.service.error.TissResponseErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProjectDatabaseServiceImpl implements ProjectDatabaseService {
    private final RestTemplate restTemplate;
    private final String addressBookBaseUrl = "https://tiss.tuwien.ac.at/api/pdb/rest";

    @Autowired
    public ProjectDatabaseServiceImpl(RestTemplateBuilder restTemplateBuilder) {

        this.restTemplate = restTemplateBuilder.
                rootUri(addressBookBaseUrl)
                .errorHandler(new TissResponseErrorHandler())
                .build();
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
}
