package at.ac.tuwien.dmap.dmapbackend.re3data.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * This class is used as a target for unmarshalling the XML response from the re3data API.
 * Conforms to http://schema.re3data.org/2-2/re3dataV2-2.xsd
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataUploadLicense {

    @JacksonXmlProperty(namespace = "r3d", localName = "dataUploadLicenseName")
    private String dataUploadLicenseName;

    @JacksonXmlProperty(namespace = "r3d", localName = "dataUploadLicenseURL")
    private String dataUploadLicenseUrl;

    public DataUploadLicense() {
    }

    public String getDataUploadLicenseName() {
        return dataUploadLicenseName;
    }

    public void setDataUploadLicenseName(String dataUploadLicenseName) {
        this.dataUploadLicenseName = dataUploadLicenseName;
    }

    public String getDataUploadLicenseUrl() {
        return dataUploadLicenseUrl;
    }

    public void setDataUploadLicenseUrl(String dataUploadLicenseUrl) {
        this.dataUploadLicenseUrl = dataUploadLicenseUrl;
    }
}
