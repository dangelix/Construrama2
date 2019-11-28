package com.finkok.facturacion.registration;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registrationResult", propOrder = {
    "message",
    "success"
})
public class RegistrationResult {

	
	@XmlElementRef(name = "message", namespace = "http://facturacion.finkok.com/registration", type = JAXBElement.class, required = false)
	protected JAXBElement<String> message;
	
	@XmlElementRef(name = "success", namespace = "http://facturacion.finkok.com/registration", type = JAXBElement.class, required = false)
	protected JAXBElement<Boolean> success;

	public JAXBElement<String> getMessage() {
		return message;
	}

	public void setMessage(JAXBElement<String> message) {
		this.message = message;
	}

	public JAXBElement<Boolean> getSuccess() {
		return success;
	}

	public void setSuccess(JAXBElement<Boolean> success) {
		this.success = success;
	}
	
	
}
