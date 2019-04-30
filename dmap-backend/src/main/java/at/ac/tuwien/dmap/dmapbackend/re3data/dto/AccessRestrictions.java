package at.ac.tuwien.dmap.dmapbackend.re3data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This enum is used as a target for unmarshalling the XML response from the re3data API.
 * Conforms to http://schema.re3data.org/2-2/re3dataV2-2.xsd
 */
public enum AccessRestrictions {
    @JsonProperty("feeRequired")
    FEE_REQUIRED,
    @JsonProperty("registration")
    REGISTRATION,
    @JsonProperty("other")
    OTHER
}
