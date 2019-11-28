package com.finkok.facturacion.cancel;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sign_cancelResponse", propOrder = {
    "signCancelResult"
})
@XmlRootElement(name = "sign_cancelResponse")
public class SignCancelResponse {
	
	@XmlElementRef(name = "sign_cancelResult", namespace = "http://facturacion.finkok.com/cancel", type = JAXBElement.class, required = false)
    protected JAXBElement<CancelaCFDResult> signCancelResult;

	public JAXBElement<CancelaCFDResult> getSignCancelResult() {
		return signCancelResult;
	}

	public void setSignCancelResult(JAXBElement<CancelaCFDResult> signCancelResult) {
		this.signCancelResult = signCancelResult;
	}
	
	
}
