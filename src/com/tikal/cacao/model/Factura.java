package com.tikal.cacao.model;

import java.util.Date;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Index;
import com.tikal.cacao.factura.Estatus;
import com.tikal.cacao.sat.cfd.Comprobante;

/**
 * @author Tikal
 *
 */
@Entity
public class Factura {

	@Id
	private String uuid;
	
	@Ignore
	private Comprobante cfdi; // el Datastore no permite guardar este objeto porque tiene atributos BigDecimal que no es un tipo soportado
	
	private String cfdiXML;
	
	private String acuseCancelacionXML;
	
	@Index
	private String rfcEmisor;
	
	private String nombreReceptor;
	
	/**	<p>La fecha de certificaci&oacuten del la factura cuando ha sido timbrada.</p>
	 * <p>Si la factura no ha sido timbrada entonces este campo debe tener la fecha de 
	 *    emisi&oacute;n.</p> */
	@Index
	private Date fechaCertificacion;
	
	private Date fechaCancelacion;
	
	private String selloCancelacion;
	
	private String selloDigital;
	
	private byte[] codigoQR;
	
	private Estatus estatus;
	
	/**
	 * <p>Constructor vac&iacute;o de una {@code Factura}. <p>
	 * <p>&Eacute;ste constructor es utilizado por <em>objectify</em></p>
	 */
	public Factura() { }
	
	public Factura(String uuid, String cfdi, String rfcEmisor , String nombreReceptor, Date fecha, String sello, byte[] codigoQR) {
		this.uuid = uuid;
		this.cfdiXML = cfdi;
		//this.cfdi = cfdi;
		this.rfcEmisor = rfcEmisor;
		this.nombreReceptor = nombreReceptor;
		this.fechaCertificacion = fecha;
		this.selloDigital = sello;
		this.codigoQR = codigoQR;
		this.setEstatus();
	}

	
	public String getUuid() {
		return uuid;
	}
	
	/**
	 * @return the cfdi
	 */
	public Comprobante getCfdi() {
		return cfdi;
	}

	/**
	 * @param cfdi the cfdi to set
	 */
	public void setCfdi(Comprobante cfdi) {
		this.cfdi = cfdi;
	}

	/**
	 * @return the cfdiXML
	 */
	public String getCfdiXML() {
		return cfdiXML;
	}

	/**
	 * @param cfdiXML the cfdiXML to set
	 */
	public void setCfdiXML(String cfdiXML) {
		this.cfdiXML = cfdiXML;
	}

	/**
	 * @return the acuseCancelacionXML
	 */
	public String getAcuseCancelacionXML() {
		return acuseCancelacionXML;
	}

	/**
	 * @param acuseCancelacionXML the acuseCancelacionXML to set
	 */
	public void setAcuseCancelacionXML(String acuseCancelacionXML) {
		this.acuseCancelacionXML = acuseCancelacionXML;
	}

	/**
	 * @return the rfcEmisor
	 */
	public String getRfcEmisor() {
		return rfcEmisor;
	}

	/**
	 * @param rfcEmisor the rfcEmisor to set
	 */
	public void setRfcEmisor(String rfcEmisor) {
		this.rfcEmisor = rfcEmisor;
	}

	/**
	 * @return the nombreReceptor
	 */
	public String getNombreReceptor() {
		return nombreReceptor;
	}

	/**
	 * @param nombreReceptor the nombreReceptor to set
	 */
	public void setNombreReceptor(String nombreReceptor) {
		this.nombreReceptor = nombreReceptor;
	}

	/**
	 * @return the fecha
	 */
	public Date getFechaCertificacion() {
		return fechaCertificacion;
	}
	
	/**
	 * @param fecha the fecha  to set
	 */
	public void setFechaCertificacion (Date fecha) {
		this.fechaCertificacion = fecha;
	}

	/**
	 * @return the fechaCancelacion
	 */
	public Date getFechaCancelacion() {
		return fechaCancelacion;
	}

	/**
	 * @param fechaCancelacion the fechaCancelacion to set
	 */
	public void setFechaCancelacion(Date fechaCancelacion) {
		this.fechaCancelacion = fechaCancelacion;
	}

	/**
	 * @return the selloCancelacion
	 */
	public String getSelloCancelacion() {
		return selloCancelacion;
	}

	/**
	 * @param selloCancelacion the selloCancelacion to set
	 */
	public void setSelloCancelacion(String selloCancelacion) {
		this.selloCancelacion = selloCancelacion;
	}

	/**
	 * @return the selloDigital
	 */
	public String getSelloDigital() {
		return selloDigital;
	}

	/**
	 * @param selloDigital the selloDigital to set
	 */
	public void setSelloDigital(String selloDigital) {
		this.selloDigital = selloDigital;
	}

	/**
	 * @return the codigoQR
	 */
	public byte[] getCodigoQR() {
		return codigoQR;
	}

	/**
	 * @param codigoQR the codigoQR to set
	 */
	public void setCodigoQR(byte[] codigoQR) {
		this.codigoQR = codigoQR;
	}

	/**
	 * @return the estatus
	 */
	public Estatus getEstatus() {
		return estatus;
	}

	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(Estatus estatus) {
		this.estatus = estatus;
	}
	
	private void setEstatus() {
		boolean camposNoTimbrado = (
				this.selloDigital == null && this.codigoQR == null);
		
		boolean camposSiTimbrado = (
			this.selloDigital != null && this.codigoQR != null);
		
		boolean camposGenerado = (this.cfdiXML != null && this.rfcEmisor != null &&
				this.nombreReceptor != null);
		
		if ( camposNoTimbrado && camposGenerado ) {
			this.estatus = Estatus.GENERADO;
		} else if (camposSiTimbrado) {
			this.estatus = Estatus.TIMBRADO;
		}
	}
	
}