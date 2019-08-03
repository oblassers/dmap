package at.ac.tuwien.dmap.dmapbackend.fits.service.impl;

import at.ac.tuwien.dmap.dmapbackend.fits.dto.AnalysisResult;
import at.ac.tuwien.dmap.dmapbackend.fits.dto.generated.Fits;
import at.ac.tuwien.dmap.dmapbackend.fits.dto.generated.ObjectFactory;
import at.ac.tuwien.dmap.dmapbackend.fits.dto.mapper.impl.FitsMapper;
import at.ac.tuwien.dmap.dmapbackend.fits.service.FileAnalysisService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;

@Service
public class FileAnalysisServiceImpl implements FileAnalysisService {
    private static final Logger log = LoggerFactory.getLogger(FileAnalysisServiceImpl.class);
    private final RestTemplate restTemplate;
    private final Unmarshaller unmarshaller;

    @Autowired
    private FitsMapper fitsMapper;

    @Autowired
    public FileAnalysisServiceImpl(RestTemplateBuilder restTemplateBuilder, Environment environment) throws JAXBException {
        restTemplate = restTemplateBuilder
                .rootUri(environment.getProperty("fits.uri"))
                .build();

        JAXBContext context = JAXBContext.newInstance(ObjectFactory.class);
        unmarshaller = context.createUnmarshaller();
    }

    @Override
    public AnalysisResult analyzeFile(MultipartFile file) throws IOException, JAXBException {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("/fits/examine");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, String> fileMap = new LinkedMultiValueMap<>();
        ContentDisposition contentDisposition = ContentDisposition.builder("form-data")
                .name("datafile").filename(file.getOriginalFilename()).build();
        fileMap.add(HttpHeaders.CONTENT_DISPOSITION, contentDisposition.toString());
        HttpEntity<byte[]> fileEntity = new HttpEntity<>(file.getBytes(), fileMap);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("datafile", fileEntity);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.POST,
                requestEntity,
                String.class);

        return fitsMapper.fromDTO((Fits) unmarshaller.unmarshal(new StringReader(response.getBody())));
    }
}
