package at.ac.tuwien.dmap.dmapbackend.tiss.addressbook.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * This class is used as a target for unmarshalling a client request.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

    private String oid;

    private String firstName;

    private String lastName;

    @JsonProperty("orgs")
    private List<OrganisationalUnit> organisationalUnits;

    public Person() {
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<OrganisationalUnit> getOrganisationalUnits() {
        return organisationalUnits;
    }

    public void setOrganisationalUnits(List<OrganisationalUnit> organisationalUnits) {
        this.organisationalUnits = organisationalUnits;
    }
}
