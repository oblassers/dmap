package at.ac.tuwien.dmap.dmapbackend.fits.rest;

import at.ac.tuwien.dmap.dmapbackend.fits.dto.generated.Fits;
import at.ac.tuwien.dmap.dmapbackend.fits.service.FileAnalysisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(path = "api/file-analysis")
public class FileAnalysisController {
    private static final Logger log = LoggerFactory.getLogger(FileAnalysisController.class);
    private FileAnalysisService fileAnalysisService;

    @Autowired
    public FileAnalysisController(FileAnalysisService fileAnalysisService) {
        this.fileAnalysisService = fileAnalysisService;
    }

    @RequestMapping(value = "/examine", method = RequestMethod.POST)
    public ResponseEntity<Fits> examineFile(
            @RequestParam(value = "file", required = true) MultipartFile file
    ) throws IOException {
        log.info(String.format("Examine file %s (%d bytes), type: %s",
                file.getOriginalFilename(), file.getSize(), file.getContentType()));
        return ResponseEntity.ok(fileAnalysisService.analyzeFile(file));
    }
}
