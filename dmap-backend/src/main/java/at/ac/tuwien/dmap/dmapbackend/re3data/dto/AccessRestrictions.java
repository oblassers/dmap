package at.ac.tuwien.dmap.dmapbackend.re3data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum AccessRestrictions {
    @JsonProperty("feeRequired")
    FEE_REQUIRED,
    @JsonProperty("registration")
    REGISTRATION,
    @JsonProperty("other")
    OTHER
}
