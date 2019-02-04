package at.ac.tuwien.dmap.dmapbackend.tiss.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PersonDetails {

    @JsonProperty("tiss_id")
    private Long tissId;

    private Long oid;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("preceding_titles")
    private String precedingTitles;

    @JsonProperty("postpositioned_titles")
    private String postpositionedTitles;

    @JsonProperty("main_email")
    private String email;

    @JsonProperty("main_phone_number")
    private String phoneNumber;

    public PersonDetails() {
    }

    public Long getTissId() {
        return tissId;
    }

    public void setTissId(Long tissId) {
        this.tissId = tissId;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
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

    public String getPrecedingTitles() {
        return precedingTitles;
    }

    public void setPrecedingTitles(String precedingTitles) {
        this.precedingTitles = precedingTitles;
    }

    public String getPostpositionedTitles() {
        return postpositionedTitles;
    }

    public void setPostpositionedTitles(String postpositionedTitles) {
        this.postpositionedTitles = postpositionedTitles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
