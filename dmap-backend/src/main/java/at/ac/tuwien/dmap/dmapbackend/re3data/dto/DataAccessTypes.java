package at.ac.tuwien.dmap.dmapbackend.re3data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum DataAccessTypes {
    @JsonProperty("open")
    OPEN,
    @JsonProperty("embargoed")
    EMBARGOED,
    @JsonProperty("restricted")
    RESTRICTED,
    @JsonProperty("closed")
    CLOSED
}
