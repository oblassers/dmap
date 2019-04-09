package at.ac.tuwien.dmap.dmapbackend.re3data.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class is used as a target for unmarshalling the XML response from the re3data API.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository {

    private String id;

    private String name;

    public Repository() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
