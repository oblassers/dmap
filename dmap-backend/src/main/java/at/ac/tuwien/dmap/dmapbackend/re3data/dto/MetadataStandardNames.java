package at.ac.tuwien.dmap.dmapbackend.re3data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This enum is used as a target for unmarshalling the XML response from the re3data API.
 * Conforms to http://schema.re3data.org/2-2/re3dataV2-2.xsd
 * List of metadata standards is from Digital Curation Center (DCC).
 */
public enum MetadataStandardNames {
    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/abcd-access-biological-collection-data
     */
    @JsonProperty("ABCD - Access to Biological Collection Data")
    ABCD_ACCESS_TO_BIOLOGICAL_COLLECTION_DATA,

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/agmes-agricultural-metadata-element-set
     */
    @JsonProperty("AgMES - Agricultural Metadata Element Set")
    AG_MES_AGRICULTURAL_METADATA_ELEMENT_SET,

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/avm-astronomy-visualization-metadata
     */
    @JsonProperty("AVM - Astronomy Visualization Metadata")
    AVM_ASTRONOMY_VISUALIZATION_METADATA,

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/cf-climate-and-forecast-metadata-conventions
     */
    @JsonProperty("CF (Climate and Forecast) Metadata Conventions")
    CF_CLIMATE_AND_FORECAST_METADATA_CONVENTIONS,

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/cif-crystallographic-information-framework
     */
    @JsonProperty("CIF - Crystallographic Information Framework")
    CIF_CRYSTALLOGRAPHIC_INFORMATION_FRAMEWORK,

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/cim-common-information-model
     */
    @JsonProperty("CIM - Common Information Model")
    CIM_COMMON_INFORMATION_MODEL,

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/csmd-cclrc-core-scientific-metadata-model
     */
    @JsonProperty("CSMD-CCLRC Core Scientific Metadata Model")
    CSMD_CCLRC_CORE_SCIENTIFIC_METADATA_MODEL,

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/darwin-core
     */
    @JsonProperty("Darwin Core")
    DARWIN_CORE,

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/datacite-metadata-schema
     */
    @JsonProperty("DataCite Metadata Schema")
    DATA_CITE_METADATA_SCHEMA,

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/dcat-data-catalog-vocabulary
     */
    @JsonProperty("DCAT - Data Catalog Vocabulary")
    DCAT_DATA_CATALOG_VOCABULARY,

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/ddi-data-documentation-initiative
     */
    @JsonProperty("DDI - Data Documentation Initiative")
    DDI_DATA_DOCUMENTATION_INITIATIVE,

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/dif-directory-interchange-format
     */
    @JsonProperty("DIF - Directory Interchange Format")
    DIF_DIRECTORY_INTERCHANGE_FORMAT,

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/dublin-core
     */
    @JsonProperty("Dublin Core")
    DUBLIN_CORE,

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/eml-ecological-metadata-language
     */
    @JsonProperty("EML - Ecological Metadata Language")
    EML_ECOLOGICAL_METADATA_LANGUAGE,

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/fgdccsdgm-federal-geographic-data-committee-content-standard-digital-ge
     */
    @JsonProperty("FGDC/CSDGM - Federal Geographic Data Committee Content Standard for Digital Geospatial Metadata")
    FGDC_CSDGM_FEDERAL_GEOGRAPHIC_DATA_COMMITTEE_CONTENT_STANDARD_FOR_DIGITAL_GEOSPATIAL_METADATA,

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/fits-flexible-image-transport-system
     */
    @JsonProperty("FITS - Flexible Image Transport System")
    FITS_FLEXIBLE_IMAGE_TRANSPORT_SYSTEM,

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/genome-metadata
     */
    @JsonProperty("Genome Metadata")
    GENOME_METADATA,

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/international-virtual-observatory-alliance-technical-specifications
     */
    @JsonProperty("International Virtual Observatory Alliance Technical Specifications")
    INTERNATIONAL_VIRTUAL_OBSERVATORY_ALLIANCE_TECHNICAL_SPECIFICATIONS,

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/isa-tab
     */
    @JsonProperty("ISA-Tab")
    ISA_TAB,

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/iso-19115
     */
    @JsonProperty("ISO 19115")
    ISO_19115,

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/mibbi-minimum-information-biological-and-biomedical-investigations
     */
    @JsonProperty("MIBBI - Minimum Information for Biological and Biomedical Investigations")
    MIBBI_MINIMUM_INFORMATION_FOR_BIOLOGICAL_AND_BIOMEDICAL_INVESTIGATIONS,

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/midas-heritage
     */
    @JsonProperty("MIDAS-Heritage")
    MIDAS_HERITAGE,

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/oai-ore-open-archives-initiative-object-reuse-and-exchange
     */
    @JsonProperty("OAI-ORE - Open Archives Initiative Object Reuse and Exchange")
    OAI_ORE_OPEN_ARCHIVES_INITIATIVE_OBJECT_REUSE_AND_EXCHANGE,

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/observ-om
     */
    @JsonProperty("Observ-OM")
    OBSERV_OM,

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/observations-and-measurements
     */
    @JsonProperty("Observations and Measurements")
    OBSERVATIONS_AND_MEASUREMENTS,

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/ome-xml-open-microscopy-environment-xml
     */
    @JsonProperty("OME-XML - Open Microscopy Environment XML")
    OME_XML_OPEN_MICROSCOPY_ENVIRONMENT_XML,

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/protocol-data-element-definitions
     */
    @JsonProperty("Protocol Data Element Definitions")
    PROTOCOL_DATA_ELEMENT_DEFINITIONS,

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/prov
     */
    @JsonProperty("PROV")
    PROV,

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/qudex-qualitative-data-exchange-format
     */
    @JsonProperty("QuDEx - Qualitative Data Exchange Format")
    QU_D_EX_QUALITATIVE_DATA_EXCHANGE_FORMAT,

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/rdf-data-cube-vocabulary
     */
    @JsonProperty("RDF Data Cube Vocabulary")
    RDF_DATA_CUBE_VOCABULARY,

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/repository-developed-metadata-schemas
     */
    @JsonProperty("Repository-Developed Metadata Schemas")
    REPOSITORY_DEVELOPED_METADATA_SCHEMAS,

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/sdmx-statistical-data-and-metadata-exchange
     */
    @JsonProperty("SDMX - Statistical Data and Metadata Exchange")
    SDMX_STATISTICAL_DATA_AND_METADATA_EXCHANGE,

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/spase-data-model
     */
    @JsonProperty("SPASE Data Model")
    SPASE_DATA_MODEL,

    /**
     * other
     */
    @JsonProperty("other")
    OTHER
}
