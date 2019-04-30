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

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(namespace = "r3d", localName = "repositoryIdentifier")
    private List<String> repositoryIdentifiers;

    @JacksonXmlProperty(namespace = "r3d", localName = "description")
    private String description;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(namespace = "r3d", localName = "repositoryContact")
    private List<String> repositoryContacts;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(namespace = "r3d", localName = "type")
    private List<RepositoryTypes> repositoryTypes;

    @JacksonXmlProperty(namespace = "r3d", localName = "size")
    private RepositorySize repositorySize;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(namespace = "r3d", localName = "repositoryLanguage")
    private List<String> repositoryLanguages;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(namespace = "r3d", localName = "subject")
    private List<Subject> subjects;

    @JacksonXmlProperty(namespace = "r3d", localName = "missionStatementURL")
    private String missionStatementUrl;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(namespace = "r3d", localName = "contentType")
    private List<String> contentTypes;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(namespace = "r3d", localName = "providerType")
    private List<ProviderTypes> providerTypes;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(namespace = "r3d", localName = "keyword")
    private List<String> keywords;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(namespace = "r3d", localName = "certificate")
    private List<String> certificates;

    @JacksonXmlProperty(namespace = "r3d", localName = "databaseAccess")
    private DatabaseAccess databaseAccess;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(namespace = "r3d", localName = "dataAccess")
    private List<DataAccess> dataAccesses;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(namespace = "r3d", localName = "dataUpload")
    private List<DataUpload> dataUpload;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(namespace = "r3d", localName = "pidSystem")
    private List<PidSystems> pidSystems;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(namespace = "r3d", localName = "aidSystem")
    private List<AidSystems> aidSystems;

    @JacksonXmlProperty(namespace = "r3d", localName = "enhancedPublication")
    private YesNoUnknown enhancedPublication;

    @JacksonXmlProperty(namespace = "r3d", localName = "qualityManagement")
    private YesNoUnknown qualityManagement;

    @JacksonXmlProperty(namespace = "r3d", localName = "versioning")
    private YesNo versioning;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(namespace = "r3d", localName = "metadataStandard")
    private List<MetadataStandard> metadataStandards;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(namespace = "r3d", localName = "dataLicense")
    private List<DataLicense> dataLicenses;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(namespace = "r3d", localName = "dataUploadLicense")
    private List<DataUploadLicense> dataUploadLicenses;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(namespace = "r3d", localName = "databaseLicense")
    private List<DatabaseLicense> databaseLicenses;

    @JacksonXmlProperty(namespace = "r3d", localName = "remarks")
    private String remarks;

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

    public List<String> getRepositoryIdentifiers() {
        return repositoryIdentifiers;
    }

    public void setRepositoryIdentifiers(List<String> repositoryIdentifiers) {
        if(null != this.repositoryIdentifiers){
            this.repositoryIdentifiers.addAll(repositoryIdentifiers);
        }
        else {
            this.repositoryIdentifiers = repositoryIdentifiers;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getRepositoryContacts() {
        return repositoryContacts;
    }

    public void setRepositoryContacts(List<String> repositoryContacts) {
        if(null != this.repositoryContacts){
            this.repositoryContacts.addAll(repositoryContacts);
        }
        else {
            this.repositoryContacts = repositoryContacts;
        }
    }

    public List<RepositoryTypes> getRepositoryTypes() {
        return repositoryTypes;
    }

    public void setRepositoryTypes(List<RepositoryTypes> repositoryTypes) {
        if(null != this.repositoryTypes) {
            this.repositoryTypes.addAll(repositoryTypes);
        }
        else {
            this.repositoryTypes = repositoryTypes;
        }
    }

    public RepositorySize getRepositorySize() {
        return repositorySize;
    }

    public void setRepositorySize(RepositorySize repositorySize) {
        this.repositorySize = repositorySize;
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

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        if(null != this.subjects) {
            this.subjects.addAll(subjects);
        }
        else {
            this.subjects = subjects;
        }
    }

    public String getMissionStatementUrl() {
        return missionStatementUrl;
    }

    public void setMissionStatementUrl(String missionStatementUrl) {
        this.missionStatementUrl = missionStatementUrl;
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

    public List<ProviderTypes> getProviderTypes() {
        return providerTypes;
    }

    public void setProviderTypes(List<ProviderTypes> providerTypes) {
        if(null != this.providerTypes) {
            this.providerTypes.addAll(providerTypes);
        }
        else {
            this.providerTypes = providerTypes;
        }
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        if(null != this.keywords){
            this.keywords.addAll(keywords);
        }
        else {
            this.keywords = keywords;
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

    public List<DataUpload> getDataUpload() {
        return dataUpload;
    }

    public void setDataUpload(List<DataUpload> dataUpload) {
        if(null != this.dataUpload) {
            this.dataUpload.addAll(dataUpload);
        }
        else {
            this.dataUpload = dataUpload;
        }
    }

    public List<PidSystems> getPidSystems() {
        return pidSystems;
    }

    public void setPidSystems(List<PidSystems> pidSystems) {
        if(null != this.pidSystems) {
            this.pidSystems.addAll(pidSystems);
        }
        else {
            this.pidSystems = pidSystems;
        }
    }

    public List<AidSystems> getAidSystems() {
        return aidSystems;
    }

    public void setAidSystems(List<AidSystems> aidSystems) {
        if(null != this.aidSystems) {
            this.aidSystems.addAll(aidSystems);
        }
        else {
            this.aidSystems = aidSystems;
        }
    }

    public YesNoUnknown getEnhancedPublication() {
        return enhancedPublication;
    }

    public void setEnhancedPublication(YesNoUnknown enhancedPublication) {
        this.enhancedPublication = enhancedPublication;
    }

    public YesNoUnknown getQualityManagement() {
        return qualityManagement;
    }

    public void setQualityManagement(YesNoUnknown qualityManagement) {
        this.qualityManagement = qualityManagement;
    }

    public YesNo getVersioning() {
        return versioning;
    }

    public void setVersioning(YesNo versioning) {
        this.versioning = versioning;
    }

    public List<MetadataStandard> getMetadataStandards() {
        return metadataStandards;
    }

    public void setMetadataStandards(List<MetadataStandard> metadataStandards) {
        if(null != this.metadataStandards) {
            this.metadataStandards.addAll(metadataStandards);
        }
        else {
            this.metadataStandards = metadataStandards;
        }
    }

    public List<DataLicense> getDataLicenses() {
        return dataLicenses;
    }

    public void setDataLicenses(List<DataLicense> dataLicenses) {
        if(null != this.dataLicenses) {
            this.dataLicenses.addAll(dataLicenses);
        }
        else {
            this.dataLicenses = dataLicenses;
        }
    }

    public List<DataUploadLicense> getDataUploadLicenses() {
        return dataUploadLicenses;
    }

    public void setDataUploadLicenses(List<DataUploadLicense> dataUploadLicenses) {
        if(null != this.dataUploadLicenses) {
            this.dataUploadLicenses.addAll(dataUploadLicenses);
        }
        else {
            this.dataUploadLicenses = dataUploadLicenses;
        }
    }

    public List<DatabaseLicense> getDatabaseLicenses() {
        return databaseLicenses;
    }

    public void setDatabaseLicenses(List<DatabaseLicense> databaseLicenses) {
        if(null != this.databaseLicenses) {
            this.databaseLicenses.addAll(databaseLicenses);
        }
        else {
            this.databaseLicenses = databaseLicenses;
        }
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
