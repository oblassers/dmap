package at.ac.tuwien.dmap.dmapbackend.tiss.projectdatabase.dto;

import at.ac.tuwien.dmap.dmapbackend.tiss.addressbook.dto.PersonDetails;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectMemberDetails {

    private String roleInProject;

    private PersonDetails personDetails;

    public ProjectMemberDetails() {
    }

    public String getRoleInProject() {
        return roleInProject;
    }

    public void setRoleInProject(String roleInProject) {
        this.roleInProject = roleInProject;
    }

    public PersonDetails getPersonDetails() {
        return personDetails;
    }

    public void setPersonDetails(PersonDetails personDetails) {
        this.personDetails = personDetails;
    }

    public static ProjectMemberDetails fromProjectMemberAndPersonDetails(ProjectMember projectMember, PersonDetails personDetails) {
        ProjectMemberDetails pmd = new ProjectMemberDetails();
        pmd.setRoleInProject(projectMember.getRole());
        pmd.setPersonDetails(personDetails);
        return pmd;
    }
}
