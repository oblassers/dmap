package at.ac.tuwien.dmap.dmapbackend.tiss.rest;

import at.ac.tuwien.dmap.dmapbackend.tiss.dto.ProjectDetails;
import at.ac.tuwien.dmap.dmapbackend.tiss.dto.ProjectOverview;
import at.ac.tuwien.dmap.dmapbackend.tiss.service.ProjectDatabaseService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;

import java.util.List;

@RestController
@RequestMapping(path = "api/pdb")
public class ProjectDatabaseController {
    private static final Logger log = LoggerFactory.getLogger(ProjectDatabaseController.class);
    private ProjectDatabaseService projectDatabaseService;

    @Autowired
    public ProjectDatabaseController(ProjectDatabaseService projectDatabaseService) {
        this.projectDatabaseService = projectDatabaseService;
    }

    @RequestMapping(value="/projectsearch", method = RequestMethod.GET)
    public ResponseEntity<List<ProjectOverview>> getProjectsByOrgCriteria(
            @RequestParam(value = "instituteOid") String instituteOid,
            @RequestParam(value = "projectleaderOid", required = false) String projectLeadOid
    ) {
        log.info(String.format("Get Projects for InstituteOid=%s and ProjectLeaderOid=%s", instituteOid, projectLeadOid));
        return ResponseEntity.ok(projectDatabaseService.getProjectsByOrgCriteria(instituteOid, projectLeadOid));
    }

    @RequestMapping(value="/project/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProjectDetails> getProjectDetails(@PathVariable("id") String projectId) {
        log.info(String.format("Get Project Details for Project ID=%s", projectId));
        return ResponseEntity.ok(projectDatabaseService.getProjectDetails(projectId));
    }
}