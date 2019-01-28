package at.ac.tuwien.dmap.dmapbackend.dmp.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class StaffMember {

    @Id
    private String id;

    @DBRef
    private Person person;

    private List<StaffRole> roles;

    public StaffMember() {
    }

    public StaffMember(Person person, List<StaffRole> roles) {
        this.person = person;
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<StaffRole> getRoles() {
        return roles;
    }

    public void setRoles(List<StaffRole> roles) {
        this.roles = roles;
    }
}
