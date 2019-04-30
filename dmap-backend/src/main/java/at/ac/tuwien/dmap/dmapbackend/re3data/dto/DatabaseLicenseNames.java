package at.ac.tuwien.dmap.dmapbackend.re3data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This enum is used as a target for unmarshalling the XML response from the re3data API.
 * Conforms to http://schema.re3data.org/2-2/re3dataV2-2.xsd
 */
public enum DatabaseLicenseNames {
    @JsonProperty("Apache License 2.0")
    APACHE_LICENSE_2_0,
    BSD,
    CC,
    @JsonProperty("CC0")
    CC_0,
    @JsonProperty("Copyrights")
    COPYRIGHTS,
    ODC,
    @JsonProperty("Public Domain")
    PUBLIC_DOMAIN,
    @JsonProperty("other")
    OTHER
}
