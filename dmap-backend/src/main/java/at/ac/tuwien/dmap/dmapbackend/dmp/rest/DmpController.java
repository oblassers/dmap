package at.ac.tuwien.dmap.dmapbackend.dmp.rest;

import at.ac.tuwien.dmap.dmapbackend.dmp.domain.Dmp;
import at.ac.tuwien.dmap.dmapbackend.dmp.rest.exceptions.DmpNotFoundException;
import at.ac.tuwien.dmap.dmapbackend.dmp.service.DmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/dmps")
public class DmpController {
    private static final Logger log = LoggerFactory.getLogger(DmpController.class);
    private DmpService dmpService;

    @Autowired
    public DmpController(DmpService dmpService) {
        this.dmpService = dmpService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Dmp>> getDmps() {
        log.info("Return all DMPs");
        return new ResponseEntity<>(dmpService.getAllDmps(), HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Dmp> getDmpById(@PathVariable String id) {
        Dmp dmp = dmpService.getDmpById(id);

        log.info("Find DMP with ID: " + id);
        if(null == dmp) {
            throw new DmpNotFoundException();
        }
        return ResponseEntity.ok(dmp);
    }

    public static final String HELLO_TEXT = "Hello from Spring Boot Backend!";

    @RequestMapping(path = "/hello")
    public @ResponseBody
    String sayHello() {
        log.info("GET called on /hello resource");
        return HELLO_TEXT;
    }
}
