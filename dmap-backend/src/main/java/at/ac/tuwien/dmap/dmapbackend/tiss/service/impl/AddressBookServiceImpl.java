package at.ac.tuwien.dmap.dmapbackend.tiss.service.impl;

import at.ac.tuwien.dmap.dmapbackend.tiss.domain.PersonDetails;
import at.ac.tuwien.dmap.dmapbackend.tiss.service.AddressBookService;
import at.ac.tuwien.dmap.dmapbackend.tiss.service.error.TissResponseErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AddressBookServiceImpl implements AddressBookService {
    private final RestTemplate restTemplate;
    private final String addressBookBaseUrl = "https://tiss.tuwien.ac.at/api";

    @Autowired
    public AddressBookServiceImpl(RestTemplateBuilder restTemplateBuilder) {

        this.restTemplate = restTemplateBuilder.
                rootUri(addressBookBaseUrl)
                .errorHandler(new TissResponseErrorHandler())
                .build();
    }

    @Override
    public PersonDetails getPersonDetailsById(Long oid) {
        return this.restTemplate.getForObject("/person/v22/oid/{oid}", PersonDetails.class, oid);
    }
}
