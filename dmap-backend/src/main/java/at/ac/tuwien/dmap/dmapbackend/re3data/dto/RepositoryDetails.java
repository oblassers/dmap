package at.ac.tuwien.dmap.dmapbackend.re3data.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

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

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(namespace = "r3d", localName = "additionalName")
    private List<AdditionalName> additionalNames;

    @JacksonXmlProperty(namespace = "r3d", localName = "repositoryURL")
    private String repositoryUrl;

    @JacksonXmlProperty(namespace = "r3d", localName = "description")
    private String description;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(namespace = "r3d", localName = "repositoryLanguage")
    private List<String> repositoryLanguages;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(namespace = "r3d", localName = "contentType")
    private List<String> contentTypes;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(namespace = "r3d", localName = "certificate")
    private List<String> certificates;

    @JacksonXmlProperty(namespace = "r3d", localName = "databaseAccess")
    private DatabaseAccess databaseAccess;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(namespace = "r3d", localName = "dataAccess")
    private List<DataAccess> dataAccesses;

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

    public List<AdditionalName> getAdditionalNames() {
        return additionalNames;
    }

    public void setAdditionalNames(List<AdditionalName> additionalNames) {
        if(null != this.additionalNames) {
            this.additionalNames.addAll(additionalNames);
        }
        else {
            this.additionalNames = additionalNames;
        }
    }

    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    public void setRepositoryUrl(String repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public List<String> getRepositoryLanguages() {
        return repositoryLanguages;
    }

    public void setRepositoryLanguages(List<String> repositoryLanguages) {
        if(null != this.repositoryLanguages) {
            this.repositoryLanguages.addAll(repositoryLanguages);
        }
        else {
            this.repositoryLanguages = repositoryLanguages;
        }
    }

    public List<String> getContentTypes() {
        return contentTypes;
    }

    public void setContentTypes(List<String> contentTypes) {
        if(null != this.contentTypes) {
            this.contentTypes.addAll(contentTypes);
        }
        else {
            this.contentTypes = contentTypes;
        }
    }

    public List<String> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<String> certificates) {
        if(null != this.certificates) {
            this.certificates.addAll(certificates);
        }
        else {
            this.certificates = certificates;
        }
    }

    public DatabaseAccess getDatabaseAccess() {
        return databaseAccess;
    }

    public void setDatabaseAccess(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }

    public List<DataAccess> getDataAccesses() {
        return dataAccesses;
    }

    public void setDataAccesses(List<DataAccess> dataAccesses) {
        if(null != this.dataAccesses) {
            this.dataAccesses.addAll(dataAccesses);
        }
        else {
            this.dataAccesses = dataAccesses;
        }
    }
}
