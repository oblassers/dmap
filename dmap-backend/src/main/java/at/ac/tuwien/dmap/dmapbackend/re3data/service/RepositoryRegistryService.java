package at.ac.tuwien.dmap.dmapbackend.re3data.service;

import at.ac.tuwien.dmap.dmapbackend.re3data.dto.Repository;
import at.ac.tuwien.dmap.dmapbackend.re3data.dto.RepositoryDetails;
import at.ac.tuwien.dmap.dmapbackend.re3data.dto.generated.Re3Data;
import org.springframework.util.MultiValueMap;

import java.util.List;

public interface RepositoryRegistryService {

    List<Repository> searchForRepositories(MultiValueMap<String, String> queryParameters);

    RepositoryDetails getRepositoryDetailsById(String repositoryId);
}
