package at.ac.tuwien.dmap.dmapbackend.tiss.addressbook.service.impl;

import at.ac.tuwien.dmap.dmapbackend.tiss.addressbook.dto.OrganisationalUnitDetails;
import at.ac.tuwien.dmap.dmapbackend.tiss.addressbook.dto.PersonDetails;
import at.ac.tuwien.dmap.dmapbackend.tiss.addressbook.service.AddressBookService;
import at.ac.tuwien.dmap.dmapbackend.tiss.common.TissResponseErrorHandler;
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
    public PersonDetails getPersonDetailsById(String oid) {
        return this.restTemplate.getForObject("/person/v22/oid/{oid}", PersonDetails.class, oid);
    }

    @Override
    public OrganisationalUnitDetails getOrgDetailsByTissId(Long tissId) {
        return this.restTemplate.getForObject("/orgunit/v22/id/{tissId}", OrganisationalUnitDetails.class, tissId);
    }
}
