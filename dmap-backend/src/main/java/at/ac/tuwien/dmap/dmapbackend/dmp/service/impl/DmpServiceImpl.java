package at.ac.tuwien.dmap.dmapbackend.dmp.service.impl;

import at.ac.tuwien.dmap.dmapbackend.dmp.domain.Dmp;
import at.ac.tuwien.dmap.dmapbackend.dmp.repository.DmpRepository;
import at.ac.tuwien.dmap.dmapbackend.dmp.service.DmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DmpServiceImpl implements DmpService {
    private DmpRepository dmpRepository;

    @Autowired
    public DmpServiceImpl(DmpRepository dmpRepository) {
        this.dmpRepository = dmpRepository;
    }

    @Override
    public List<Dmp> getAllDmps() {
        return this.dmpRepository.findAll();
    }
}
