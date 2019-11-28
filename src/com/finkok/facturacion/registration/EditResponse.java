
package com.finkok.facturacion.registration;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for editResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="editResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="editResult" type="{apps.services.soap.core.views}RegistrationResult" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "editResponse", propOrder = {
    "editResult"
})
public class EditResponse {

    @XmlElementRef(name = "editResult", namespace = "http://facturacion.finkok.com/registration", type = JAXBElement.class, required = false)
    protected JAXBElement<RegistrationResult> editResult;

    /**
     * Gets the value of the editResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link RegistrationResult }{@code >}
     *     
     */
    public JAXBElement<RegistrationResult> getEditResult() {
        return editResult;
    }

    /**
     * Sets the value of the editResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link RegistrationResult }{@code >}
     *     
     */
    public void setEditResult(JAXBElement<RegistrationResult> value) {
        this.editResult = value;
    }

}
