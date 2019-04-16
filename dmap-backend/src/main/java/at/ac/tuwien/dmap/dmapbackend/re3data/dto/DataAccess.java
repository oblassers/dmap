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
public class DataAccess {

    @JacksonXmlProperty(namespace = "r3d", localName = "dataAccessType")
    private DataAccessTypes dataAccessType;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(namespace = "r3d", localName = "dataAccessRestriction")
    private List<DataAccessRestrictions> dataAccessRestrictions;

    public DataAccess() {
    }

    public DataAccessTypes getDataAccessType() {
        return dataAccessType;
    }

    public void setDataAccessType(DataAccessTypes dataAccessType) {
        this.dataAccessType = dataAccessType;
    }

    public List<DataAccessRestrictions> getDataAccessRestrictions() {
        return dataAccessRestrictions;
    }

    public void setDataAccessRestrictions(List<DataAccessRestrictions> dataAccessRestrictions) {
        if(null != this.dataAccessRestrictions) {
            this.dataAccessRestrictions.addAll(dataAccessRestrictions);
        }
        else {
            this.dataAccessRestrictions = dataAccessRestrictions;
        }
    }
}
