package at.ac.tuwien.dmap.dmapbackend.tiss.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FundingProgramInfoTag {

    @JsonProperty("en")
    private String englishTag;

    @JsonProperty("de")
    private String germanTag;

    public FundingProgramInfoTag() {
    }

    public String getEnglishTag() {
        return englishTag;
    }

    public void setEnglishTag(String englishTag) {
        this.englishTag = englishTag;
    }

    public String getGermanTag() {
        return germanTag;
    }

    public void setGermanTag(String germanTag) {
        this.germanTag = germanTag;
    }
}
