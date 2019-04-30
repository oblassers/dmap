package at.ac.tuwien.dmap.dmapbackend.re3data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This enum is used as a target for unmarshalling the XML response from the re3data API.
 * Conforms to http://schema.re3data.org/2-2/re3dataV2-2.xsd
 * List of metadata standards is from Digital Curation Center (DCC).
 */
public enum MetadataStandardUrls {
    /**
     * ABCD - Access to Biological Collection Data
     */
    @JsonProperty("http://www.dcc.ac.uk/resources/metadata-standards/abcd-access-biological-collection-data")
    HTTP_WWW_DCC_AC_UK_RESOURCES_METADATA_STANDARDS_ABCD_ACCESS_BIOLOGICAL_COLLECTION_DATA,

    /**
     * AgMES - Agricultural Metadata Element Set
     */
    @JsonProperty("http://www.dcc.ac.uk/resources/metadata-standards/agmes-agricultural-metadata-element-set")
    HTTP_WWW_DCC_AC_UK_RESOURCES_METADATA_STANDARDS_AGMES_AGRICULTURAL_METADATA_ELEMENT_SET,

    /**
     * AVM - Astronomy Visualization Metadata
     */
    @JsonProperty("http://www.dcc.ac.uk/resources/metadata-standards/avm-astronomy-visualization-metadata")
    HTTP_WWW_DCC_AC_UK_RESOURCES_METADATA_STANDARDS_AVM_ASTRONOMY_VISUALIZATION_METADATA,

    /**
     * CF (Climate and Forecast) Metadata Conventions
     */
    @JsonProperty("http://www.dcc.ac.uk/resources/metadata-standards/cf-climate-and-forecast-metadata-conventions")
    HTTP_WWW_DCC_AC_UK_RESOURCES_METADATA_STANDARDS_CF_CLIMATE_AND_FORECAST_METADATA_CONVENTIONS,

    /**
     * CIF - Crystallographic Information Framework
     */
    @JsonProperty("http://www.dcc.ac.uk/resources/metadata-standards/cif-crystallographic-information-framework")
    HTTP_WWW_DCC_AC_UK_RESOURCES_METADATA_STANDARDS_CIF_CRYSTALLOGRAPHIC_INFORMATION_FRAMEWORK,

    /**
     * CIM - Common Information Model
     */
    @JsonProperty("http://www.dcc.ac.uk/resources/metadata-standards/cim-common-information-model")
    HTTP_WWW_DCC_AC_UK_RESOURCES_METADATA_STANDARDS_CIM_COMMON_INFORMATION_MODEL,

    /**
     * CSMD-CCLRC Core Scientific Metadata Model
     */
    @JsonProperty("http://www.dcc.ac.uk/resources/metadata-standards/csmd-cclrc-core-scientific-metadata-model")
    HTTP_WWW_DCC_AC_UK_RESOURCES_METADATA_STANDARDS_CSMD_CCLRC_CORE_SCIENTIFIC_METADATA_MODEL,

    /**
     * Darwin Core
     */
    @JsonProperty("http://www.dcc.ac.uk/resources/metadata-standards/darwin-core")
    HTTP_WWW_DCC_AC_UK_RESOURCES_METADATA_STANDARDS_DARWIN_CORE,

    /**
     * DataCite Metadata Schema
     */
    @JsonProperty("http://www.dcc.ac.uk/resources/metadata-standards/datacite-metadata-schema")
    HTTP_WWW_DCC_AC_UK_RESOURCES_METADATA_STANDARDS_DATACITE_METADATA_SCHEMA,

    /**
     * DCAT - Data Catalog Vocabulary
     */
    @JsonProperty("http://www.dcc.ac.uk/resources/metadata-standards/dcat-data-catalog-vocabulary")
    HTTP_WWW_DCC_AC_UK_RESOURCES_METADATA_STANDARDS_DCAT_DATA_CATALOG_VOCABULARY,

