package at.ac.tuwien.dmap.dmapbackend.tiss.projectdatabase.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used as a target for unmarshalling the XML response from the TISS API.
 */
@JacksonXmlRootElement(localName = "tuVienna", namespace = "http://tiss.tuwien.ac.at/api/schemas/projectSearchResult/v2_0")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectOverviewList {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JsonProperty("project")
    private List<ProjectOverview> projects;

    public ProjectOverviewList() {
        projects = new ArrayList<>();
    }

    public List<ProjectOverview> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectOverview> projects) {
        this.projects = projects;
    }
}
