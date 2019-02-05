package at.ac.tuwien.dmap.dmapbackend.tiss.service;

import at.ac.tuwien.dmap.dmapbackend.tiss.dto.ProjectOverview;

import java.util.List;

public interface ProjectDatabaseService {

    List<ProjectOverview> getProjectsByOrgCriteria(String instituteOid, String projectLeadOid);
}
