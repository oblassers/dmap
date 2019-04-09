package at.ac.tuwien.dmap.dmapbackend.re3data.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * This class is used as a target for unmarshalling the XML response from the re3data API.
 * Conforms to http://schema.re3data.org/2-2/re3dataV2-2.xsd
 */
@JacksonXmlRootElement(namespace = "r3d", localName = "re3data")
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoryDetailsWrapper {

    @JacksonXmlProperty(namespace = "r3d:re3data", localName = "repository")
    private RepositoryDetails repositoryDetails;

    public RepositoryDetailsWrapper() {
    }

    public RepositoryDetails getRepositoryDetails() {
        return repositoryDetails;
    }

    public void setRepositoryDetails(RepositoryDetails repositoryDetails) {
        this.repositoryDetails = repositoryDetails;
    }
}
