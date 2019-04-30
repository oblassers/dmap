package at.ac.tuwien.dmap.dmapbackend.re3data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum YesNo {
    @JsonProperty("yes")
    YES,
    @JsonProperty("no")
    NO
}
