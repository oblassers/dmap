package at.ac.tuwien.dmap.dmapbackend.re3data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum PidSystems {
    @JsonProperty("ARK")
    ARK,
    @JsonProperty("DOI")
    DOI,
    @JsonProperty("hdl")
    HDL,
    @JsonProperty("PURL")
    PURL,
    @JsonProperty("URN")
    URN,
    @JsonProperty("other")
    OTHER,
    @JsonProperty("none")
    NONE
}
