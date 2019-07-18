package at.ac.tuwien.dmap.dmapbackend.fits.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AnalysisResult {

    private String format;
    private String mimeType;

    public AnalysisResult() {
    }
}
