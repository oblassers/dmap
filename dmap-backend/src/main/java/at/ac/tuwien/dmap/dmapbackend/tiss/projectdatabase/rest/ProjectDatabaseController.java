package at.ac.tuwien.dmap.dmapbackend.tiss.projectdatabase.rest;

import at.ac.tuwien.dmap.dmapbackend.tiss.addressbook.dto.Person;
import at.ac.tuwien.dmap.dmapbackend.tiss.projectdatabase.dto.ProjectDetails;
import at.ac.tuwien.dmap.dmapbackend.tiss.projectdatabase.dto.ProjectOverview;
import at.ac.tuwien.dmap.dmapbackend.tiss.projectdatabase.service.ProjectDatabaseService;
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

    @RequestMapping(value = "/search_projects", method = RequestMethod.GET)
    public ResponseEntity<List<ProjectOverview>> getProjectsByOrgCriteria(
            @RequestParam(value = "instituteOid") String instituteOid,
            @RequestParam(value = "projectleaderOid", required = false) String projectLeadOid
    ) {
        log.info(String.format("Get projects for instituteOid=%s and projectLeaderOid=%s", instituteOid, projectLeadOid));
        return ResponseEntity.ok(projectDatabaseService.getProjectsByOrgCriteria(instituteOid, projectLeadOid));
    }

    @RequestMapping(value = "/suggest_projects", method = RequestMethod.POST)
    public ResponseEntity<List<ProjectOverview>> getProjectSuggestionsForPerson(@RequestBody Person person) {
        log.info(String.format("Get project suggestions for person: %s", person));
        return ResponseEntity.ok(projectDatabaseService.getProjectSuggestionsForPerson(person));
    }

    @RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProjectDetails> getProjectDetails(@PathVariable("id") String projectId) {
        log.info(String.format("Get Project Details for Project ID=%s", projectId));
        return ResponseEntity.ok(projectDatabaseService.getProjectDetails(projectId));
    }
}
