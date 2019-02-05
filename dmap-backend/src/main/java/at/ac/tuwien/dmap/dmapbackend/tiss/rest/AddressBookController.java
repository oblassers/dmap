package at.ac.tuwien.dmap.dmapbackend.tiss.rest;

import at.ac.tuwien.dmap.dmapbackend.tiss.dto.PersonDetails;
import at.ac.tuwien.dmap.dmapbackend.tiss.service.AddressBookService;
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
        log.info("Return Person Details");
        return ResponseEntity.ok(addressBookService.getPersonDetailsById(oid));
    }
}
