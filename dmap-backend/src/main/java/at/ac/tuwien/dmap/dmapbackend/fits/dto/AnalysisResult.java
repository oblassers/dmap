package at.ac.tuwien.dmap.dmapbackend.fits.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AnalysisResult {

    @JsonProperty
    private String format;

    @JsonProperty
    private String mimeType;

    @JsonProperty
    private FormatIdentifier formatIdentifier;

    @JsonProperty
    private Long size; // in bytes

    public AnalysisResult() {
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public FormatIdentifier getFormatIdentifier() {
        return formatIdentifier;
    }

    public void setFormatIdentifier(FormatIdentifier formatIdentifier) {
        this.formatIdentifier = formatIdentifier;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}
