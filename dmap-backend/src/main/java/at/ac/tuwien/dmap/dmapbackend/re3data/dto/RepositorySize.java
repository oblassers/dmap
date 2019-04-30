package at.ac.tuwien.dmap.dmapbackend.re3data.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import java.util.List;

/**
 * This class is used as a target for unmarshalling the XML response from the re3data API.
 * Conforms to http://schema.re3data.org/2-2/re3dataV2-2.xsd
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositorySize {

    @JacksonXmlProperty(isAttribute = true)
    private String updated;

    @JacksonXmlText
    private String size;

    public RepositorySize() {
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
