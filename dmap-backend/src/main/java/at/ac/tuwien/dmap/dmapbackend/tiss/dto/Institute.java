package at.ac.tuwien.dmap.dmapbackend.tiss.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Institute {

    @JacksonXmlProperty(isAttribute = true)
    private String oid;

    @JsonProperty("projectCoordinator")
    private Boolean isProjectCoordinator;

    private List<ProjectMember> projectMembers;

    public Institute() {
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Boolean getProjectCoordinator() {
        return isProjectCoordinator;
    }

    public void setProjectCoordinator(Boolean projectCoordinator) {
        isProjectCoordinator = projectCoordinator;
    }

    public List<ProjectMember> getProjectMembers() {
        return projectMembers;
    }

    public void setProjectMembers(List<ProjectMember> projectMembers) {
        this.projectMembers = projectMembers;
    }
}
