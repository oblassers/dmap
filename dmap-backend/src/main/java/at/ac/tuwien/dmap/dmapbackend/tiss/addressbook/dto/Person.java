package at.ac.tuwien.dmap.dmapbackend.tiss.addressbook.dto;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * This class is used as a target for unmarshalling a client request.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("user")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