    /**
     * DDI - Data Documentation Initiative
     */
    @JsonProperty("http://www.dcc.ac.uk/resources/metadata-standards/ddi-data-documentation-initiative")
    HTTP_WWW_DCC_AC_UK_RESOURCES_METADATA_STANDARDS_DDI_DATA_DOCUMENTATION_INITIATIVE,

    /**
     * DIF - Directory Interchange Format
     */
    @JsonProperty("http://www.dcc.ac.uk/resources/metadata-standards/dif-directory-interchange-format")
    HTTP_WWW_DCC_AC_UK_RESOURCES_METADATA_STANDARDS_DIF_DIRECTORY_INTERCHANGE_FORMAT,

    /**
     * Dublin Core
     */
    @JsonProperty("http://www.dcc.ac.uk/resources/metadata-standards/dublin-core")
    HTTP_WWW_DCC_AC_UK_RESOURCES_METADATA_STANDARDS_DUBLIN_CORE,

    /**
     * EML - Ecological Metadata Language
     */
    @JsonProperty("http://www.dcc.ac.uk/resources/metadata-standards/eml-ecological-metadata-language")
    HTTP_WWW_DCC_AC_UK_RESOURCES_METADATA_STANDARDS_EML_ECOLOGICAL_METADATA_LANGUAGE,

    /**
     * FGDC/CSDGM - Federal Geographic Data Committee Content Standard for Digital Geospatial Metadata
     */
    @JsonProperty("http://www.dcc.ac.uk/resources/metadata-standards/fgdccsdgm-federal-geographic-data-committee-content-standard-digital-ge")
    HTTP_WWW_DCC_AC_UK_RESOURCES_METADATA_STANDARDS_FGDCCSDGM_FEDERAL_GEOGRAPHIC_DATA_COMMITTEE_CONTENT_STANDARD_DIGITAL_GE,

    /**
     * FITS - Flexible Image Transport System
     */
    @JsonProperty("http://www.dcc.ac.uk/resources/metadata-standards/fits-flexible-image-transport-system")
    HTTP_WWW_DCC_AC_UK_RESOURCES_METADATA_STANDARDS_FITS_FLEXIBLE_IMAGE_TRANSPORT_SYSTEM,

    /**
     * Genome Metadata
     */
    @JsonProperty("http://www.dcc.ac.uk/resources/metadata-standards/genome-metadata")
    HTTP_WWW_DCC_AC_UK_RESOURCES_METADATA_STANDARDS_GENOME_METADATA,

    /**
     * International Virtual Observatory Alliance Technical Specifications
     */
    @JsonProperty("http://www.dcc.ac.uk/resources/metadata-standards/international-virtual-observatory-alliance-technical-specifications")
    HTTP_WWW_DCC_AC_UK_RESOURCES_METADATA_STANDARDS_INTERNATIONAL_VIRTUAL_OBSERVATORY_ALLIANCE_TECHNICAL_SPECIFICATIONS,

    /**
     * ISA-Tab
     */
    @JsonProperty("http://www.dcc.ac.uk/resources/metadata-standards/isa-tab")
    HTTP_WWW_DCC_AC_UK_RESOURCES_METADATA_STANDARDS_ISA_TAB,

    /**
     * ISO 19115
     */
    @JsonProperty("http://www.dcc.ac.uk/resources/metadata-standards/iso-19115")
    HTTP_WWW_DCC_AC_UK_RESOURCES_METADATA_STANDARDS_ISO_19115,

    /**
     * MIBBI - Minimum Information for Biological and Biomedical Investigations
     */
    @JsonProperty("http://www.dcc.ac.uk/resources/metadata-standards/mibbi-minimum-information-biological-and-biomedical-investigations")
    HTTP_WWW_DCC_AC_UK_RESOURCES_METADATA_STANDARDS_MIBBI_MINIMUM_INFORMATION_BIOLOGICAL_AND_BIOMEDICAL_INVESTIGATIONS,

    /**
     * MIDAS-Heritage
     */
    @JsonProperty("http://www.dcc.ac.uk/resources/metadata-standards/midas-heritage")
    HTTP_WWW_DCC_AC_UK_RESOURCES_METADATA_STANDARDS_MIDAS_HERITAGE,

