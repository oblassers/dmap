package at.ac.tuwien.dmap.dmapbackend.re3data.rest;

import at.ac.tuwien.dmap.dmapbackend.re3data.dto.Repository;
import at.ac.tuwien.dmap.dmapbackend.re3data.dto.RepositoryDetails;
import at.ac.tuwien.dmap.dmapbackend.re3data.dto.generated.Re3Data;
import at.ac.tuwien.dmap.dmapbackend.re3data.service.RepositoryRegistryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Repository>> getMatchingRepositories(
            @RequestParam MultiValueMap<String, String> allParameters) {
        log.info("Get repositories from registry matching search query: " + allParameters.entrySet());
        return ResponseEntity.ok(repositoryRegistryService.searchForRepositories(allParameters));
    }

    @RequestMapping(value = "/repository/{id}", method = RequestMethod.GET)
    public ResponseEntity<RepositoryDetails> getRepositoryDetails(@PathVariable("id") String repositoryId) {
        log.info(String.format("Get repository details for ID=%s", repositoryId));
        return ResponseEntity.ok(repositoryRegistryService.getRepositoryDetailsById(repositoryId));
    }

    @RequestMapping(value = "/re3data_repository/{id}", method = RequestMethod.GET)
    public ResponseEntity<Re3Data.Repository> getRe3DataRepositoryDetails(@PathVariable("id") String repositoryId) {
        log.info(String.format("Get repository details for ID=%s", repositoryId));
        return ResponseEntity.ok(repositoryRegistryService.getRe3DataRepositoryDetailsById(repositoryId));
    }
}
