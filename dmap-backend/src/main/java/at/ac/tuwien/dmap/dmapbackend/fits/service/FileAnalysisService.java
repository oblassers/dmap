package at.ac.tuwien.dmap.dmapbackend.fits.service;

import at.ac.tuwien.dmap.dmapbackend.fits.dto.AnalysisResult;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface FileAnalysisService {

    AnalysisResult analyzeFile(MultipartFile file) throws IOException, JAXBException;
}
