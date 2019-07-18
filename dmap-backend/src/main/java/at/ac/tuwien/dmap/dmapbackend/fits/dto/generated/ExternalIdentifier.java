
package at.ac.tuwien.dmap.dmapbackend.fits.dto.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attGroup ref="{http://hul.harvard.edu/ois/xml/ns/fits/fits_output}nameVersionAttrGrp"/>
 *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "value"
})
@XmlRootElement(name = "externalIdentifier", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
public class ExternalIdentifier {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "type", required = true)
    protected String type;
    @XmlAttribute(name = "toolname")
    protected String toolname;
    @XmlAttribute(name = "toolversion")
    protected String toolversion;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the toolname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToolname() {
        return toolname;
    }

    /**
     * Sets the value of the toolname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToolname(String value) {
        this.toolname = value;
    }

    /**
     * Gets the value of the toolversion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToolversion() {
        return toolversion;
    }

    /**
     * Sets the value of the toolversion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToolversion(String value) {
        this.toolversion = value;
    }

}
