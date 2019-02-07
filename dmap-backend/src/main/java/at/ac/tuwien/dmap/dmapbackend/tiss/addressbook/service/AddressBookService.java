package at.ac.tuwien.dmap.dmapbackend.tiss.addressbook.service;

import at.ac.tuwien.dmap.dmapbackend.tiss.addressbook.dto.OrganisationalUnitDetails;
import at.ac.tuwien.dmap.dmapbackend.tiss.addressbook.dto.PersonDetails;

public interface AddressBookService {

    PersonDetails getPersonDetailsById(String oid);

    OrganisationalUnitDetails getOrgDetailsByTissId(Long tissId);
}
