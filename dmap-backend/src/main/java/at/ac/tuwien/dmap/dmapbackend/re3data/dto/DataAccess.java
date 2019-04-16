package at.ac.tuwien.dmap.dmapbackend.re3data.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * This class is used as a target for unmarshalling the XML response from the re3data API.
 * Conforms to http://schema.re3data.org/2-2/re3dataV2-2.xsd
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataAccess {

    @JacksonXmlProperty(namespace = "r3d", localName = "dataAccessType")
    private DataAccessTypes dataAccessType;

    public DataAccess() {
    }

    public DataAccessTypes getDataAccessType() {
        return dataAccessType;
    }

    public void setDataAccessType(DataAccessTypes dataAccessType) {
        this.dataAccessType = dataAccessType;
    }
}
