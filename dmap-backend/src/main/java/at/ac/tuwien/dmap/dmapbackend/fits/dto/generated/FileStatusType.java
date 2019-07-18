
package at.ac.tuwien.dmap.dmapbackend.fits.dto.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fileStatusType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fileStatusType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;group ref="{http://hul.harvard.edu/ois/xml/ns/fits/fits_output}fileStatusElements" maxOccurs="unbounded" minOccurs="0"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fileStatusType", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output", propOrder = {
    "fileStatusElements"
})
public class FileStatusType {

    @XmlElementRefs({
        @XmlElementRef(name = "message", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "well-formed", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "valid", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<FitsMetadataType>> fileStatusElements;

    /**
     * Gets the value of the fileStatusElements property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fileStatusElements property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFileStatusElements().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link FitsMetadataType }{@code >}
     * {@link JAXBElement }{@code <}{@link FitsMetadataType }{@code >}
     * {@link JAXBElement }{@code <}{@link FitsMetadataType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<FitsMetadataType>> getFileStatusElements() {
        if (fileStatusElements == null) {
            fileStatusElements = new ArrayList<JAXBElement<FitsMetadataType>>();
        }
        return this.fileStatusElements;
    }

}
