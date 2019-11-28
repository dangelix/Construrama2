
package com.finkok.facturacion.stamp;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import views.core.soap.services.apps.PDFResult;


/**
 * <p>Clase Java para get_pdfResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="get_pdfResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="get_pdfResult" type="{apps.services.soap.core.views}PDFResult" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "get_pdfResponse", propOrder = {
    "getPdfResult"
})
public class GetPdfResponse {

    @XmlElementRef(name = "get_pdfResult", namespace = "http://facturacion.finkok.com/stamp", type = JAXBElement.class, required = false)
    protected JAXBElement<PDFResult> getPdfResult;

    /**
     * Obtiene el valor de la propiedad getPdfResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PDFResult }{@code >}
     *     
     */
    public JAXBElement<PDFResult> getGetPdfResult() {
        return getPdfResult;
    }

    /**
     * Define el valor de la propiedad getPdfResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PDFResult }{@code >}
     *     
     */
    public void setGetPdfResult(JAXBElement<PDFResult> value) {
        this.getPdfResult = value;
    }

}
