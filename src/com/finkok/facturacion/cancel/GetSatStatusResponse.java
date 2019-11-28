package com.finkok.facturacion.cancel;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import views.core.soap.services.apps.AcuseSatEstatus;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "get_sat_statusResponse", propOrder = {
    "getSatStatusResult"
})
@XmlRootElement(name = "get_sat_statusResponse")
public class GetSatStatusResponse {

    @XmlElementRef(name = "acuseSatEstatus", namespace = "apps.services.soap.core.views", type = JAXBElement.class, required = false)
    protected JAXBElement<AcuseSatEstatus> getSatStatusResult;

	public JAXBElement<AcuseSatEstatus> getGetSatStatusResult() {
		return getSatStatusResult;
	}

	public void setGetSatStatusResult(JAXBElement<AcuseSatEstatus> getSatStatusResult) {
		this.getSatStatusResult = getSatStatusResult;
	}
    
    
}
