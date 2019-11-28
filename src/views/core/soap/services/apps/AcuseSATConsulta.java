package views.core.soap.services.apps;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "acuseSATConsulta", propOrder = { "esCancelable", "codigoEstatus", "estado", "estatusCancelacion" })
public class AcuseSATConsulta {
	
	@XmlElementRef(name = "esCancelable", namespace = "apps.services.soap.core.views", type = JAXBElement.class, required = false)
	protected JAXBElement<String> esCancelable;
	@XmlElementRef(name = "CodigoEstatus", namespace = "apps.services.soap.core.views", type = JAXBElement.class, required = false)
	protected JAXBElement<String> codigoEstatus;
	@XmlElementRef(name = "estado", namespace = "apps.services.soap.core.views", type = JAXBElement.class, required = false)
	protected JAXBElement<String> estado;
	@XmlElementRef(name = "estatusCancelacion", namespace = "apps.services.soap.core.views", type = JAXBElement.class, required = false)
	protected JAXBElement<String> estatusCancelacion;
	public JAXBElement<String> getEsCancelable() {
		return esCancelable;
	}
	public void setEsCancelable(JAXBElement<String> esCancelable) {
		this.esCancelable = esCancelable;
	}
	public JAXBElement<String> getCodigoEstatus() {
		return codigoEstatus;
	}
	public void setCodigoEstatus(JAXBElement<String> codigoEstatus) {
		this.codigoEstatus = codigoEstatus;
	}
	public JAXBElement<String> getEstado() {
		return estado;
	}
	public void setEstado(JAXBElement<String> estado) {
		this.estado = estado;
	}
	public JAXBElement<String> getEstatusCancelacion() {
		return estatusCancelacion;
	}
	public void setEstatusCancelacion(JAXBElement<String> estatusCancelacion) {
		this.estatusCancelacion = estatusCancelacion;
	}
	
	
}
