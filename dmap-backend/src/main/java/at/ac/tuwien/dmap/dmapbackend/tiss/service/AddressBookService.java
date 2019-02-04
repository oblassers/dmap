package at.ac.tuwien.dmap.dmapbackend.tiss.service;

import at.ac.tuwien.dmap.dmapbackend.tiss.domain.PersonDetails;

public interface AddressBookService {

    PersonDetails getPersonDetailsById(Long oid);
}
