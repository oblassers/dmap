package at.ac.tuwien.dmap.dmapbackend.re3data.service;

import at.ac.tuwien.dmap.dmapbackend.re3data.dto.Repository;
import at.ac.tuwien.dmap.dmapbackend.re3data.dto.RepositoryDetails;
import at.ac.tuwien.dmap.dmapbackend.re3data.dto.generated.Re3Data;

import java.util.List;

public interface RepositoryRegistryService {

    List<Repository> searchForRepositories();

    RepositoryDetails getRepositoryDetailsById(String repositoryId);

    Re3Data.Repository getRe3DataRepositoryDetailsById(String repositoryId);
}
