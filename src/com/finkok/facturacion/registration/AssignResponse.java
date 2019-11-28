
package com.finkok.facturacion.registration;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for assignResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="assignResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="assignResult" type="{apps.services.soap.core.views}AssingResult" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "assignResponse", propOrder = {
    "assignResult"
})
public class AssignResponse {

    @XmlElementRef(name = "assignResult", namespace = "http://facturacion.finkok.com/registration", type = JAXBElement.class, required = false)
    protected JAXBElement<AssingResult> assignResult;

    /**
     * Gets the value of the assignResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AssingResult }{@code >}
     *     
     */
    public JAXBElement<AssingResult> getAssignResult() {
        return assignResult;
    }

    /**
     * Sets the value of the assignResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AssingResult }{@code >}
     *     
     */
    public void setAssignResult(JAXBElement<AssingResult> value) {
        this.assignResult = value;
    }

}
