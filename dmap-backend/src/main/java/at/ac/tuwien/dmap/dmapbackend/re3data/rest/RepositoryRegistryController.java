package at.ac.tuwien.dmap.dmapbackend.re3data.rest;

import at.ac.tuwien.dmap.dmapbackend.re3data.dto.Repository;
import at.ac.tuwien.dmap.dmapbackend.re3data.dto.RepositoryDetails;
import at.ac.tuwien.dmap.dmapbackend.re3data.service.RepositoryRegistryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/repository_registry")
public class RepositoryRegistryController {
    private static final Logger log = LoggerFactory.getLogger(RepositoryRegistryController.class);
    private RepositoryRegistryService repositoryRegistryService;

    @Autowired
    public RepositoryRegistryController(RepositoryRegistryService repositoryRegistryService) {
        this.repositoryRegistryService = repositoryRegistryService;
    }

    //TODO: implement filter parameters
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<List<Repository>> getMatchingRepositories() {
        log.info("Get repositories from registry");
        return ResponseEntity.ok(repositoryRegistryService.searchForRepositories());
    }

    @RequestMapping(value = "/repository/{id}", method = RequestMethod.GET)
    public ResponseEntity<RepositoryDetails> getRepositoryDetails(@PathVariable("id") String repositoryId) {
        log.info(String.format("Get repository details for ID=%s", repositoryId));
        return ResponseEntity.ok(repositoryRegistryService.getRepositoryDetailsById(repositoryId));
    }
}
