package at.ac.tuwien.dmap.dmapbackend.tiss.projectdatabase.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

/**
 * This class is used as a target for unmarshalling the XML response from the TISS API.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectDetails {

    @JacksonXmlProperty(isAttribute = true)
    private String id;

    private String shortDescription;

    private ProjectTitle title;

    private String projectBegin;

    private String projectEnd;

    @JsonProperty("abstract")
    private ProjectAbstract projectAbstract;

    private List<Institute> institutes;

    private List<ResearchArea> researchAreas;

    private List<FundingSource> financiers;

    public ProjectDetails() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public ProjectTitle getTitle() {
        return title;
    }

    public void setTitle(ProjectTitle title) {
        this.title = title;
    }

    public String getProjectBegin() {
        return projectBegin;
    }

    public void setProjectBegin(String projectBegin) {
        this.projectBegin = projectBegin;
    }

    public String getProjectEnd() {
        return projectEnd;
    }

    public void setProjectEnd(String projectEnd) {
        this.projectEnd = projectEnd;
    }

    public ProjectAbstract getProjectAbstract() {
        return projectAbstract;
    }

    public void setProjectAbstract(ProjectAbstract projectAbstract) {
        this.projectAbstract = projectAbstract;
    }

    public List<Institute> getInstitutes() {
        return institutes;
    }

    public void setInstitutes(List<Institute> institutes) {
        this.institutes = institutes;
    }

    public List<ResearchArea> getResearchAreas() {
        return researchAreas;
    }

    public void setResearchAreas(List<ResearchArea> researchAreas) {
        this.researchAreas = researchAreas;
    }

    public List<FundingSource> getFinanciers() {
        return financiers;
    }

    public void setFinanciers(List<FundingSource> financiers) {
        this.financiers = financiers;
    }
}
