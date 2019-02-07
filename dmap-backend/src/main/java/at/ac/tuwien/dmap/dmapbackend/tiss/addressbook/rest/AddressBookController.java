package at.ac.tuwien.dmap.dmapbackend.tiss.addressbook.rest;

import at.ac.tuwien.dmap.dmapbackend.tiss.addressbook.dto.OrganisationalUnitDetails;
import at.ac.tuwien.dmap.dmapbackend.tiss.addressbook.dto.PersonDetails;
import at.ac.tuwien.dmap.dmapbackend.tiss.addressbook.service.AddressBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/adb")
public class AddressBookController {
    private static final Logger log = LoggerFactory.getLogger(AddressBookController.class);
    private AddressBookService addressBookService;

    @Autowired
    public AddressBookController(AddressBookService addressBookService) {
        this.addressBookService = addressBookService;
    }

    @RequestMapping(value="/person/{oid}", method = RequestMethod.GET)
    public ResponseEntity<PersonDetails> getPersonDetailsByOid(
            @PathVariable(value = "oid") String oid
    ) {
        log.info("Return person details for oid=" + oid);
        return ResponseEntity.ok(addressBookService.getPersonDetailsById(oid));
    }

    @RequestMapping(value="/org/{tissId}", method = RequestMethod.GET)
    public ResponseEntity<OrganisationalUnitDetails> getOrganisationalDetailsByTissId(
            @PathVariable(value = "tissId") Long tissId
    ) {
        log.info("Return organisational unit details for tissId=" + tissId);
        return ResponseEntity.ok(addressBookService.getOrgDetailsByTissId(tissId));
    }
}
