package at.ac.tuwien.dmap.dmapbackend.re3data.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * This class is used as a target for unmarshalling the XML response from the re3data API.
 * Conforms to http://schema.re3data.org/2-2/re3dataV2-2.xsd
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DatabaseLicense {

    @JacksonXmlProperty(namespace = "r3d", localName = "databaseLicenseName")
    private DatabaseLicenseNames databaseLicenseName;

    @JacksonXmlProperty(namespace = "r3d", localName = "databaseLicenseURL")
    private String databaseLicenseURL;

    public DatabaseLicense() {
    }

    public DatabaseLicenseNames getDatabaseLicenseName() {
        return databaseLicenseName;
    }

    public void setDatabaseLicenseName(DatabaseLicenseNames databaseLicenseName) {
        this.databaseLicenseName = databaseLicenseName;
    }

    public String getDatabaseLicenseURL() {
        return databaseLicenseURL;
    }

    public void setDatabaseLicenseURL(String databaseLicenseURL) {
        this.databaseLicenseURL = databaseLicenseURL;
    }
}
