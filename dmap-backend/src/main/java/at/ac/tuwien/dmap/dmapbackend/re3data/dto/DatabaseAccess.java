package at.ac.tuwien.dmap.dmapbackend.re3data.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * This class is used as a target for unmarshalling the XML response from the re3data API.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DatabaseAccess {

    @JacksonXmlProperty(namespace = "r3d", localName = "databaseAccessType")
    private AccessTypes databaseAccessType;

    public DatabaseAccess() {
    }

    public AccessTypes getDatabaseAccessType() {
        return databaseAccessType;
    }

    public void setDatabaseAccessType(AccessTypes databaseAccessType) {
        this.databaseAccessType = databaseAccessType;
    }
}
