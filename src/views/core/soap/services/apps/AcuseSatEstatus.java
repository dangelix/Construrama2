package views.core.soap.services.apps;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import views.core.soap.services.apps.AcuseRecepcionCFDI;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "acuseSatEstatus", propOrder = {
    "error",
    "sat",
    "signStampResult"
})
public class AcuseSatEstatus {

	@XmlElementRef(name = "error", namespace = "apps.services.soap.core.views", type = JAXBElement.class, required = false)
	protected JAXBElement<String> error;
	@XmlElementRef(name = "sat", namespace = "apps.services.soap.core.views", type = JAXBElement.class, required = false)
    protected JAXBElement<AcuseSATConsulta> sat;
	
	@XmlElementRef(name = "signStampResult", namespace = "apps.services.soap.core.views", type = JAXBElement.class, required = false)
    protected JAXBElement<AcuseSATConsulta> signStampResult;

	public JAXBElement<AcuseSATConsulta> getSignStampResult() {
		return signStampResult;
	}

	public void setSignStampResult(JAXBElement<AcuseSATConsulta> signStampResult) {
		this.signStampResult = signStampResult;
	}

	public JAXBElement<String> getError() {
		return error;
	}

	public void setError(JAXBElement<String> error) {
		this.error = error;
	}

	public JAXBElement<AcuseSATConsulta> getSat() {
		return sat;
	}

	public void setSat(JAXBElement<AcuseSATConsulta> sat) {
		this.sat = sat;
	}
	
	
}
