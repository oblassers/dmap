package at.ac.tuwien.dmap.dmapbackend.tiss.addressbook.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * This class is used as a target for unmarshalling the JSON response from the TISS API.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonDetails {

    @JsonProperty("tiss_id")
    private Long tissId;

    private Long oid;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private String gender;

    @JsonProperty("preceding_titles")
    private String precedingTitles;

    @JsonProperty("postpositioned_titles")
    private String postpositionedTitles;

    @JsonProperty("main_email")
    private String mainEmailAddress;

    @JsonProperty("other_emails")
    private List<String> otherEmailAddresses;

    @JsonProperty("main_phone_number")
    private String phoneNumber;

    @JsonProperty("employee")
    private List<Employment> employments;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getMainEmailAddress() {
        return mainEmailAddress;
    }

    public void setMainEmailAddress(String mainEmailAddress) {
        this.mainEmailAddress = mainEmailAddress;
    }

    public List<String> getOtherEmailAddresses() {
        return otherEmailAddresses;
    }

    public void setOtherEmailAddresses(List<String> otherEmailAddresses) {
        this.otherEmailAddresses = otherEmailAddresses;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Employment> getEmployments() {
        return employments;
    }

    public void setEmployments(List<Employment> employments) {
        this.employments = employments;
    }
}
