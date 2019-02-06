package at.ac.tuwien.dmap.dmapbackend.tiss.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * This class is used as a target for unmarshalling the XML response from the TISS API.
 */
@JacksonXmlRootElement(localName = "tuVienna", namespace = "http://tiss.tuwien.ac.at/api/schemas/projectSearchResult/v2_0")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectDetailsWrapper {

    @JsonProperty("project")
    private ProjectDetails projectDetails;

    public ProjectDetailsWrapper() {
    }

    public ProjectDetails getProjectDetails() {
        return projectDetails;
    }

    public void setProjectDetails(ProjectDetails projectDetails) {
        this.projectDetails = projectDetails;
    }
}
