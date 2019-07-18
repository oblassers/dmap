
package at.ac.tuwien.dmap.dmapbackend.fits.dto.generated;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for statisticsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="statisticsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tool" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attGroup ref="{http://hul.harvard.edu/ois/xml/ns/fits/fits_output}nameVersionAttrGrp"/>
 *                 &lt;attribute name="executionTime" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                 &lt;attribute name="status" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="fitsExecutionTime" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "statisticsType", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output", propOrder = {
    "tool"
})
public class StatisticsType {

    @XmlElement(namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    protected List<StatisticsType.Tool> tool;
    @XmlAttribute(name = "fitsExecutionTime")
    protected BigInteger fitsExecutionTime;

    /**
     * Gets the value of the tool property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tool property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTool().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StatisticsType.Tool }
     * 
     * 
     */
    public List<StatisticsType.Tool> getTool() {
        if (tool == null) {
            tool = new ArrayList<StatisticsType.Tool>();
        }
        return this.tool;
    }

    /**
     * Gets the value of the fitsExecutionTime property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFitsExecutionTime() {
        return fitsExecutionTime;
    }

    /**
     * Sets the value of the fitsExecutionTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFitsExecutionTime(BigInteger value) {
        this.fitsExecutionTime = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{http://hul.harvard.edu/ois/xml/ns/fits/fits_output}nameVersionAttrGrp"/>
     *       &lt;attribute name="executionTime" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *       &lt;attribute name="status" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Tool {

        @XmlAttribute(name = "executionTime")
        protected BigInteger executionTime;
        @XmlAttribute(name = "status")
        protected String status;
        @XmlAttribute(name = "toolname")
        protected String toolname;
        @XmlAttribute(name = "toolversion")
        protected String toolversion;

        /**
         * Gets the value of the executionTime property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getExecutionTime() {
            return executionTime;
        }

        /**
         * Sets the value of the executionTime property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setExecutionTime(BigInteger value) {
            this.executionTime = value;
        }

        /**
         * Gets the value of the status property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStatus() {
            return status;
        }

        /**
         * Sets the value of the status property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStatus(String value) {
            this.status = value;
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

}
