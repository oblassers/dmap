package at.ac.tuwien.dmap.dmapbackend.fits.service.impl;

import at.ac.tuwien.dmap.dmapbackend.fits.dto.generated.Fits;
import at.ac.tuwien.dmap.dmapbackend.fits.service.FileAnalysisService;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

@Service
public class FileAnalysisServiceImpl implements FileAnalysisService {
    private static final Logger log = LoggerFactory.getLogger(FileAnalysisServiceImpl.class);
    private final RestTemplate restTemplate;

    @Autowired
    public FileAnalysisServiceImpl(RestTemplateBuilder restTemplateBuilder, Environment environment) {
        this.restTemplate = restTemplateBuilder
                .rootUri(environment.getProperty("fits.uri"))
                .build();

        // register the JAXB annotations module to the XML object mappers, so it can understand JAXB annotations
        JaxbAnnotationModule jaxbAnnotationModule = new JaxbAnnotationModule();
        this.restTemplate.getMessageConverters().forEach(httpMessageConverter -> {
            if(httpMessageConverter instanceof MappingJackson2XmlHttpMessageConverter) {
                ((MappingJackson2XmlHttpMessageConverter) httpMessageConverter).getObjectMapper().
                        registerModule(jaxbAnnotationModule);
            }
        });
    }

    @Override
    public Fits analyzeFile(MultipartFile file) throws IOException {
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

        ResponseEntity<Fits> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.POST,
                requestEntity,
                Fits.class);

        return response.getBody();
    }
}
