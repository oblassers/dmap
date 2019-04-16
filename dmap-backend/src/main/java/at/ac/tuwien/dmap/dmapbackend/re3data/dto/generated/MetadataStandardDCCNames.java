
package at.ac.tuwien.dmap.dmapbackend.re3data.dto.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for metadataStandardDCCNames.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="metadataStandardDCCNames">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ABCD - Access to Biological Collection Data"/>
 *     &lt;enumeration value="AgMES - Agricultural Metadata Element Set"/>
 *     &lt;enumeration value="AVM - Astronomy Visualization Metadata"/>
 *     &lt;enumeration value="CF (Climate and Forecast) Metadata Conventions"/>
 *     &lt;enumeration value="CIF - Crystallographic Information Framework"/>
 *     &lt;enumeration value="CIM - Common Information Model"/>
 *     &lt;enumeration value="CSMD-CCLRC Core Scientific Metadata Model"/>
 *     &lt;enumeration value="Darwin Core"/>
 *     &lt;enumeration value="DataCite Metadata Schema"/>
 *     &lt;enumeration value="DCAT - Data Catalog Vocabulary"/>
 *     &lt;enumeration value="DDI - Data Documentation Initiative"/>
 *     &lt;enumeration value="DIF - Directory Interchange Format"/>
 *     &lt;enumeration value="Dublin Core"/>
 *     &lt;enumeration value="EML - Ecological Metadata Language"/>
 *     &lt;enumeration value="FGDC/CSDGM - Federal Geographic Data Committee Content Standard for Digital Geospatial Metadata"/>
 *     &lt;enumeration value="FITS - Flexible Image Transport System"/>
 *     &lt;enumeration value="Genome Metadata"/>
 *     &lt;enumeration value="International Virtual Observatory Alliance Technical Specifications"/>
 *     &lt;enumeration value="ISA-Tab"/>
 *     &lt;enumeration value="ISO 19115"/>
 *     &lt;enumeration value="MIBBI - Minimum Information for Biological and Biomedical Investigations"/>
 *     &lt;enumeration value="MIDAS-Heritage"/>
 *     &lt;enumeration value="OAI-ORE - Open Archives Initiative Object Reuse and Exchange"/>
 *     &lt;enumeration value="Observ-OM"/>
 *     &lt;enumeration value="Observations and Measurements"/>
 *     &lt;enumeration value="OME-XML - Open Microscopy Environment XML"/>
 *     &lt;enumeration value="Protocol Data Element Definitions"/>
 *     &lt;enumeration value="PROV"/>
 *     &lt;enumeration value="QuDEx - Qualitative Data Exchange Format"/>
 *     &lt;enumeration value="RDF Data Cube Vocabulary"/>
 *     &lt;enumeration value="Repository-Developed Metadata Schemas"/>
 *     &lt;enumeration value="SDMX - Statistical Data and Metadata Exchange"/>
 *     &lt;enumeration value="SPASE Data Model"/>
 *     &lt;enumeration value="other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "metadataStandardDCCNames", namespace = "http://www.re3data.org/schema/2-2")
