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
public class DataUpload {

    @JacksonXmlProperty(namespace = "r3d", localName = "dataUploadType")
    private AccessTypes dataUploadType;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(namespace = "r3d", localName = "dataUploadRestriction")
    private List<DataUploadRestrictions> dataUploadRestrictions;

    public DataUpload() {
    }

    public AccessTypes getDataUploadType() {
        return dataUploadType;
    }

    public void setDataUploadType(AccessTypes dataUploadType) {
        this.dataUploadType = dataUploadType;
    }

    public List<DataUploadRestrictions> getDataUploadRestrictions() {
        return dataUploadRestrictions;
    }

    public void setDataUploadRestrictions(List<DataUploadRestrictions> dataUploadRestrictions) {
        if(null != this.dataUploadRestrictions) {
            this.dataUploadRestrictions.addAll(dataUploadRestrictions);
        }
        else {
            this.dataUploadRestrictions = dataUploadRestrictions;
        }
    }
}
