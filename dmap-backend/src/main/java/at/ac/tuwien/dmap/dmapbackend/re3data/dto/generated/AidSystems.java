
package at.ac.tuwien.dmap.dmapbackend.re3data.dto.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for aidSystems.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="aidSystems">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AuthorClaim"/>
 *     &lt;enumeration value="ISNI"/>
 *     &lt;enumeration value="ORCID"/>
 *     &lt;enumeration value="ResearcherID"/>
 *     &lt;enumeration value="other"/>
 *     &lt;enumeration value="none"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "aidSystems", namespace = "http://www.re3data.org/schema/2-2")
@XmlEnum
public enum AidSystems {

    @XmlEnumValue("AuthorClaim")
    AUTHOR_CLAIM("AuthorClaim"),
    ISNI("ISNI"),
    ORCID("ORCID"),
    @XmlEnumValue("ResearcherID")
    RESEARCHER_ID("ResearcherID"),
    @XmlEnumValue("other")
    OTHER("other"),
    @XmlEnumValue("none")
    NONE("none");
    private final String value;

    AidSystems(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AidSystems fromValue(String v) {
        for (AidSystems c: AidSystems.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