    /**
     * OAI-ORE - Open Archives Initiative Object Reuse and Exchange
     */
    @JsonProperty("http://www.dcc.ac.uk/resources/metadata-standards/oai-ore-open-archives-initiative-object-reuse-and-exchange")
    HTTP_WWW_DCC_AC_UK_RESOURCES_METADATA_STANDARDS_OAI_ORE_OPEN_ARCHIVES_INITIATIVE_OBJECT_REUSE_AND_EXCHANGE,

    /**
     * Observ-OM
     */
    @JsonProperty("http://www.dcc.ac.uk/resources/metadata-standards/observ-om")
    HTTP_WWW_DCC_AC_UK_RESOURCES_METADATA_STANDARDS_OBSERV_OM,

    /**
     * Observations and Measurements
     */
    @JsonProperty("http://www.dcc.ac.uk/resources/metadata-standards/observations-and-measurements")
    HTTP_WWW_DCC_AC_UK_RESOURCES_METADATA_STANDARDS_OBSERVATIONS_AND_MEASUREMENTS,

    /**
     * OME-XML - Open Microscopy Environment XML
     */
    @JsonProperty("http://www.dcc.ac.uk/resources/metadata-standards/ome-xml-open-microscopy-environment-xml")
    HTTP_WWW_DCC_AC_UK_RESOURCES_METADATA_STANDARDS_OME_XML_OPEN_MICROSCOPY_ENVIRONMENT_XML,

    /**
     * Protocol Data Element Definitions
     */
    @JsonProperty("http://www.dcc.ac.uk/resources/metadata-standards/protocol-data-element-definitions")
    HTTP_WWW_DCC_AC_UK_RESOURCES_METADATA_STANDARDS_PROTOCOL_DATA_ELEMENT_DEFINITIONS,

    /**
     * PROV
     */
    @JsonProperty("http://www.dcc.ac.uk/resources/metadata-standards/prov")
    HTTP_WWW_DCC_AC_UK_RESOURCES_METADATA_STANDARDS_PROV,

    /**
     * QuDEx - Qualitative Data Exchange Format
     */
    @JsonProperty("http://www.dcc.ac.uk/resources/metadata-standards/qudex-qualitative-data-exchange-format")
    HTTP_WWW_DCC_AC_UK_RESOURCES_METADATA_STANDARDS_QUDEX_QUALITATIVE_DATA_EXCHANGE_FORMAT,

    /**
     * RDF Data Cube Vocabulary
     */
    @JsonProperty("http://www.dcc.ac.uk/resources/metadata-standards/rdf-data-cube-vocabulary")
    HTTP_WWW_DCC_AC_UK_RESOURCES_METADATA_STANDARDS_RDF_DATA_CUBE_VOCABULARY,

    /**
     * Repository-Developed Metadata Schemas
     */
    @JsonProperty("http://www.dcc.ac.uk/resources/metadata-standards/repository-developed-metadata-schemas")
    HTTP_WWW_DCC_AC_UK_RESOURCES_METADATA_STANDARDS_REPOSITORY_DEVELOPED_METADATA_SCHEMAS,

    /**
     * SDMX - Statistical Data and Metadata Exchange
     */
    @JsonProperty("http://www.dcc.ac.uk/resources/metadata-standards/sdmx-statistical-data-and-metadata-exchange")
    HTTP_WWW_DCC_AC_UK_RESOURCES_METADATA_STANDARDS_SDMX_STATISTICAL_DATA_AND_METADATA_EXCHANGE,

    /**
     * SPASE Data Model
     */
    @JsonProperty("http://www.dcc.ac.uk/resources/metadata-standards/spase-data-model")
    HTTP_WWW_DCC_AC_UK_RESOURCES_METADATA_STANDARDS_SPASE_DATA_MODEL,

    /**
     * other
     */
    @JsonProperty("other")
    OTHER
}
