package at.ac.tuwien.dmap.dmapbackend.tiss.rest;

import at.ac.tuwien.dmap.dmapbackend.tiss.domain.ProjectOverview;
import at.ac.tuwien.dmap.dmapbackend.tiss.service.ProjectDatabaseService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ProjectOverview>> getProjectsByOrgCriteria(
            @RequestParam(value = "projectLeadOid", required = false) String projectLeadOid,
            @RequestParam(value = "instituteOid", required = false) String instituteOid
    ) {
        // TODO: Call TISS PDB API with rest template
        return null;
    }
}
