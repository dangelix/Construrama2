package com.finkok.facturacion.cancel;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "get_sat_status", propOrder = {
    "username",
    "password",
    "taxpayer_id",
    "rtaxpayer_id",
    "uuid",
    "total"
})
@XmlRootElement(name = "get_sat_status")
public class GetSATEstatus {

	 	@XmlElementRef(name = "username", namespace = "http://facturacion.finkok.com/cancel", type = JAXBElement.class, required = false)
	    protected JAXBElement<String> username;
	    @XmlElementRef(name = "password", namespace = "http://facturacion.finkok.com/cancel", type = JAXBElement.class, required = false)
	    protected JAXBElement<String> password;
	    @XmlElementRef(name = "taxpayer_id", namespace = "http://facturacion.finkok.com/cancel", type = JAXBElement.class, required = false)
	    protected JAXBElement<String> taxpayer_id;
	    @XmlElementRef(name = "rtaxpayer_id", namespace = "http://facturacion.finkok.com/cancel", type = JAXBElement.class, required = false)
	    protected JAXBElement<String> rtaxpayer_id;
	    @XmlElementRef(name = "uuid", namespace = "http://facturacion.finkok.com/cancel", type = JAXBElement.class, required = false)
	    protected JAXBElement<String> uuid;
	    @XmlElementRef(name = "total", namespace = "http://facturacion.finkok.com/cancel", type = JAXBElement.class, required = false)
	    protected JAXBElement<String> total;
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
		public void setTaxpayer_id(JAXBElement<String> taxpayer_id) {
			this.taxpayer_id = taxpayer_id;
		}
		public JAXBElement<String> getRtaxpayer_id() {
			return rtaxpayer_id;
		}
		public void setRtaxpayer_id(JAXBElement<String> rtaxpayer_id) {
			this.rtaxpayer_id = rtaxpayer_id;
		}
		public JAXBElement<String> getUuid() {
			return uuid;
		}
		public void setUuid(JAXBElement<String> uuid) {
			this.uuid = uuid;
		}
		public JAXBElement<String> getTotal() {
			return total;
		}
		public void setTotal(JAXBElement<String> total) {
			this.total = total;
		}
	    
}
