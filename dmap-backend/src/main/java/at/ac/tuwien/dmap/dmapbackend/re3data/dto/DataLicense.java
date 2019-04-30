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
public class DataLicense {

    @JacksonXmlProperty(namespace = "r3d", localName = "dataLicenseName")
    private DataLicenseNames dataLicenseName;

    @JacksonXmlProperty(namespace = "r3d", localName = "dataLicenseURL")
    private String dataLicenseUrl;

    public DataLicense() {
    }

    public DataLicenseNames getDataLicenseName() {
        return dataLicenseName;
    }

    public void setDataLicenseName(DataLicenseNames dataLicenseName) {
        this.dataLicenseName = dataLicenseName;
    }

    public String getDataLicenseUrl() {
        return dataLicenseUrl;
    }

    public void setDataLicenseUrl(String dataLicenseUrl) {
        this.dataLicenseUrl = dataLicenseUrl;
    }
}
