package at.ac.tuwien.dmap.dmapbackend.tiss.projectdatabase.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * This class is used as a target for unmarshalling the XML response from the TISS API.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FundingProgramInfo {

    @JacksonXmlProperty(isAttribute = true)
    private String infoTypeCode;

    @JsonProperty("infoValue")
    private FundingProgramInfoValue value;

    @JsonProperty("infoTag")
    private FundingProgramInfoTag tag;

    public FundingProgramInfo() {
    }

    public String getInfoTypeCode() {
        return infoTypeCode;
    }

    public void setInfoTypeCode(String infoTypeCode) {
        this.infoTypeCode = infoTypeCode;
    }

    public FundingProgramInfoValue getValue() {
        return value;
    }

    public void setValue(FundingProgramInfoValue value) {
        this.value = value;
    }

    public FundingProgramInfoTag getTag() {
        return tag;
    }

    public void setTag(FundingProgramInfoTag tag) {
        this.tag = tag;
    }
}
