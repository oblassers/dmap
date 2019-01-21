package at.ac.tuwien.dmap.dmapbackend.dmp.controller;

import at.ac.tuwien.dmap.dmapbackend.dmp.domain.Dmp;
import at.ac.tuwien.dmap.dmapbackend.dmp.service.DmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/dmps")
public class DmpController {
    private DmpService dmpService;

    @Autowired
    public DmpController(DmpService dmpService) {
        this.dmpService = dmpService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Dmp>> getDmps() {
        return new ResponseEntity<List<Dmp>>(dmpService.getAllDmps(), HttpStatus.OK);
    }
}