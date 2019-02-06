package at.ac.tuwien.dmap.dmapbackend.tiss.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class is used as a target for unmarshalling the JSON response from the TISS API.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employment {

    private String function;

    @JsonProperty("org_ref")
    private OrganisationalUnit organisationalUnit;

    public Employment() {
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public OrganisationalUnit getOrganisationalUnit() {
        return organisationalUnit;
    }

    public void setOrganisationalUnit(OrganisationalUnit organisationalUnit) {
        this.organisationalUnit = organisationalUnit;
    }
}
