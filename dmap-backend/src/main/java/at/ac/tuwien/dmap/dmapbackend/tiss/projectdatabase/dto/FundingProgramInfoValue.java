package at.ac.tuwien.dmap.dmapbackend.tiss.projectdatabase.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class is used as a target for unmarshalling the XML response from the TISS API.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FundingProgramInfoValue {

    @JsonProperty("en")
    private String englishValue;

    @JsonProperty("de")
    private String germanValue;

    public FundingProgramInfoValue() {
    }

    public String getEnglishValue() {
        return englishValue;
    }

    public void setEnglishValue(String englishValue) {
        this.englishValue = englishValue;
    }

    public String getGermanValue() {
        return germanValue;
    }

    public void setGermanValue(String germanValue) {
        this.germanValue = germanValue;
    }
}
