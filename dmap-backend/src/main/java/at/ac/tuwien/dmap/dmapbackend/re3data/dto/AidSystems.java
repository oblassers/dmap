package at.ac.tuwien.dmap.dmapbackend.re3data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum AidSystems {
    @JsonProperty("AuthorClaim")
    AUTHOR_CLAIM,
    @JsonProperty("ISNI")
    ISNI,
    @JsonProperty("ORCID")
    ORCID,
    @JsonProperty("ResearcherID")
    RESEARCHER_ID,
    @JsonProperty("other")
    OTHER,
    @JsonProperty("none")
    NONE
}
