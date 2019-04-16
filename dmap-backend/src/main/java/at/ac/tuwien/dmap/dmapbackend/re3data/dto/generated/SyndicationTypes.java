
package at.ac.tuwien.dmap.dmapbackend.re3data.dto.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for syndicationTypes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="syndicationTypes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ATOM"/>
 *     &lt;enumeration value="RSS"/>
 *     &lt;enumeration value="other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "syndicationTypes", namespace = "http://www.re3data.org/schema/2-2")
@XmlEnum
public enum SyndicationTypes {

    ATOM("ATOM"),
    RSS("RSS"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    SyndicationTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SyndicationTypes fromValue(String v) {
        for (SyndicationTypes c: SyndicationTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
