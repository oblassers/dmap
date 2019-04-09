package at.ac.tuwien.dmap.dmapbackend.re3data.service.impl;

import at.ac.tuwien.dmap.dmapbackend.re3data.dto.Repository;
import at.ac.tuwien.dmap.dmapbackend.re3data.dto.RepositoryDetails;
import at.ac.tuwien.dmap.dmapbackend.re3data.dto.RepositoryDetailsWrapper;
import at.ac.tuwien.dmap.dmapbackend.re3data.dto.RepositoryList;
import at.ac.tuwien.dmap.dmapbackend.re3data.rest.exceptions.RepositoryDetailsNotFoundException;
import at.ac.tuwien.dmap.dmapbackend.re3data.service.Re3dataResponseErrorHandler;
import at.ac.tuwien.dmap.dmapbackend.re3data.service.RepositoryRegistryService;
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

/**
 * This repository registry service implementation uses the re3data API
 */
@Service
public class RepositoryRegistryServiceImpl implements RepositoryRegistryService {
    private final RestTemplate restTemplate;
    private final String repositoryRegistryBaseUrl = "https://www.re3data.org/api";

    @Autowired
    public RepositoryRegistryServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.
                rootUri(repositoryRegistryBaseUrl)
                .errorHandler(new Re3dataResponseErrorHandler())
                .build();
    }

    //TODO: implement filter criteria
    @Override
    public List<Repository> searchForRepositories() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("/beta/repositories");

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));

        HttpEntity requestEntity = new HttpEntity<>("parameters", headers);

        ResponseEntity<RepositoryList> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                requestEntity,
                RepositoryList.class);

        return response.getBody().getRepositories();
    }

    @Override
    public RepositoryDetails getRepositoryDetailsById(String repositoryId) {
        Map<String, Object> variables = new HashMap<String, Object>() {{
            put("repositoryId", repositoryId);
        }};

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("/beta/repository/{repositoryId}")
                .uriVariables(variables);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));

        HttpEntity requestEntity = new HttpEntity<>("parameters", headers);

        ResponseEntity<RepositoryDetailsWrapper> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                requestEntity,
                RepositoryDetailsWrapper.class);

        RepositoryDetails repositoryDetails = response.getBody().getRepositoryDetails();

        if(null == repositoryDetails) {
            throw new RepositoryDetailsNotFoundException(
                    String.format("Repository details for repository ID %s not found.", repositoryId));
        }

        return repositoryDetails;
    }
}