@XmlEnum
public enum MetadataStandardDCCNames {


    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/abcd-access-biological-collection-data
     * 
     */
    @XmlEnumValue("ABCD - Access to Biological Collection Data")
    ABCD_ACCESS_TO_BIOLOGICAL_COLLECTION_DATA("ABCD - Access to Biological Collection Data"),

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/agmes-agricultural-metadata-element-set
     * 
     */
    @XmlEnumValue("AgMES - Agricultural Metadata Element Set")
    AG_MES_AGRICULTURAL_METADATA_ELEMENT_SET("AgMES - Agricultural Metadata Element Set"),

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/avm-astronomy-visualization-metadata
     * 
     */
    @XmlEnumValue("AVM - Astronomy Visualization Metadata")
    AVM_ASTRONOMY_VISUALIZATION_METADATA("AVM - Astronomy Visualization Metadata"),

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/cf-climate-and-forecast-metadata-conventions
     * 
     */
    @XmlEnumValue("CF (Climate and Forecast) Metadata Conventions")
    CF_CLIMATE_AND_FORECAST_METADATA_CONVENTIONS("CF (Climate and Forecast) Metadata Conventions"),

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/cif-crystallographic-information-framework
     * 
     */
    @XmlEnumValue("CIF - Crystallographic Information Framework")
    CIF_CRYSTALLOGRAPHIC_INFORMATION_FRAMEWORK("CIF - Crystallographic Information Framework"),

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/cim-common-information-model
     * 
     */
    @XmlEnumValue("CIM - Common Information Model")
    CIM_COMMON_INFORMATION_MODEL("CIM - Common Information Model"),

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/csmd-cclrc-core-scientific-metadata-model
     * 
     */
    @XmlEnumValue("CSMD-CCLRC Core Scientific Metadata Model")
    CSMD_CCLRC_CORE_SCIENTIFIC_METADATA_MODEL("CSMD-CCLRC Core Scientific Metadata Model"),

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/darwin-core
     * 
     */
    @XmlEnumValue("Darwin Core")
    DARWIN_CORE("Darwin Core"),

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/datacite-metadata-schema
     * 
     */
    @XmlEnumValue("DataCite Metadata Schema")
    DATA_CITE_METADATA_SCHEMA("DataCite Metadata Schema"),

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/dcat-data-catalog-vocabulary
     * 
     */
    @XmlEnumValue("DCAT - Data Catalog Vocabulary")
    DCAT_DATA_CATALOG_VOCABULARY("DCAT - Data Catalog Vocabulary"),

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/ddi-data-documentation-initiative
     * 
     */
    @XmlEnumValue("DDI - Data Documentation Initiative")
    DDI_DATA_DOCUMENTATION_INITIATIVE("DDI - Data Documentation Initiative"),

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/dif-directory-interchange-format
     * 
     */
    @XmlEnumValue("DIF - Directory Interchange Format")
    DIF_DIRECTORY_INTERCHANGE_FORMAT("DIF - Directory Interchange Format"),

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/dublin-core
     * 
     */
    @XmlEnumValue("Dublin Core")
    DUBLIN_CORE("Dublin Core"),

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/eml-ecological-metadata-language
     * 
     */
    @XmlEnumValue("EML - Ecological Metadata Language")
    EML_ECOLOGICAL_METADATA_LANGUAGE("EML - Ecological Metadata Language"),

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/fgdccsdgm-federal-geographic-data-committee-content-standard-digital-ge
     * 
     */
    @XmlEnumValue("FGDC/CSDGM - Federal Geographic Data Committee Content Standard for Digital Geospatial Metadata")
    FGDC_CSDGM_FEDERAL_GEOGRAPHIC_DATA_COMMITTEE_CONTENT_STANDARD_FOR_DIGITAL_GEOSPATIAL_METADATA("FGDC/CSDGM - Federal Geographic Data Committee Content Standard for Digital Geospatial Metadata"),

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/fits-flexible-image-transport-system
     * 
     */
    @XmlEnumValue("FITS - Flexible Image Transport System")
    FITS_FLEXIBLE_IMAGE_TRANSPORT_SYSTEM("FITS - Flexible Image Transport System"),

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/genome-metadata
     * 
     */
    @XmlEnumValue("Genome Metadata")
    GENOME_METADATA("Genome Metadata"),

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/international-virtual-observatory-alliance-technical-specifications
     * 
     */
    @XmlEnumValue("International Virtual Observatory Alliance Technical Specifications")
    INTERNATIONAL_VIRTUAL_OBSERVATORY_ALLIANCE_TECHNICAL_SPECIFICATIONS("International Virtual Observatory Alliance Technical Specifications"),

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/isa-tab
     * 
     */
    @XmlEnumValue("ISA-Tab")
    ISA_TAB("ISA-Tab"),

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/iso-19115
     * 
     */
    @XmlEnumValue("ISO 19115")
    ISO_19115("ISO 19115"),

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/mibbi-minimum-information-biological-and-biomedical-investigations
     * 
     */
    @XmlEnumValue("MIBBI - Minimum Information for Biological and Biomedical Investigations")
    MIBBI_MINIMUM_INFORMATION_FOR_BIOLOGICAL_AND_BIOMEDICAL_INVESTIGATIONS("MIBBI - Minimum Information for Biological and Biomedical Investigations"),

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/midas-heritage
     * 
     */
    @XmlEnumValue("MIDAS-Heritage")
    MIDAS_HERITAGE("MIDAS-Heritage"),

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/oai-ore-open-archives-initiative-object-reuse-and-exchange
     * 
     */
    @XmlEnumValue("OAI-ORE - Open Archives Initiative Object Reuse and Exchange")
    OAI_ORE_OPEN_ARCHIVES_INITIATIVE_OBJECT_REUSE_AND_EXCHANGE("OAI-ORE - Open Archives Initiative Object Reuse and Exchange"),

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/observ-om
     * 
     */
    @XmlEnumValue("Observ-OM")
    OBSERV_OM("Observ-OM"),

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/observations-and-measurements
     * 
     */
    @XmlEnumValue("Observations and Measurements")
    OBSERVATIONS_AND_MEASUREMENTS("Observations and Measurements"),

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/ome-xml-open-microscopy-environment-xml
     * 
     */
    @XmlEnumValue("OME-XML - Open Microscopy Environment XML")
    OME_XML_OPEN_MICROSCOPY_ENVIRONMENT_XML("OME-XML - Open Microscopy Environment XML"),

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/protocol-data-element-definitions
     * 
     */
    @XmlEnumValue("Protocol Data Element Definitions")
    PROTOCOL_DATA_ELEMENT_DEFINITIONS("Protocol Data Element Definitions"),

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/prov
     * 
     */
    PROV("PROV"),

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/qudex-qualitative-data-exchange-format
     * 
     */
    @XmlEnumValue("QuDEx - Qualitative Data Exchange Format")
    QU_D_EX_QUALITATIVE_DATA_EXCHANGE_FORMAT("QuDEx - Qualitative Data Exchange Format"),

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/rdf-data-cube-vocabulary
     * 
     */
    @XmlEnumValue("RDF Data Cube Vocabulary")
    RDF_DATA_CUBE_VOCABULARY("RDF Data Cube Vocabulary"),

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/repository-developed-metadata-schemas
     * 
     */
    @XmlEnumValue("Repository-Developed Metadata Schemas")
    REPOSITORY_DEVELOPED_METADATA_SCHEMAS("Repository-Developed Metadata Schemas"),

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/sdmx-statistical-data-and-metadata-exchange
     * 
     */
    @XmlEnumValue("SDMX - Statistical Data and Metadata Exchange")
    SDMX_STATISTICAL_DATA_AND_METADATA_EXCHANGE("SDMX - Statistical Data and Metadata Exchange"),

    /**
     * http://www.dcc.ac.uk/resources/metadata-standards/spase-data-model
     * 
     */
    @XmlEnumValue("SPASE Data Model")
    SPASE_DATA_MODEL("SPASE Data Model"),

    /**
     * other
     * 
     */
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    MetadataStandardDCCNames(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MetadataStandardDCCNames fromValue(String v) {
        for (MetadataStandardDCCNames c: MetadataStandardDCCNames.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
