
package views.core.soap.services.apps;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import com.finkok.facturacion.cancellation.StringArray;


/**
 * <p>Java class for UUIDS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UUIDS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="uuids" type="{http://facturacion.finkok.com/cancellation}stringArray" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UUIDS", propOrder = {
    "uuids"
})
public class UUIDS {

    @XmlElementRef(name = "uuids", namespace = "apps.services.soap.core.views", type = JAXBElement.class, required = false)
    protected JAXBElement<StringArray> uuids;

    /**
     * Gets the value of the uuids property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link StringArray }{@code >}
     *     
     */
    public JAXBElement<StringArray> getUuids() {
        return uuids;
    }

    /**
     * Sets the value of the uuids property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link StringArray }{@code >}
     *     
     */
    public void setUuids(JAXBElement<StringArray> value) {
        this.uuids = value;
    }

}
