package at.ac.tuwien.dmap.dmapbackend.tiss.service.impl;

import at.ac.tuwien.dmap.dmapbackend.tiss.dto.ProjectOverview;
import at.ac.tuwien.dmap.dmapbackend.tiss.service.ProjectDatabaseService;
import at.ac.tuwien.dmap.dmapbackend.tiss.service.error.TissResponseErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class ProjectDatabaseServiceImpl implements ProjectDatabaseService {
    private final RestTemplate restTemplate;
    private final String addressBookBaseUrl = "https://tiss.tuwien.ac.at/api/pdb/rest";

    @Autowired
    public ProjectDatabaseServiceImpl(RestTemplateBuilder restTemplateBuilder) {

        this.restTemplate = restTemplateBuilder.
                rootUri(addressBookBaseUrl)
                .errorHandler(new TissResponseErrorHandler())
                .build();
    }

    @Override
    public List<ProjectOverview> getProjectsByOrgCriteria(String instituteOid, String projectLeadOid) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("/projectsearch/v2")
                .queryParam("instituteOid", instituteOid);

        if (null != projectLeadOid) {
            builder.queryParam("projectleaderOid", projectLeadOid);
        }

        ResponseEntity<List<ProjectOverview>> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ProjectOverview>>(){});

        return response.getBody();
    }
}
