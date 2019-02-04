package at.ac.tuwien.dmap.dmapbackend.tiss.domain;

public class ProjectOverview {

    private String projectId;
    private String shortDescription;
    private String title;
    private String begin;
    private String end;
    private String orgunit;

    public ProjectOverview() {
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getOrgunit() {
        return orgunit;
    }

    public void setOrgunit(String orgunit) {
        this.orgunit = orgunit;
    }
}
