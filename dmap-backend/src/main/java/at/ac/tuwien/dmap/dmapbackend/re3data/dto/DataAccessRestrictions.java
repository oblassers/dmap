package at.ac.tuwien.dmap.dmapbackend.re3data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum DataAccessRestrictions {
    @JsonProperty("feeRequired")
    FEE_REQUIRED,
    @JsonProperty("institutional membership")
    INSTITUTIONAL_MEMBERSHIP,
    @JsonProperty("registration")
    REGISTRATION,
    @JsonProperty("other")
    OTHER
}
