package com.finkok.facturacion.registration;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResellerUserArray", propOrder = {
    "ResellerUser"
})
public class ResellerUserArray {

	
	@XmlElement(name = "Incidencia", nillable = true)
    protected List<ResellerUser> incidencia;

	public List<ResellerUser> getIncidencia() {
		return incidencia;
	}

	public void setIncidencia(List<ResellerUser> incidencia) {
		this.incidencia = incidencia;
	}
	
	
}
