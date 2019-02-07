package at.ac.tuwien.dmap.dmapbackend.tiss.projectdatabase.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class is used as a target for unmarshalling the XML response from the TISS API.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FundingType {

    @JsonProperty("en")
    private String englischType;

    @JsonProperty("de")
    private String germanType;

    public FundingType() {
    }

    public String getEnglischType() {
        return englischType;
    }

    public void setEnglischType(String englischType) {
        this.englischType = englischType;
    }

    public String getGermanType() {
        return germanType;
    }

    public void setGermanType(String germanType) {
        this.germanType = germanType;
    }
}
