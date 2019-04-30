package at.ac.tuwien.dmap.dmapbackend.re3data.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

/**
 * This class is used as a target for unmarshalling the XML response from the re3data API.
 * Conforms to http://schema.re3data.org/2-2/re3dataV2-2.xsd
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetadataStandardName {
    @JacksonXmlProperty(localName = "metadataStandardScheme", isAttribute = true)
    private String scheme;

    @JacksonXmlText
    private MetadataStandardNames name;

    public MetadataStandardName() {
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public MetadataStandardNames getName() {
        return name;
    }

    public void setName(MetadataStandardNames name) {
        this.name = name;
    }
}
