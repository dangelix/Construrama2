package com.finkok.facturacion.cancel;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import views.core.soap.services.apps.UUIDS;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sign_cancel", propOrder = {
    "uuids",
    "username",
    "password",
    "taxpayer_id",
    "serial",
    "store_pending"
})
@XmlRootElement(name = "sign_cancel")
public class SignCancel{
	
		@XmlElementRef(name = "UUIDS", namespace = "apps.services.soap.core.views", type = JAXBElement.class, required = false)
	    protected JAXBElement<UUIDS> uuids;
	    @XmlElementRef(name = "username", namespace = "http://facturacion.finkok.com/cancel", type = JAXBElement.class, required = false)
	    protected JAXBElement<String> username;
	    @XmlElementRef(name = "password", namespace = "http://facturacion.finkok.com/cancel", type = JAXBElement.class, required = false)
	    protected JAXBElement<String> password;
	    @XmlElementRef(name = "taxpayer_id", namespace = "http://facturacion.finkok.com/cancel", type = JAXBElement.class, required = false)
	    protected JAXBElement<String> taxpayer_id;
	    @XmlElementRef(name = "serial", namespace = "http://facturacion.finkok.com/cancel", type = JAXBElement.class, required = false)
	    protected JAXBElement<String> serial;
	    @XmlElementRef(name = "store_pending", namespace = "http://facturacion.finkok.com/cancel", type = JAXBElement.class, required = false)
	    protected JAXBElement<Boolean> store_pending;
		public JAXBElement<UUIDS> getUUIDS() {
			return uuids;
		}
		public void setUUIDS(JAXBElement<UUIDS> uuids) {
			this.uuids = uuids;
		}
		public JAXBElement<String> getUsername() {
			return username;
		}
		public void setUsername(JAXBElement<String> username) {
			this.username = username;
		}
		public JAXBElement<String> getPassword() {
			return password;
		}
		public void setPassword(JAXBElement<String> password) {
			this.password = password;
		}
		public JAXBElement<String> getTaxpayer_id() {
			return taxpayer_id;
		}
		public void setTaxpayerId(JAXBElement<String> taxpayer_id) {
			this.taxpayer_id = taxpayer_id;
		}
		public JAXBElement<String> getSerial() {
			return serial;
		}
		public void setSerial(JAXBElement<String> serial) {
			this.serial = serial;
		}
		public JAXBElement<Boolean> getStore_pending() {
			return store_pending;
		}
		public void setStorePending(JAXBElement<Boolean> store_pending) {
			this.store_pending = store_pending;
		}
	    
}
