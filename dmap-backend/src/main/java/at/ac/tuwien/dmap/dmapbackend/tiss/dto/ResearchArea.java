package at.ac.tuwien.dmap.dmapbackend.tiss.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * This class is used as a target for unmarshalling the XML response from the TISS API.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResearchArea {

    @JacksonXmlProperty(isAttribute = true)
    private String id;

    private ResearchAreaName name;

    public ResearchArea() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ResearchAreaName getName() {
        return name;
    }

    public void setName(ResearchAreaName name) {
        this.name = name;
    }
}
