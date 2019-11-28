
package com.finkok.facturacion.registration;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="getResult" type="{apps.services.soap.core.views}RegistrationListResult" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getResponse", propOrder = {
    "getResult"
})
public class GetResponse {

    @XmlElementRef(name = "getResult", namespace = "http://facturacion.finkok.com/registration", type = JAXBElement.class, required = false)
    protected JAXBElement<RegistrationListResult> getResult;

    /**
     * Gets the value of the getResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link RegistrationListResult }{@code >}
     *     
     */
    public JAXBElement<RegistrationListResult> getGetResult() {
        return getResult;
    }

    /**
     * Sets the value of the getResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link RegistrationListResult }{@code >}
     *     
     */
    public void setGetResult(JAXBElement<RegistrationListResult> value) {
        this.getResult = value;
    }

}
