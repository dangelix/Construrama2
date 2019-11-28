
package com.finkok.facturacion.stamp;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import views.core.soap.services.apps.AcuseRecepcionCFDI;


/**
 * <p>Clase Java para sign_stampResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="sign_stampResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="sign_stampResult" type="{apps.services.soap.core.views}AcuseRecepcionCFDI" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sign_stampResponse", propOrder = {
    "signStampResult"
})
public class SignStampResponse {

    @XmlElementRef(name = "sign_stampResult", namespace = "http://facturacion.finkok.com/stamp", type = JAXBElement.class, required = false)
    protected JAXBElement<AcuseRecepcionCFDI> signStampResult;

    /**
     * Obtiene el valor de la propiedad signStampResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AcuseRecepcionCFDI }{@code >}
     *     
     */
    public JAXBElement<AcuseRecepcionCFDI> getSignStampResult() {
        return signStampResult;
    }

    /**
     * Define el valor de la propiedad signStampResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AcuseRecepcionCFDI }{@code >}
     *     
     */
    public void setSignStampResult(JAXBElement<AcuseRecepcionCFDI> value) {
        this.signStampResult = value;
    }

}
