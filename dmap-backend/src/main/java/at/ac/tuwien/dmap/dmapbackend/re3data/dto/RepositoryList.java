package at.ac.tuwien.dmap.dmapbackend.re3data.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

/**
 * This class is used as a target for unmarshalling the XML response from the re3data API.
 */
@JacksonXmlRootElement(localName = "list")
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoryList {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JsonProperty("repository")
    private List<Repository> repositories;

    public RepositoryList() {
    }

    public List<Repository> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<Repository> repositories) {
        this.repositories = repositories;
    }
}
