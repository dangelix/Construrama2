
package com.finkok.facturacion.registration;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for edit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="edit"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="reseller_username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reseller_password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="taxpayer_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cer" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
 *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
 *         &lt;element name="passphrase" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "edit", propOrder = {
    "resellerUsername",
    "resellerPassword",
    "taxpayerId",
    "status",
    "cer",
    "key",
    "passphrase"
})
public class Edit {

    @XmlElementRef(name = "reseller_username", namespace = "http://facturacion.finkok.com/registration", type = JAXBElement.class, required = false)
    protected JAXBElement<String> resellerUsername;
    @XmlElementRef(name = "reseller_password", namespace = "http://facturacion.finkok.com/registration", type = JAXBElement.class, required = false)
    protected JAXBElement<String> resellerPassword;
    @XmlElementRef(name = "taxpayer_id", namespace = "http://facturacion.finkok.com/registration", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxpayerId;
    @XmlElementRef(name = "status", namespace = "http://facturacion.finkok.com/registration", type = JAXBElement.class, required = false)
    protected JAXBElement<String> status;
    @XmlElementRef(name = "cer", namespace = "http://facturacion.finkok.com/registration", type = JAXBElement.class, required = false)
    protected JAXBElement<byte[]> cer;
    @XmlElementRef(name = "key", namespace = "http://facturacion.finkok.com/registration", type = JAXBElement.class, required = false)
    protected JAXBElement<byte[]> key;
    @XmlElementRef(name = "passphrase", namespace = "http://facturacion.finkok.com/registration", type = JAXBElement.class, required = false)
    protected JAXBElement<String> passphrase;

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

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStatus(JAXBElement<String> value) {
        this.status = value;
    }

    /**
     * Gets the value of the cer property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public JAXBElement<byte[]> getCer() {
        return cer;
    }

    /**
     * Sets the value of the cer property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public void setCer(JAXBElement<byte[]> value) {
        this.cer = value;
    }

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public JAXBElement<byte[]> getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public void setKey(JAXBElement<byte[]> value) {
        this.key = value;
    }

    /**
     * Gets the value of the passphrase property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPassphrase() {
        return passphrase;
    }

    /**
     * Sets the value of the passphrase property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPassphrase(JAXBElement<String> value) {
        this.passphrase = value;
    }

}
