package at.ac.tuwien.dmap.dmapbackend.tiss.addressbook.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * This class is used as a target for unmarshalling the JSON response from the TISS API.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganisationalUnitDetails extends OrganisationalUnit {

    private String oid;

    @JsonProperty("parent_org_ref")
    private OrganisationalUnit parentOrganisationalUnit;

    @JsonProperty("child_orgs_refs")
    private List<OrganisationalUnit> childOrganisationalUnits;

    public OrganisationalUnitDetails() {
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public OrganisationalUnit getParentOrganisationalUnit() {
        return parentOrganisationalUnit;
    }

    public void setParentOrganisationalUnit(OrganisationalUnit parentOrganisationalUnit) {
        this.parentOrganisationalUnit = parentOrganisationalUnit;
    }

    public List<OrganisationalUnit> getChildOrganisationalUnits() {
        return childOrganisationalUnits;
    }

    public void setChildOrganisationalUnits(List<OrganisationalUnit> childOrganisationalUnits) {
        this.childOrganisationalUnits = childOrganisationalUnits;
    }
}
