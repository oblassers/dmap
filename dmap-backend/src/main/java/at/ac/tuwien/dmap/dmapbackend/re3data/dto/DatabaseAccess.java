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
public class DatabaseAccess {

    @JacksonXmlProperty(namespace = "r3d", localName = "databaseAccessType")
    private AccessTypes databaseAccessType;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(namespace = "r3d", localName = "databaseAccessRestriction")
    private List<AccessRestrictions> databaseAccessRestrictions;

    public DatabaseAccess() {
    }

    public AccessTypes getDatabaseAccessType() {
        return databaseAccessType;
    }

    public void setDatabaseAccessType(AccessTypes databaseAccessType) {
        this.databaseAccessType = databaseAccessType;
    }

    public List<AccessRestrictions> getDatabaseAccessRestrictions() {
        return databaseAccessRestrictions;
    }

    public void setDatabaseAccessRestrictions(List<AccessRestrictions> databaseAccessRestrictions) {
        if(null != this.databaseAccessRestrictions) {
            this.databaseAccessRestrictions.addAll(databaseAccessRestrictions);
        }
        else {
            this.databaseAccessRestrictions = databaseAccessRestrictions;
        }
    }
}
