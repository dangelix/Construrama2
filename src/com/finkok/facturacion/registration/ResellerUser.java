package com.finkok.facturacion.registration;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResellerUser", propOrder = {
    "status",
    "counter",
    "taxpayer_id",
    "credit"
})
public class ResellerUser {

	@XmlElementRef(name = "status", namespace = "http://facturacion.finkok.com/registration", type = JAXBElement.class, required = false)
	protected JAXBElement<String> status;
	
	@XmlElementRef(name = "counter", namespace = "http://facturacion.finkok.com/registration", type = JAXBElement.class, required = false)
	protected JAXBElement<Integer> counter;
	
	@XmlElementRef(name = "taxpayer_id", namespace = "http://facturacion.finkok.com/registration", type = JAXBElement.class, required = false)
	protected JAXBElement<String> taxpayer_id;
	
	@XmlElementRef(name = "credit", namespace = "http://facturacion.finkok.com/registration", type = JAXBElement.class, required = false)
	protected JAXBElement<Integer> credit;

	public JAXBElement<String> getStatus() {
		return status;
	}

	public void setStatus(JAXBElement<String> status) {
		this.status = status;
	}

	public JAXBElement<Integer> getCounter() {
		return counter;
	}

	public void setCounter(JAXBElement<Integer> counter) {
		this.counter = counter;
	}

	public JAXBElement<String> getTaxpayer_id() {
		return taxpayer_id;
	}

	public void setTaxpayer_id(JAXBElement<String> taxpayer_id) {
		this.taxpayer_id = taxpayer_id;
	}

	public JAXBElement<Integer> getCredit() {
		return credit;
	}

	public void setCredit(JAXBElement<Integer> credit) {
		this.credit = credit;
	}
	
	
}
