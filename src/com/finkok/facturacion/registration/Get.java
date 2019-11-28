
package com.finkok.facturacion.registration;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for get complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="get"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="reseller_username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reseller_password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="taxpayer_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "get", propOrder = {
    "resellerUsername",
    "resellerPassword",
    "taxpayerId"
})
public class Get {

    @XmlElementRef(name = "reseller_username", namespace = "http://facturacion.finkok.com/registration", type = JAXBElement.class, required = false)
    protected JAXBElement<String> resellerUsername;
    @XmlElementRef(name = "reseller_password", namespace = "http://facturacion.finkok.com/registration", type = JAXBElement.class, required = false)
    protected JAXBElement<String> resellerPassword;
    @XmlElementRef(name = "taxpayer_id", namespace = "http://facturacion.finkok.com/registration", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxpayerId;

    /**
     * Gets the value of the resellerUsername property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getResellerUsername() {
        return resellerUsername;
    }

    /**
     * Sets the value of the resellerUsername property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setResellerUsername(JAXBElement<String> value) {
        this.resellerUsername = value;
    }

    /**
     * Gets the value of the resellerPassword property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getResellerPassword() {
        return resellerPassword;
    }

    /**
     * Sets the value of the resellerPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setResellerPassword(JAXBElement<String> value) {
        this.resellerPassword = value;
    }

    /**
     * Gets the value of the taxpayerId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxpayerId() {
        return taxpayerId;
    }

    /**
     * Sets the value of the taxpayerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxpayerId(JAXBElement<String> value) {
        this.taxpayerId = value;
    }

}
