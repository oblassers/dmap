package at.ac.tuwien.dmap.dmapbackend.tiss.projectdatabase.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class is used as a target for unmarshalling the XML response from the TISS API.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectTitle {

    @JsonProperty("en")
    private String englishTitle;

    @JsonProperty("de")
    private String germanTitle;

    public ProjectTitle() {
    }

    public String getEnglishTitle() {
        return englishTitle;
    }

    public void setEnglishTitle(String englishTitle) {
        this.englishTitle = englishTitle;
    }

    public String getGermanTitle() {
        return germanTitle;
    }

    public void setGermanTitle(String germanTitle) {
        this.germanTitle = germanTitle;
    }
}
