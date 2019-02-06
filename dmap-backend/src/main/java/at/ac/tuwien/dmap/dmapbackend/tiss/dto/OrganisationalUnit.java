package at.ac.tuwien.dmap.dmapbackend.tiss.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class is used as a target for unmarshalling the JSON response from the TISS API.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganisationalUnit {

    @JsonProperty("tiss_id")
    private Long tissId;

    private String code;

    private String number;

    @JsonProperty("name_en")
    private String name;

    private String type;

    public OrganisationalUnit() {
    }

    public Long getTissId() {
        return tissId;
    }

    public void setTissId(Long tissId) {
        this.tissId = tissId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
