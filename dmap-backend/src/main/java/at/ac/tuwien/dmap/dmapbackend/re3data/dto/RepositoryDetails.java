package at.ac.tuwien.dmap.dmapbackend.re3data.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * This class is used as a target for unmarshalling the XML response from the re3data API.
 * Conforms to http://schema.re3data.org/2-2/re3dataV2-2.xsd
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoryDetails {

    @JacksonXmlProperty(namespace = "r3d", localName = "re3data.orgIdentifier")
    private String repositoryId;

    @JacksonXmlProperty(namespace = "r3d", localName = "repositoryName")
    private RepositoryName repositoryName;

    @JacksonXmlProperty(namespace = "r3d", localName = "repositoryURL")
    private String repositoryUrl;

    public RepositoryDetails() {
    }

    public String getRepositoryId() {
        return repositoryId;
    }

    public void setRepositoryId(String repositoryId) {
        this.repositoryId = repositoryId;
    }

    public RepositoryName getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(RepositoryName repositoryName) {
        this.repositoryName = repositoryName;
    }

    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    public void setRepositoryUrl(String repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
    }
}
