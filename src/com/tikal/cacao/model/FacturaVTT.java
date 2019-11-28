package com.tikal.cacao.model;

import java.util.Date;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Index;
import com.tikal.cacao.factura.Estatus;
import com.tikal.cacao.sat.cfd33.Comprobante;

/**
 * <p>&Eacute;sta clase modela una factura en la <strong>versi&oacute;n 3.3</strong> de un Comprobante
 *    Fiscal Digital por Internet.</p>
 * @author Tikal
 *
 */
@Entity
public class FacturaVTT {
	
	@Id
	private String uuid;

	@Ignore
	private Comprobante cfdi;
	
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
	
	/**Comentarios que se ingresan en el PDF de la factura */
	private String comentarios;
	
	private Estatus estatus;
	
	private String proveedor;

	public FacturaVTT() { }
	
	public FacturaVTT(String uuid, String cfdi, String rfcEmisor,
			String nombreReceptor, Date fecha, String sello, byte[] codigoQR) {
		
		this.uuid = uuid;
		this.cfdiXML = cfdi;
		//this.cfdi = cfdi;
		this.rfcEmisor = rfcEmisor;
		this.nombreReceptor = nombreReceptor;
		this.fechaCertificacion = fecha;
		this.selloDigital = sello;
		this.codigoQR = codigoQR;
		this.configurarEstatus();
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
	 * @return the fechaCertificacion
	 */
	public Date getFechaCertificacion() {
		return fechaCertificacion;
	}

	/**
	 * @param fechaCertificacion the fechaCertificacion to set
	 */
	public void setFechaCertificacion(Date fechaCertificacion) {
		this.fechaCertificacion = fechaCertificacion;
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
	
	public String getAcuseCancelacionXML() {
		return acuseCancelacionXML;
	}

	public void setAcuseCancelacionXML(String acuseCancelacionXML) {
		this.acuseCancelacionXML = acuseCancelacionXML;
	}

	public Date getFechaCancelacion() {
		return fechaCancelacion;
	}

	public void setFechaCancelacion(Date fechaCancelacion) {
		this.fechaCancelacion = fechaCancelacion;
	}

	public String getSelloCancelacion() {
		return selloCancelacion;
	}

	public void setSelloCancelacion(String selloCancelacion) {
		this.selloCancelacion = selloCancelacion;
	}
	
	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	private void configurarEstatus() {
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

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
}
