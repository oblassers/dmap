package at.ac.tuwien.dmap.dmapbackend.dmp.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document
public class Dmp {

    @Id
    private String id;

    @CreatedDate
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime lastUpdate;

    @DBRef
    private StaffMember contactPerson;

    @DBRef
    private List<StaffMember> dataManagementStaff;

    @DBRef
    private List<Project> researchProjects;

    public Dmp() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public StaffMember getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(StaffMember contactPerson) {
        this.contactPerson = contactPerson;
    }

    public List<StaffMember> getDataManagementStaff() {
        return dataManagementStaff;
    }

    public void setDataManagementStaff(List<StaffMember> dataManagementStaff) {
        this.dataManagementStaff = dataManagementStaff;
    }

    public List<Project> getResearchProjects() {
        return researchProjects;
    }

    public void setResearchProjects(List<Project> researchProjects) {
        this.researchProjects = researchProjects;
    }
}
