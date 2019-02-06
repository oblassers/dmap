package at.ac.tuwien.dmap.dmapbackend.tiss.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectAbstract {

    @JsonProperty("en")
    private String englishAbstract;

    @JsonProperty("de")
    private String germanAbstract;

    public ProjectAbstract() {
    }

    public String getEnglishAbstract() {
        return englishAbstract;
    }

    public void setEnglishAbstract(String englishAbstract) {
        this.englishAbstract = englishAbstract;
    }

    public String getGermanAbstract() {
        return germanAbstract;
    }

    public void setGermanAbstract(String germanAbstract) {
        this.germanAbstract = germanAbstract;
    }
}
