package at.ac.tuwien.dmap.dmapbackend.dmp.service;

import at.ac.tuwien.dmap.dmapbackend.dmp.domain.Dmp;

import java.util.List;
import java.util.Optional;

public interface DmpService {

    List<Dmp> getAllDmps();

    Dmp getDmpById(String id);
}
