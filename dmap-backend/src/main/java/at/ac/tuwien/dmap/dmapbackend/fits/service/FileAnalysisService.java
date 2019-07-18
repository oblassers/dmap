package at.ac.tuwien.dmap.dmapbackend.fits.service;

import at.ac.tuwien.dmap.dmapbackend.fits.dto.generated.Fits;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileAnalysisService {

    Fits analyzeFile(MultipartFile file) throws IOException;
}
