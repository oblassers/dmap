package at.ac.tuwien.dmap.dmapbackend.re3data.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * This class is used as a target for unmarshalling the XML response from the re3data API.
 * Conforms to http://schema.re3data.org/2-2/re3dataV2-2.xsd
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetadataStandard {

    @JacksonXmlProperty(namespace = "r3d", localName = "metadataStandardName")
    private MetadataStandardName metadataStandardName;

    @JacksonXmlProperty(namespace = "r3d", localName = "metadataStandardURL")
    private MetadataStandardUrls metadataStandardUrl;

    public MetadataStandard() {
    }

    public MetadataStandardName getMetadataStandardName() {
        return metadataStandardName;
    }

    public void setMetadataStandardName(MetadataStandardName metadataStandardName) {
        this.metadataStandardName = metadataStandardName;
    }

    public MetadataStandardUrls getMetadataStandardUrl() {
        return metadataStandardUrl;
    }

    public void setMetadataStandardUrl(MetadataStandardUrls metadataStandardUrl) {
        this.metadataStandardUrl = metadataStandardUrl;
    }
}
