package at.ac.tuwien.dmap.dmapbackend.re3data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum AccessTypes {
    @JsonProperty("open")
    OPEN,
    @JsonProperty("restricted")
    RESTRICTED,
    @JsonProperty("closed")
    CLOSED
}
