
package at.ac.tuwien.dmap.dmapbackend.re3data.dto.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for contentType_Text.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="contentType_Text">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Standard office documents"/>
 *     &lt;enumeration value="Networkbased data"/>
 *     &lt;enumeration value="Databases"/>
 *     &lt;enumeration value="Images"/>
 *     &lt;enumeration value="Structured graphics"/>
 *     &lt;enumeration value="Audiovisual data"/>
 *     &lt;enumeration value="Scientific and statistical data formats"/>
 *     &lt;enumeration value="Raw data"/>
 *     &lt;enumeration value="Plain text"/>
 *     &lt;enumeration value="Structured text"/>
 *     &lt;enumeration value="Archived data"/>
 *     &lt;enumeration value="Software applications"/>
 *     &lt;enumeration value="Source code"/>
 *     &lt;enumeration value="Configuration data"/>
 *     &lt;enumeration value="other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "contentType_Text", namespace = "http://www.re3data.org/schema/2-2")
@XmlEnum
public enum ContentTypeText {

    @XmlEnumValue("Standard office documents")
    STANDARD_OFFICE_DOCUMENTS("Standard office documents"),
    @XmlEnumValue("Networkbased data")
    NETWORKBASED_DATA("Networkbased data"),
    @XmlEnumValue("Databases")
    DATABASES("Databases"),
    @XmlEnumValue("Images")
    IMAGES("Images"),
    @XmlEnumValue("Structured graphics")
    STRUCTURED_GRAPHICS("Structured graphics"),
    @XmlEnumValue("Audiovisual data")
    AUDIOVISUAL_DATA("Audiovisual data"),
    @XmlEnumValue("Scientific and statistical data formats")
    SCIENTIFIC_AND_STATISTICAL_DATA_FORMATS("Scientific and statistical data formats"),
    @XmlEnumValue("Raw data")
    RAW_DATA("Raw data"),
    @XmlEnumValue("Plain text")
    PLAIN_TEXT("Plain text"),
    @XmlEnumValue("Structured text")
    STRUCTURED_TEXT("Structured text"),
    @XmlEnumValue("Archived data")
    ARCHIVED_DATA("Archived data"),
    @XmlEnumValue("Software applications")
    SOFTWARE_APPLICATIONS("Software applications"),
    @XmlEnumValue("Source code")
    SOURCE_CODE("Source code"),
    @XmlEnumValue("Configuration data")
    CONFIGURATION_DATA("Configuration data"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    ContentTypeText(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ContentTypeText fromValue(String v) {
        for (ContentTypeText c: ContentTypeText.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
