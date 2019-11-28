
package com.finkok.facturacion.cancel;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import views.core.soap.services.apps.FolioArray;


/**
 * <p>Java class for CancelaCFDResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CancelaCFDResult"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Folios" type="{apps.services.soap.core.views}FolioArray" minOccurs="0"/&gt;
 *         &lt;element name="Acuse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Fecha" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RfcEmisor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CodEstatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CancelaCFDResult", propOrder = {
    "folios",
    "acuse",
    "fecha",
    "rfcEmisor",
    "codEstatus"
})
public class CancelaCFDResult {

    @XmlElementRef(name = "Folios", namespace = "apps.services.soap.core.views", type = JAXBElement.class, required = false)
    protected JAXBElement<FolioArray> folios;
    @XmlElementRef(name = "Acuse", namespace = "apps.services.soap.core.views", type = JAXBElement.class, required = false)
    protected JAXBElement<String> acuse;
    @XmlElementRef(name = "Fecha", namespace = "apps.services.soap.core.views", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fecha;
    @XmlElementRef(name = "RfcEmisor", namespace = "apps.services.soap.core.views", type = JAXBElement.class, required = false)
    protected JAXBElement<String> rfcEmisor;
    @XmlElementRef(name = "CodEstatus", namespace = "apps.services.soap.core.views", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codEstatus;

    /**
     * Gets the value of the folios property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FolioArray }{@code >}
     *     
     */
    public JAXBElement<FolioArray> getFolios() {
        return folios;
    }

    /**
     * Sets the value of the folios property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FolioArray }{@code >}
     *     
     */
    public void setFolios(JAXBElement<FolioArray> value) {
        this.folios = value;
    }

    /**
     * Gets the value of the acuse property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAcuse() {
        return acuse;
    }

    /**
     * Sets the value of the acuse property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAcuse(JAXBElement<String> value) {
        this.acuse = value;
    }

    /**
     * Gets the value of the fecha property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFecha() {
        return fecha;
    }

    /**
     * Sets the value of the fecha property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFecha(JAXBElement<String> value) {
        this.fecha = value;
    }

    /**
     * Gets the value of the rfcEmisor property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRfcEmisor() {
        return rfcEmisor;
    }

    /**
     * Sets the value of the rfcEmisor property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRfcEmisor(JAXBElement<String> value) {
        this.rfcEmisor = value;
    }

    /**
     * Gets the value of the codEstatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCodEstatus() {
        return codEstatus;
    }

    /**
     * Sets the value of the codEstatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodEstatus(JAXBElement<String> value) {
        this.codEstatus = value;
    }

}
