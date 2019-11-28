
package com.finkok.facturacion.stamp;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import views.core.soap.services.apps.QueryPendingResult;


/**
 * <p>Clase Java para query_pendingResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="query_pendingResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="query_pendingResult" type="{apps.services.soap.core.views}QueryPendingResult" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "query_pendingResponse", propOrder = {
    "queryPendingResult"
})
public class QueryPendingResponse {

    @XmlElementRef(name = "query_pendingResult", namespace = "http://facturacion.finkok.com/stamp", type = JAXBElement.class, required = false)
    protected JAXBElement<QueryPendingResult> queryPendingResult;

    /**
     * Obtiene el valor de la propiedad queryPendingResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link QueryPendingResult }{@code >}
     *     
     */
    public JAXBElement<QueryPendingResult> getQueryPendingResult() {
        return queryPendingResult;
    }

    /**
     * Define el valor de la propiedad queryPendingResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link QueryPendingResult }{@code >}
     *     
     */
    public void setQueryPendingResult(JAXBElement<QueryPendingResult> value) {
        this.queryPendingResult = value;
    }

}
