
package com.finkok.facturacion.registration;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for add complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="add"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="reseller_username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reseller_password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="taxpayer_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="type_user" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="coupon" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="added" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "add", propOrder = {
    "resellerUsername",
    "resellerPassword",
    "taxpayerId",
    "typeUser",
    "coupon",
    "added",
    "cer",
    "key",
    "passphrase"
})

@XmlRootElement(name = "add")
public class Add {

    @XmlElementRef(name = "resellerUsername", namespace = "http://facturacion.finkok.com/registration", type = JAXBElement.class, required = false)
    protected JAXBElement<String> resellerUsername;
    @XmlElementRef(name = "resellerPassword", namespace = "http://facturacion.finkok.com/registration", type = JAXBElement.class, required = false)
    protected JAXBElement<String> resellerPassword;
    @XmlElementRef(name = "taxpayerId", namespace = "http://facturacion.finkok.com/registration", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxpayerId;
    @XmlElementRef(name = "typeUser", namespace = "http://facturacion.finkok.com/registration", type = JAXBElement.class, required = false)
    protected JAXBElement<String> typeUser;
    @XmlElementRef(name = "coupon", namespace = "http://facturacion.finkok.com/registration", type = JAXBElement.class, required = false)
    protected JAXBElement<String> coupon;
    @XmlElementRef(name = "added", namespace = "http://facturacion.finkok.com/registration", type = JAXBElement.class, required = false)
    protected JAXBElement<String> added;
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
     * Gets the value of the typeUser property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTypeUser() {
        return typeUser;
    }

    /**
     * Sets the value of the typeUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTypeUser(JAXBElement<String> value) {
        this.typeUser = value;
    }

    /**
     * Gets the value of the coupon property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCoupon() {
        return coupon;
    }

    /**
     * Sets the value of the coupon property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCoupon(JAXBElement<String> value) {
        this.coupon = value;
    }

    /**
     * Gets the value of the added property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAdded() {
        return added;
    }

    /**
     * Sets the value of the added property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAdded(JAXBElement<String> value) {
        this.added = value;
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
