package at.ac.tuwien.dmap.dmapbackend.tiss.service;

import at.ac.tuwien.dmap.dmapbackend.tiss.dto.PersonDetails;

public interface AddressBookService {

    PersonDetails getPersonDetailsById(String oid);
}
