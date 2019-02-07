package at.ac.tuwien.dmap.dmapbackend.tiss.projectdatabase.service;

import at.ac.tuwien.dmap.dmapbackend.tiss.addressbook.dto.Person;
import at.ac.tuwien.dmap.dmapbackend.tiss.projectdatabase.dto.ProjectDetails;
import at.ac.tuwien.dmap.dmapbackend.tiss.projectdatabase.dto.ProjectOverview;

import java.util.List;

public interface ProjectDatabaseService {

    List<ProjectOverview> getProjectsByOrgCriteria(String instituteOid, String projectLeadOid);

    ProjectDetails getProjectDetails(String projectId);

    List<ProjectOverview> getProjectSuggestionsForPerson(Person person);
}
