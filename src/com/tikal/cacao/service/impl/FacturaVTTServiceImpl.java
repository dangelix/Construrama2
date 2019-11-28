package com.tikal.cacao.service.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.tempuri.CancelaCFDIAckResponse;
import org.tempuri.ObtieneCFDIResponse;
import org.tempuri.RegistraEmisorResponse;
import org.tempuri.TimbraCFDIResponse;

import com.finkok.facturacion.cancel.CancelaCFDResult;
import com.finkok.facturacion.registration.AddResponse;
import com.finkok.facturacion.registration.RegistrationResult;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfWriter;
import com.tikal.cacao.dao.BitacoraDAO;
//import com.tikal.cacao.dao.BitacoraDAO;
import com.tikal.cacao.dao.FacturaVttDAO;
import com.tikal.cacao.dao.ImagenDAO;
import com.tikal.cacao.dao.ReporteRenglonDAO;
//import com.tikal.cacao.dao.ReporteRenglonDAO;
//import com.tikal.cacao.dao.SerialDAO;
import com.tikal.cacao.dao.SimpleHibernateDAO;
import com.tikal.cacao.dao.imp.ProveedoresDAOImp;
import com.tikal.cacao.dao.sql.RegimenFiscalDAO;
import com.tikal.cacao.dao.sql.UsoDeCFDIDAO;
import com.tikal.cacao.factura.Estatus;
import com.tikal.cacao.factura.RespuestaWebServicePersonalizada;
import com.tikal.cacao.factura.ws.WSClientCfdi33;
import com.tikal.cacao.factura.wsfinkok.FinkokClient;
import com.tikal.cacao.model.Imagen;
import com.tikal.cacao.model.Proveedores;
import com.tikal.cacao.model.RegistroBitacora;
//import com.tikal.cacao.model.RegistroBitacora;
//import com.tikal.cacao.model.Serial;
import com.tikal.cacao.model.orm.FormaDePago;
import com.tikal.cacao.model.orm.RegimenFiscal;
import com.tikal.cacao.model.orm.TipoDeComprobante;
import com.tikal.cacao.model.orm.UsoDeCFDI;
//import com.tikal.cacao.reporte.ComplementoRenglon;
import com.tikal.cacao.model.ReporteRenglon;
import com.tikal.cacao.sat.cfd.catalogos.dyn.C_MetodoDePago;
//import com.tikal.cacao.reporte.ReporteRenglon;
import com.tikal.cacao.sat.cfd33.Comprobante;
import com.tikal.cacao.sat.cfd33.Comprobante.Conceptos.Concepto;
import com.tikal.cacao.sat.cfd33.Comprobante.Conceptos.Concepto.Impuestos.Traslados.Traslado;
import com.tikal.cacao.sat.cfd33.Comprobante.Impuestos;
import com.tikal.cacao.service.FacturaVTTService;
import com.tikal.cacao.springController.viewObjects.v33.ComprobanteConComentarioVO;
import com.tikal.cacao.springController.viewObjects.v33.ComprobanteVO;
import com.tikal.cacao.util.EmailSender;
import com.tikal.cacao.util.Util;
import com.tikal.toledo.dao.SeriesDAO;
import com.tikal.toledo.model.FacturaVTT;
import com.tikal.toledo.util.JsonConvertidor;
import com.tikal.toledo.util.PDFFacturaV33;

import localhost.EncodeBase64;
import mx.gob.sat.cancelacfd.Acuse;
import mx.gob.sat.timbrefiscaldigital.TimbreFiscalDigital;
import views.core.soap.services.apps.AcuseRecepcionCFDI;
import views.core.soap.services.apps.Folio;
import views.core.soap.services.apps.Incidencia;

@Service
public class FacturaVTTServiceImpl implements FacturaVTTService {

	@Autowired
	private WSClientCfdi33 webServiceClient33;
	
	@Autowired
	private FinkokClient serviceFinkok;

	@Autowired
	private ProveedoresDAOImp proveedoresDAO;


	@Autowired
	private FacturaVttDAO facturaVTTDAO;

	@Autowired
	private ReporteRenglonDAO repRenglonDAO;
//
	@Autowired
	private BitacoraDAO bitacoradao;

//	@Autowired
//	private SerialDAO serialDAO;
//
	@Autowired
	private ImagenDAO imagenDAO;

	@Autowired
	@Qualifier("usoDeCfdiDAOH")
	private UsoDeCFDIDAO usoDeCFDIDAO;

	@Autowired
	@Qualifier("regimenFiscalDAOH")
	private RegimenFiscalDAO regimenFiscalDAO;

	@Autowired
	@Qualifier("formaDePagoDAOH")
	private SimpleHibernateDAO<FormaDePago> formaDePagoDAO;

	@Autowired
	@Qualifier("tipoDeComprobanteDAOH")
	private SimpleHibernateDAO<TipoDeComprobante> tipoDeComprobanteDAO;
	
	@Autowired
	private SeriesDAO seriesdao;

	@Override
	public String registrarEmisor(String cadenaUrlCer, String cadenaUrlKey, String pwd, String rfc,
			HttpSession sesion) {
		HttpURLConnection connCer = null;
		HttpURLConnection connKey = null;

		ByteArrayInputStream objCer = null;
		String strUrlCer = "https://facturacion.tikal.mx/cers/".concat(cadenaUrlCer);
		String strUrlKey = "https://facturacion.tikal.mx/cers/".concat(cadenaUrlKey);

		try {
			URL urlCer = new URL(strUrlCer);

			connCer = (HttpURLConnection) urlCer.openConnection();
			connCer.connect();
//			objCer = (ByteArrayInputStream)connCer.getContent();//.toString().getBytes());
			InputStream aux= connCer.getInputStream();
//			connCer.disconnect();
			connCer = null;
			urlCer = null;

			URL urlKey = new URL(strUrlKey);

			connKey = (HttpURLConnection) urlKey.openConnection();
			connKey.connect();
			InputStream objKey = connKey.getInputStream();
			
			
				RegistraEmisorResponse registraEmisorResponse = webServiceClient33.getRegistraEmisorResponse(rfc, pwd,
						aux, objKey);
				List<Object> respuesta = registraEmisorResponse.getRegistraEmisorResult().getAnyType();
	//			String mensajeRespuesta="";
				String mensajeRespuesta = (String) respuesta.get(2);
				if (respuesta.get(1) instanceof Integer) {
					int codigoRespuesta = (int) respuesta.get(1);
	//				mensajeRespuesta=(String) respuesta.get(2);
					if (codigoRespuesta == 0) {
						String evento = "Se registró al emisor del rfc: " + rfc;
						mensajeRespuesta= evento;
						RegistroBitacora registroBitacora = Util.crearRegistroBitacora(sesion, "Operacional", evento);
						bitacoradao.addReg(registroBitacora);
//						return "Los archivos del emisor fueron registrados. ".concat(mensajeRespuesta);
					}
//					return mensajeRespuesta;
				} else {
					if(respuesta.get(1) instanceof String) {
						String codigoRespuesta= (String) respuesta.get(1);
						if(codigoRespuesta.compareTo("0")==0) {
							String evento = "Se registró al emisor del rfc: " + rfc;
							mensajeRespuesta= evento;
							RegistroBitacora registroBitacora = Util.crearRegistroBitacora(sesion, "Operacional", evento);
							bitacoradao.addReg(registroBitacora);
						}else {
							return mensajeRespuesta;
						}
					}else {
						return mensajeRespuesta;
					}
				}

//			}else{
				AddResponse response= (AddResponse) serviceFinkok.getRegistraEmisorResponse(rfc, pwd, aux, objKey);
				RegistrationResult result= response.getAddResult().getValue();
				if(result.getSuccess()!=null) {
					if(result.getSuccess().getValue()){
						String evento = "Se registró al emisor del rfc: " + rfc;
						//RegistroBitacora registroBitacora = Util.crearRegistroBitacora(sesion, "Operacional", evento);
						//bitacoradao.addReg(registroBitacora);
						return "Los archivos del emisor fueron registrados. ";
					}else{
						return result.getMessage().getValue();
					}
				}else {
					return mensajeRespuesta;
				}
				
//			}
			
		} catch (MalformedURLException e) {
			return e.getMessage();
		} catch (IOException e) {
			return e.getMessage();
		}

	}

	@Override
	public String generar(ComprobanteConComentarioVO comprobanteConComentario, HttpSession sesion) {
		Comprobante c = comprobanteConComentario.getComprobante();
		String xmlComprobante = Util.marshallComprobante33(c, false);

		FacturaVTT factura = new FacturaVTT(Util.randomString(10), xmlComprobante, c.getEmisor().getRfc(),
				c.getReceptor().getNombre(), Util.xmlGregorianAFecha(c.getFecha()), null, null);
		factura.setComentarios(comprobanteConComentario.getComentario());

		facturaVTTDAO.guardar(factura);
		//this.crearReporteRenglon(factura);
		this.crearReporteRenglon(factura, c.getMetodoPago(), c.getTipoDeComprobante().getValor(),null);

		String evento = "Se guardó la prefactura con id: " + factura.getUuid();
//		RegistroBitacora registroBitacora = Util.crearRegistroBitacora(sesion, "Operacional", evento);
//		bitacoradao.addReg(registroBitacora);

		return "¡La factura se generó con éxito!";
	}

	@Override
	public String actualizar(ComprobanteConComentarioVO comprobanteConComentario, String uuid, HttpSession sesion) {
		Comprobante c = comprobanteConComentario.getComprobante();
		String xmlComprobante = Util.marshallComprobante33(c, false);

		FacturaVTT factura = new FacturaVTT(uuid, xmlComprobante, c.getEmisor().getRfc(), c.getReceptor().getNombre(),
				Util.xmlGregorianAFecha(c.getFecha()), null, null);
		factura.setComentarios(comprobanteConComentario.getComentario());

		facturaVTTDAO.guardar(factura);
		//this.crearReporteRenglon(factura);
		this.crearReporteRenglon(factura, c.getMetodoPago(), c.getTipoDeComprobante().getValor(),null);

		String evento = "Se actualizó la prefactura con id: " + factura.getUuid();
		RegistroBitacora registroBitacora = Util.crearRegistroBitacora(sesion, "Operacional", evento);
		bitacoradao.addReg(registroBitacora);

		return "¡La factura se actualizó con éxito!";
	}

	@Override
	public String timbrarCFDIGenerado(String uuid, String email, HttpSession sesion) {
		FacturaVTT factura = facturaVTTDAO.consultar(uuid);
		Comprobante comprobante = Util.unmarshallCFDI33XML(factura.getCfdiXML());
		RespuestaWebServicePersonalizada respWBPersonalizada = this.timbrar(comprobante, factura.getComentarios(),
				email);

		if (respWBPersonalizada.getUuidFactura() != null) {
			// SE TIMBRÓ LA FACTURA CON ÉXITO
			String evento = "Se timbró la factura guardada con el id: " + uuid + " y se generó el CFDI con UUID: "
					+ respWBPersonalizada.getUuidFactura();
			RegistroBitacora registroBitacora = Util.crearRegistroBitacora(sesion, "Operacional", evento);
			bitacoradao.addReg(registroBitacora);
			facturaVTTDAO.eliminar(factura);
//			repRenglonDAO.eliminar(uuid);
		} else {
			RegistroBitacora registroBitacora = Util.crearRegistroBitacora(sesion, "Operacional",
					respWBPersonalizada.getMensajeRespuesta() + " UUID: " + uuid);
			bitacoradao.addReg(registroBitacora);
		}

		return respWBPersonalizada.getMensajeRespuesta();
	}

	@Override
	public String timbrar(String json, String uuid, HttpSession sesion) {
		ComprobanteVO cVO = (ComprobanteVO) JsonConvertidor.fromJson(json, ComprobanteVO.class);
		RespuestaWebServicePersonalizada respWBPersonalizada = this.timbrar(cVO.getComprobante(), cVO.getComentarios(),
				cVO.getEmail());

		if (respWBPersonalizada.getUuidFactura() != null) {
			String evento = "Se actualizo y se timbró la factura guardada con el id: " + uuid
					+ " y se generó el CFDI con UUID: " + respWBPersonalizada.getUuidFactura();
			RegistroBitacora registroBitacora = Util.crearRegistroBitacora(sesion, "Operacional", evento);
			bitacoradao.addReg(registroBitacora);
			facturaVTTDAO.eliminar(facturaVTTDAO.consultar(uuid));
//			repRenglonDAO.eliminar(uuid);
		} else {
			RegistroBitacora registroBitacora = Util.crearRegistroBitacora(sesion, "Operacional",
					respWBPersonalizada.getMensajeRespuesta() + " UUID: " + uuid);
			bitacoradao.addReg(registroBitacora);
		}
		return respWBPersonalizada.getMensajeRespuesta();
	}

	@Override
	public RespuestaWebServicePersonalizada timbrarPOS(ComprobanteVO comprobanteVO, HttpSession sesion) {
		RespuestaWebServicePersonalizada respWBPersonalizada = this.timbrar(comprobanteVO.getComprobante(),
				comprobanteVO.getComentarios(), comprobanteVO.getEmail());

		if (respWBPersonalizada.getUuidFactura() != null) {
			if (sesion.getAttribute("userName") != null) {
//				RegistroBitacora registroBitacora = Util.crearRegistroBitacora(sesion, "Operacional", evento);
//				bitacoradao.addReg(registroBitacora);
			}
			return respWBPersonalizada;
		} else {
//			RegistroBitacora registroBitacora = Util.crearRegistroBitacora(sesion, "Operacional",
//					respWBPersonalizada.getMensajeRespuesta() + " Serie y Folio del CFDI: "
//							+ comprobanteVO.getComprobante().getSerie() + comprobanteVO.getComprobante().getFolio());
//			bitacoradao.addReg(registroBitacora);
		}
		return respWBPersonalizada;
	}
	
	public String timbrar(ComprobanteVO comprobanteVO, HttpSession sesion) {
		RespuestaWebServicePersonalizada respWBPersonalizada = this.timbrar(comprobanteVO.getComprobante(),
				comprobanteVO.getComentarios(), comprobanteVO.getEmail());

		if (respWBPersonalizada.getUuidFactura() != null) {
			if (sesion.getAttribute("userName") != null) {
//				RegistroBitacora registroBitacora = Util.crearRegistroBitacora(sesion, "Operacional", evento);
//				bitacoradao.addReg(registroBitacora);
			}
			return respWBPersonalizada.getUuidFactura();
		} else {
//			RegistroBitacora registroBitacora = Util.crearRegistroBitacora(sesion, "Operacional",
//					respWBPersonalizada.getMensajeRespuesta() + " Serie y Folio del CFDI: "
//							+ comprobanteVO.getComprobante().getSerie() + comprobanteVO.getComprobante().getFolio());
//			bitacoradao.addReg(registroBitacora);
		}
		return respWBPersonalizada.getUuidFactura();
	}

	@Override
	public String cancelarAck(String uuid, String rfcEmisor, HttpSession sesion) {
		System.out.println("fac ovannikdvmkñm");
		System.out.println("rfc emisor"+rfcEmisor);
		
		ReporteRenglon repRenglon = repRenglonDAO.consultar(uuid);
		FacturaVTT f= facturaVTTDAO.consultar(uuid);
		System.out.println("proveedor"+f.getProveedor());
		System.out.println("factura"+f);
		if(f.getProveedor()!=null){
			if(f.getProveedor().compareTo("finkok")==0){
				CancelaCFDResult result= this.serviceFinkok.cancela(uuid, rfcEmisor,"-");
				System.out.println("result:"+result.getAcuse());
				if(result.getFolios()!=null){
					Folio folio= result.getFolios().getValue().getFolio().get(0);
					String estatusUUID= folio.getEstatusUUID().getValue();
					switch(estatusUUID) {
						case "708":{
							FacturaVTT facturaACancelar = facturaVTTDAO.consultar(uuid);
							String acuseXML = result.getAcuse().getValue();
							acuseXML= acuseXML.replace("<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">", "");
							acuseXML= acuseXML.replace("</s:Envelope>", "");
							acuseXML= acuseXML.replaceAll("<CancelaCFDResponse xmlns=\"http://cancelacfd.sat.gob.mx\">", "");
							acuseXML= acuseXML.replace("</CancelaCFDResult></CancelaCFDResponse></s:Body>", "</Acuse>");
							acuseXML= acuseXML.replace("<CancelaCFDResult", "<Acuse xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns=\"http://cancelacfd.sat.gob.mx\"");
							return this.procesaCancelado(acuseXML, facturaACancelar, repRenglon, sesion, Estatus.CANCELADO);
						}
						case "201":{
							FacturaVTT facturaACancelar = facturaVTTDAO.consultar(uuid);
							String acuseXML = result.getAcuse().getValue();
							acuseXML= acuseXML.replace("<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">", "");
							acuseXML= acuseXML.replace("</s:Envelope>", "");
							acuseXML= acuseXML.replaceAll("<CancelaCFDResponse xmlns=\"http://cancelacfd.sat.gob.mx\">", "");
							acuseXML= acuseXML.replace("</CancelaCFDResult></CancelaCFDResponse></s:Body>", "</Acuse>");
							acuseXML= acuseXML.replace("<CancelaCFDResult", "<Acuse xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns=\"http://cancelacfd.sat.gob.mx\"");
							
							return this.procesaCancelado(acuseXML, facturaACancelar, repRenglon, sesion, Estatus.CANCELADO);
						}
						
						case "202":{
							FacturaVTT facturaACancelar = facturaVTTDAO.consultar(uuid);
							String acuseXML = result.getAcuse().getValue();
							acuseXML= acuseXML.replace("<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">", "");
							acuseXML= acuseXML.replace("</s:Envelope>", "");
							acuseXML= acuseXML.replaceAll("<CancelaCFDResponse xmlns=\"http://cancelacfd.sat.gob.mx\">", "");
							acuseXML= acuseXML.replace("</CancelaCFDResult></CancelaCFDResponse></s:Body>", "</Acuse>");
							acuseXML= acuseXML.replace("<CancelaCFDResult", "<Acuse xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns=\"http://cancelacfd.sat.gob.mx\"");
							
							return this.procesaCancelado(acuseXML, facturaACancelar, repRenglon, sesion, Estatus.CANCELADO);
						}
					} //del switch
					
				}else {                         //if folios==null
					String aux=result.getCodEstatus().getValue();
					String evento =aux; 
					if(aux.contains("version=\"1.0\"")) {
						aux="Error:";
						result.getCodEstatus().setValue(aux);
					}
					RegistroBitacora registroBitacora = Util.crearRegistroBitacora(sesion, "Operacional", evento);
					//bitacoradao.addReg(registroBitacora);
				}
				
				return this.construirMensajeError(result).getMensajeRespuesta();
			} // si el provedoor es profac
		}
		
		System.out.println("segund parte....");
		CancelaCFDIAckResponse cancelaCFDIAckResponse = webServiceClient33.getCancelaCFDIAckResponse(uuid, rfcEmisor);
		List<Object> respuestaWB = cancelaCFDIAckResponse.getCancelaCFDIAckResult().getAnyType();
		System.out.println("respuestaWBS:"+respuestaWB);
		int codigoRespuesta = -1;
		String strCodigoRespuesta = "";
		if (respuestaWB.get(6) instanceof Integer) {
			codigoRespuesta = (Integer) respuestaWB.get(6);
			if (codigoRespuesta==0) {
				FacturaVTT facturaACancelar = facturaVTTDAO.consultar(uuid);

				String acuseXML = (String) respuestaWB.get(3);
				
				StringBuilder stringBuilder = new StringBuilder(acuseXML);
				stringBuilder.insert(106, " xmlns=\"http://cancelacfd.sat.gob.mx\" ");
				String acuseXML2 = stringBuilder.toString();
				RegistroBitacora registroBitacora = Util.crearRegistroBitacora(sesion, "Resultado Caneclar", acuseXML2);
				bitacoradao.addReg(registroBitacora);
				
				try {
					this.procesaCancelado(acuseXML2, facturaACancelar, repRenglon, sesion, Estatus.CANCELADO);
				}catch(RuntimeException e) {
					this.corregirFactura(uuid, rfcEmisor, sesion);
					return "Comprobante cancelado";
				}
				return (String) respuestaWB.get(2); // regresa "Comprobante
													// cancelado"
			}else {
				String mensaje=(String)respuestaWB.get(2);
				if(mensaje.contains("UUID Previamente")) {
					this.corregirFactura(uuid, rfcEmisor, sesion);
					return "Comprobante cancelado";
				}
				if(codigoRespuesta== 330279){
					FacturaVTT facturaACancelar = facturaVTTDAO.consultar(uuid);
					return this.procesaCancelado(null, facturaACancelar, repRenglon, sesion, Estatus.PENDIENTE);
				}
				else {
					RespuestaWebServicePersonalizada respPersonalizada = this.construirMensajeError(respuestaWB);
					RegistroBitacora registroBitacora = Util.crearRegistroBitacora(sesion, "Operacional",
							respPersonalizada.getMensajeRespuesta() + "Operación CancelaAck (codigoRespuesta != 0), UUID:"
									+ uuid);
					bitacoradao.addReg(registroBitacora);
					return respPersonalizada.getMensajeRespuesta();
				}
			}
		} else {
			if (respuestaWB.get(6) instanceof String) {
				String strRespuesta = (String) respuestaWB.get(6);
				if (strRespuesta.contentEquals("0")) {
					RespuestaWebServicePersonalizada respPersonalizada = this.construirMensaje(respuestaWB);
					RegistroBitacora registroBitacora = Util.crearRegistroBitacora(sesion, "Operacional",
							respPersonalizada.getMensajeRespuesta() + " UUID:" + uuid);
					bitacoradao.addReg(registroBitacora);
					return respPersonalizada.getMensajeRespuesta();
				}
			}
			String mensaje=(String)respuestaWB.get(2);
			if(mensaje.contains("UUID Previamente")) {
				this.corregirFactura(uuid, rfcEmisor, sesion);
				return "Comprobante cancelado";
			}
			RespuestaWebServicePersonalizada respPersonalizada = this.construirMensajeError(respuestaWB);
			RegistroBitacora registroBitacora = Util.crearRegistroBitacora(sesion, "Operacional",
					respPersonalizada.getMensajeRespuesta()
							+ "Operación CancelaAck (codigoRespuesta no es Integer) UUID:" + uuid);
			bitacoradao.addReg(registroBitacora);
			return respPersonalizada.getMensajeRespuesta();
		}
	}

		
				
	@Override
	public FacturaVTT consultar(String uuid) {
		if (uuid != null) {
			return facturaVTTDAO.consultar(uuid);
		}
		return null;
	}

	@Override
	public String corregirFactura(String uuid, String rfcEmisor, HttpSession sesion) {
		FacturaVTT factura = this.consultar(uuid);
		if (factura != null) {
			ObtieneCFDIResponse obtieneCFDIResponse = webServiceClient33.getObtieneCFDIResponse(uuid, rfcEmisor);
			List<Object> respuestaWS = obtieneCFDIResponse.getObtieneCFDIResult().getAnyType();
			int codigoRespuesta = -1;
			if (respuestaWS.get(6) instanceof Integer) {
				codigoRespuesta = (int) respuestaWS.get(6);

				if (codigoRespuesta == 0) {
					String xml = (String) respuestaWS.get(3);
					StringBuilder stringBuilder = new StringBuilder(xml);
					stringBuilder.insert(106, " xmlns=\"http://cancelacfd.sat.gob.mx\" ");
					String acuseXML2 = stringBuilder.toString();
					factura.setAcuseCancelacionXML(acuseXML2);
					Acuse acuse = Util.unmarshallAcuseXML(acuseXML2);

					if (acuse != null) {
						try {
							EncodeBase64 encodeBase64 = new EncodeBase64();
							String sello = new String(acuse.getSignature().getSignatureValue(), "ISO-8859-1");
							String selloBase64 = encodeBase64.encodeStringSelloCancelacion(sello);
							factura.setFechaCancelacion(acuse.getFecha().toGregorianCalendar().getTime());
							factura.setSelloCancelacion(selloBase64);
							factura.setEstatus(Estatus.CANCELADO);
							facturaVTTDAO.guardar(factura);
//							ReporteRenglon reporteRenglon = repRenglonDAO.consultar(uuid);
//							reporteRenglon.setStatus(Estatus.CANCELADO.toString());
//							repRenglonDAO.guardar(reporteRenglon);
							return "Factura " + uuid + " corregida";
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
							return e.getMessage();
						}
					} else {
						stringBuilder = new StringBuilder(xml);
						stringBuilder.insert(107, " xmlns=\"http://cancelacfd.sat.gob.mx\" ");
						acuseXML2 = stringBuilder.toString();
						factura.setAcuseCancelacionXML(acuseXML2);
						acuse = Util.unmarshallAcuseXML(acuseXML2);
						if (acuse != null) {
							try {
								EncodeBase64 encodeBase64 = new EncodeBase64();
								String sello = new String(acuse.getSignature().getSignatureValue(), "ISO-8859-1");
								String selloBase64 = encodeBase64.encodeStringSelloCancelacion(sello);
								factura.setFechaCancelacion(acuse.getFecha().toGregorianCalendar().getTime());
								factura.setSelloCancelacion(selloBase64);
								facturaVTTDAO.guardar(factura);
//								ReporteRenglon reporteRenglon = repRenglonDAO.consultar(uuid);
//								reporteRenglon.setStatus(Estatus.CANCELADO.toString());
//								repRenglonDAO.guardar(reporteRenglon);
								return "Factura " + uuid + " corregida";
							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
								return e.getMessage();
							}
						}
						RespuestaWebServicePersonalizada respPersonalizada = this.construirMensaje(respuestaWS);
//						RegistroBitacora registroBitacora = Util.crearRegistroBitacora(sesion, "Operacional",
//								respPersonalizada.getMensajeRespuesta() + " UUID:" + uuid);
//						bitacoradao.addReg(registroBitacora);
						return "Error al obtener el Acuse de Cancelación";

					}
				} else {
					RespuestaWebServicePersonalizada respPersonalizada = this.construirMensajeError(respuestaWS);
//					RegistroBitacora registroBitacora = Util.crearRegistroBitacora(sesion, "Operacional",
//							respPersonalizada.getMensajeRespuesta() + " UUID:" + uuid);
//					bitacoradao.addReg(registroBitacora);
					return respPersonalizada.getMensajeRespuesta();
				}

			} else {
				RespuestaWebServicePersonalizada respPersonalizada = this.construirMensajeError(respuestaWS);
//				RegistroBitacora registroBitacora = Util.crearRegistroBitacora(sesion, "Operacional",
//						respPersonalizada.getMensajeRespuesta() + " UUID:" + uuid);
//				bitacoradao.addReg(registroBitacora);
				return respPersonalizada.getMensajeRespuesta();
			}

		} else {
			return "La factura no existe";
		}

	}

	@Override
	public int obtenerNumeroPaginas(String rfcEmisor) {
//		return repRenglonDAO.pags(rfcEmisor);
		return 0;
	}

	@Override
	public PdfWriter obtenerPDF(FacturaVTT factura, OutputStream os)
			throws MalformedURLException, DocumentException, IOException {
		if (factura != null) {
			Comprobante cfdi = Util.unmarshallCFDI33XML(factura.getCfdiXML());
			Imagen imagen = imagenDAO.get("AAA010101AAA");

			PDFFacturaV33 pdfFactura;
			UsoDeCFDI usoCFDIHB = usoDeCFDIDAO.consultarPorId(cfdi.getReceptor().getUsoCFDI().getValor());
			RegimenFiscal regimenFiscal = regimenFiscalDAO
					.consultarPorId(cfdi.getEmisor().getRegimenFiscal().getValor());
			FormaDePago formaDePago = formaDePagoDAO.consultar(cfdi.getFormaPago().getValor());
			TipoDeComprobante tipoDeComprobante = tipoDeComprobanteDAO
					.consultar(cfdi.getTipoDeComprobante().getValor());
			if (usoCFDIHB != null && regimenFiscal != null && formaDePago != null) {
				pdfFactura = new PDFFacturaV33(usoCFDIHB.getDescripcion(), regimenFiscal.getDescripcion(),
						formaDePago.getDescripcion(), tipoDeComprobante.getDescripcion());
			} else {
				pdfFactura = new PDFFacturaV33("", "", "", "");
			}

			PdfWriter writer = PdfWriter.getInstance(pdfFactura.getDocument(), os);
			pdfFactura.getPieDePagina().setUuid(factura.getUuid());
			if (factura.getEstatus().equals(Estatus.CANCELADO)) {
				pdfFactura.getPieDePagina().setFechaCancel(factura.getFechaCancelacion());
				pdfFactura.getPieDePagina().setSelloCancel(factura.getSelloCancelacion());
			}
			writer.setPageEvent(pdfFactura.getPieDePagina());

			pdfFactura.getDocument().open();
			if (factura.getEstatus().equals(Estatus.TIMBRADO))
				pdfFactura.construirPdf(cfdi, factura.getSelloDigital(), factura.getCodigoQR(), imagen,
						factura.getEstatus(), factura.getComentarios(), factura.getProveedor());
			else if (factura.getEstatus().equals(Estatus.GENERADO)) {
				pdfFactura.construirPdf(cfdi, imagen, factura.getEstatus(), factura.getComentarios());

				PdfContentByte fondo = writer.getDirectContent();
				Font fuente = new Font(FontFamily.HELVETICA, 45);
				Phrase frase = new Phrase("Pre-factura", fuente);
				fondo.saveState();
				PdfGState gs1 = new PdfGState();
				gs1.setFillOpacity(0.5f);
				fondo.setGState(gs1);
				ColumnText.showTextAligned(fondo, Element.ALIGN_CENTER, frase, 297, 650, 45);
				fondo.restoreState();
			}

			else if (factura.getEstatus().equals(Estatus.CANCELADO)) {
				pdfFactura.construirPdfCancelado(cfdi, factura.getSelloDigital(), factura.getCodigoQR(), imagen,
						factura.getEstatus(), factura.getSelloCancelacion(), factura.getFechaCancelacion(),
						factura.getComentarios(), factura.getProveedor());

				pdfFactura.crearMarcaDeAgua("CANCELADO", writer);
			}
			pdfFactura.getDocument().close();
			return writer;
			// pdfFactura.getDocument().close();
		} else {
			return null;
		}
	}

	@Override
	public void enviarEmail(String email, String uuid, HttpSession sesion) {
		EmailSender mailero = null;
		FacturaVTT factura = facturaVTTDAO.consultar(uuid);
		Comprobante cfdi = Util.unmarshallCFDI33XML(factura.getCfdiXML());

		UsoDeCFDI usoCFDIHB = usoDeCFDIDAO.consultarPorId(cfdi.getReceptor().getUsoCFDI().getValor());
		RegimenFiscal regimenFiscal = regimenFiscalDAO.consultarPorId(cfdi.getEmisor().getRegimenFiscal().getValor());
		FormaDePago formaDePago = formaDePagoDAO.consultar(cfdi.getFormaPago().getValor());
		TipoDeComprobante tipoDeComprobante = tipoDeComprobanteDAO.consultar(cfdi.getTipoDeComprobante().getValor());
		if (usoCFDIHB != null && regimenFiscal != null && formaDePago != null && tipoDeComprobante != null) {
			mailero = new EmailSender(usoCFDIHB.getDescripcion(), regimenFiscal.getDescripcion(),
					formaDePago.getDescripcion(), tipoDeComprobante.getDescripcion());
		} else {
			mailero = new EmailSender("", "", "", "");
		}

		Imagen imagen = imagenDAO.get("AAA010101AAA");

		mailero.enviaFactura(email, factura, "", imagen, cfdi);
		String evento = "Se envió  la factura con id: " + factura.getUuid() + " al correo: " + email;
//		RegistroBitacora registroBitacora = Util.crearRegistroBitacora(sesion, "Operacional", evento);
//		bitacoradao.addReg(registroBitacora);
	}



	private void incrementarFolio(String rfc, String serie) {
//		if (rfc != null && serie != null) {
//			Serial serial = serialDAO.consultar(rfc, serie);
//			if (serial != null) {
//				serial.incrementa();
//				serialDAO.guardar(serial);
//			}
//		}
	}

	private void redondearCantidades(Comprobante comprobante) {
		List<Concepto> listaConceptos = comprobante.getConceptos().getConcepto();
		for (Concepto concepto : listaConceptos) {
			double valorUnitario = concepto.getValorUnitario().doubleValue();
			int cantidadDecimales = Util.obtenerDecimales(valorUnitario);
			if (cantidadDecimales > 6) {
				concepto.setValorUnitario(Util.redondearBigD(concepto.getValorUnitario(), 6));
			} else if (cantidadDecimales == 1) {
				concepto.setValorUnitario(Util.redondearBigD(concepto.getValorUnitario(), 2));
			} else {
				concepto.setValorUnitario(Util.redondearBigD(concepto.getValorUnitario(), cantidadDecimales));
			}

			// Agregar ceros después del punto decimal en los impuestos
			List<Traslado> listaTraslado = concepto.getImpuestos().getTraslados().getTraslado();
			for (Traslado traslado : listaTraslado) {
				traslado.setTasaOCuota(Util.redondearBigD(traslado.getTasaOCuota(), 6));
			}
		}
	}

	private void agregarCerosATasaOCuota(Impuestos impuestosGlobales) {
		List<com.tikal.cacao.sat.cfd33.Comprobante.Impuestos.Traslados.Traslado> listaT = impuestosGlobales
				.getTraslados().getTraslado();
		for (com.tikal.cacao.sat.cfd33.Comprobante.Impuestos.Traslados.Traslado traslado : listaT) {
			traslado.setTasaOCuota(Util.redondearBigD(traslado.getTasaOCuota(), 6));
		}
	}

	private RespuestaWebServicePersonalizada timbrar(Comprobante comprobante, String comentarios, String email) {
		this.redondearCantidades(comprobante);
		this.agregarCerosATasaOCuota(comprobante.getImpuestos());
		
//		Serial s = serialDAO.consultar(comprobante.getEmisor().getRfc(), comprobante.getSerie());
		comprobante.setSerie("FS");
		comprobante.setFolio( seriesdao.getSerieFactura()+ "");
		String xmlCFDI = Util.marshallComprobante33(comprobante, false);
		Proveedores p= proveedoresDAO.getProveedores();
		int rand= this.decision(p);
		if (rand!=2) {
			TimbraCFDIResponse timbraCFDIResponse = webServiceClient33.getTimbraCFDIResponse(xmlCFDI);
			List<Object> respuestaWB = timbraCFDIResponse.getTimbraCFDIResult().getAnyType();
			RespuestaWebServicePersonalizada respPersonalizada = null;
			int codigoRespuesta = -1;
			String textoCodigoRespuesta = null;
			if (respuestaWB.get(6) instanceof Integer) {
				codigoRespuesta = (int) respuestaWB.get(6);
	
				if (codigoRespuesta == 0) {
					String xmlCFDITimbrado = (String) respuestaWB.get(3);
					Comprobante cfdiTimbrado = Util.unmarshallCFDI33XML(xmlCFDITimbrado);
					this.incrementarFolio(cfdiTimbrado.getEmisor().getRfc(), cfdiTimbrado.getSerie());
					byte[] bytesQRCode = (byte[]) respuestaWB.get(4);
					String selloDigital = (String) respuestaWB.get(5);
	
					TimbreFiscalDigital timbreFD = null;
					List<Object> listaComplemento = cfdiTimbrado.getComplemento().get(0).getAny();
					for (Object objComplemento : listaComplemento) {
						if (objComplemento instanceof TimbreFiscalDigital) {
							timbreFD = (TimbreFiscalDigital) objComplemento;
							break;
						}
					}
	
					Date fechaCertificacion = Util.xmlGregorianAFecha(timbreFD.getFechaTimbrado());
					FacturaVTT facturaTimbrada = new FacturaVTT(timbreFD.getUUID(), xmlCFDITimbrado,
							cfdiTimbrado.getEmisor().getRfc(), cfdiTimbrado.getReceptor().getRfc(), fechaCertificacion,
							selloDigital, bytesQRCode);
					facturaTimbrada.setComentarios(comentarios);
					facturaVTTDAO.guardar(facturaTimbrada);
					//this.crearReporteRenglon(facturaTimbrada);
					this.crearReporteRenglon(facturaTimbrada, cfdiTimbrado.getMetodoPago(), cfdiTimbrado.getTipoDeComprobante().getValor(),null);
	
					EmailSender mailero = new EmailSender();
					Imagen imagen = imagenDAO.get("AAA010101AAA");
					if (email != null) {
						mailero.enviaFactura(email, facturaTimbrada, "", imagen, cfdiTimbrado);
					}
					respPersonalizada = new RespuestaWebServicePersonalizada();
					respPersonalizada.setMensajeRespuesta("¡La factura se timbró con éxito!");
					respPersonalizada.setUuidFactura(timbreFD.getUUID());
					return respPersonalizada;
				} // FIN TIMBRADO EXITOSO
	
				// CASO DE ERROR EN EL TIMBRADO
				else {
					return construirMensajeError(respuestaWB);
				}
			} else {
				textoCodigoRespuesta = (String) respuestaWB.get(1);
				return construirMensajeError(respuestaWB);
			}
		}else{
			
			AcuseRecepcionCFDI response= serviceFinkok.getStampResponse(xmlCFDI);
			
			if(response.getUUID()!=null){
			
				String xmlCFDITimbrado = response.getXml().getValue();
				Comprobante cfdiTimbrado = Util.unmarshallCFDI33XML(xmlCFDITimbrado);
				String selloDigital=response.getSatSeal().getValue();
				byte[] qr= Util.getQR(selloDigital, response.getUUID().getValue(), cfdiTimbrado.getEmisor().getRfc(), cfdiTimbrado.getReceptor().getRfc(), cfdiTimbrado.getTotal()+"");
				
				System.out.println(response.getUUID().getValue());
				this.incrementarFolio(cfdiTimbrado.getEmisor().getRfc(), cfdiTimbrado.getSerie());
				return this.procesaExitoso(cfdiTimbrado, qr, xmlCFDITimbrado, comentarios, selloDigital, email, "finkok");
			}
			else{
				return construirMensajeError(response);
			}
		}
	}

	private RespuestaWebServicePersonalizada construirMensajeError(List<Object> respuestaWB) {
		StringBuilder respuestaError = new StringBuilder("Excepción en caso de error: ");
		respuestaError.append(respuestaWB.get(0) + "\r\n");
		respuestaError.append("Código de error: " + respuestaWB.get(1) + "\r\n");
		respuestaError.append("Mensaje de respuesta: " + respuestaWB.get(2) + "\r\n");
		respuestaError.append(respuestaWB.get(6) + "\r\n");
		respuestaError.append(respuestaWB.get(7) + "\r\n");
		respuestaError.append(respuestaWB.get(8) + "\r\n");

		RespuestaWebServicePersonalizada respPersonalizada = new RespuestaWebServicePersonalizada();
		respPersonalizada.setMensajeRespuesta(respuestaError.toString());
		return respPersonalizada;
	}

	private RespuestaWebServicePersonalizada construirMensajeError(AcuseRecepcionCFDI respuestaWB) {
		Incidencia incidencia= respuestaWB.getIncidencias().getValue().getIncidencia().get(0);
		StringBuilder respuestaError = new StringBuilder("2 - Excepción en caso de error: ");
//		respuestaError.append(incidencia.get + "\r\n");
		respuestaError.append("Código de error: " + incidencia.getCodigoError().getValue() + "\r\n");
		respuestaError.append("Mensaje de respuesta: " + incidencia.getMensajeIncidencia().getValue() + "\r\n");
		respuestaError.append(incidencia.getExtraInfo().getValue() + "\r\n");
//		respuestaError.append(respuestaWB.get(7) + "\r\n");	
//		respuestaError.append(respuestaWB.get(8) + "\r\n");

		RespuestaWebServicePersonalizada respPersonalizada = new RespuestaWebServicePersonalizada();
		respPersonalizada.setMensajeRespuesta(respuestaError.toString());
		return respPersonalizada;
	}
	private RespuestaWebServicePersonalizada construirMensaje(List<Object> respuestaWS) {
		StringBuilder respuesta = new StringBuilder("Mensaje de respuesta: ");
		respuesta.append(respuestaWS.get(0) + "\r\n");
		respuesta.append("Código de error: " + respuestaWS.get(1) + "\r\n");
		respuesta.append("Mensaje de respuesta: " + respuestaWS.get(2) + "\r\n");
		respuesta.append("XML : " + respuestaWS.get(3) + "\r\n");
		respuesta.append("QRCode: " + respuestaWS.get(4) + "\r\n");
		respuesta.append("Sello: " + respuestaWS.get(5) + "\r\n");
		respuesta.append(respuestaWS.get(8) + "\r\n");

		RespuestaWebServicePersonalizada respPersonalizada = new RespuestaWebServicePersonalizada();
		respPersonalizada.setMensajeRespuesta(respuesta.toString());
		return respPersonalizada;
	}
	private String procesaCancelado(String acuseXML, FacturaVTT facturaACancelar, ReporteRenglon repRenglon, HttpSession sesion, Estatus estatus){
		String evento="";
		if(acuseXML!=null) {
			facturaACancelar.setAcuseCancelacionXML(acuseXML);
			Acuse acuse = Util.unmarshallAcuseXML(acuseXML);
	
			if (acuse != null) {
				try {
					EncodeBase64 encodeBase64 = new EncodeBase64();
					String sello = new String(acuse.getSignature().getSignatureValue(), "ISO-8859-1");
					String selloBase64 = encodeBase64.encodeStringSelloCancelacion(sello);
					facturaACancelar.setFechaCancelacion(acuse.getFecha().toGregorianCalendar().getTime());
					facturaACancelar.setSelloCancelacion(selloBase64);
					evento = "Se actualizó con acuse la factura guardada con el id:" + facturaACancelar.getUuid()+" Estatus: "+estatus;
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
					return "";
				}
			}
		}else {
			evento = "Se actualizó la factura guardada con el id:" + facturaACancelar.getUuid()+" Estatus: "+estatus;
		}
		facturaACancelar.setEstatus(estatus);
		repRenglon.setStatus(estatus.toString());
		facturaVTTDAO.guardar(facturaACancelar);
		repRenglonDAO.guardar(repRenglon);

		
		RegistroBitacora registroBitacora = Util.crearRegistroBitacora(sesion, "Operacional", evento);
		bitacoradao.addReg(registroBitacora);
		return evento;
	}

	private RespuestaWebServicePersonalizada construirMensajeError(CancelaCFDResult respuestaWB) {
		String codigo="";
		String mensaje="";
		if(respuestaWB.getFolios()!=null) {
		Folio f= respuestaWB.getFolios().getValue().getFolio().get(0);
			if(f.getEstatusUUID().getValue().compareTo("708")==0){
				codigo= "708";
				mensaje="Ocurrió un error en la cancelación, por favor contactar a soporte";
			}
		}else{
			codigo= "666";
			mensaje= respuestaWB.getCodEstatus().getValue();
		}
		
		StringBuilder respuestaError = new StringBuilder("Excepción en caso de error: ");
		respuestaError.append("Código de error: " + codigo + "\r\n");
		respuestaError.append("Mensaje de respuesta: " + mensaje + "\r\n");

		RespuestaWebServicePersonalizada respPersonalizada = new RespuestaWebServicePersonalizada();
		respPersonalizada.setMensajeRespuesta(respuestaError.toString());
		return respPersonalizada;
	}
	
	private int decision(Proveedores p){
		if(p.isActivo(0) && p.isActivo(1)){
			return ThreadLocalRandom.current().nextInt(0, 3);
		}
		if(p.isActivo(0)){
			return 0;
		}
		return 2;
	}
	
	private RespuestaWebServicePersonalizada procesaExitoso(Comprobante cfdiTimbrado, byte[] bytesQRCode, String xmlCFDITimbrado, String comentarios, String selloDigital, String email, String proveedor){
		RespuestaWebServicePersonalizada respPersonalizada = null;
		TimbreFiscalDigital timbreFD = null;
		List<Object> listaComplemento = cfdiTimbrado.getComplemento().get(0).getAny();
		for (Object objComplemento : listaComplemento) {
			if (objComplemento instanceof TimbreFiscalDigital) {
				timbreFD = (TimbreFiscalDigital) objComplemento;
				break;
			}
		}

		
		Date fechaCertificacion = Util.xmlGregorianAFecha(timbreFD.getFechaTimbrado(),true);
		FacturaVTT facturaTimbrada = new FacturaVTT(timbreFD.getUUID(), xmlCFDITimbrado,
				cfdiTimbrado.getEmisor().getRfc(), cfdiTimbrado.getReceptor().getRfc(), fechaCertificacion,
				selloDigital, bytesQRCode);
		facturaTimbrada.setProveedor(proveedor);
		facturaTimbrada.setComentarios(comentarios);
		facturaVTTDAO.guardar(facturaTimbrada);
//		this.crearReporteRenglon(facturaTimbrada, cfdiTimbrado.getNoCertificado());
		
		this.crearReporteRenglon(facturaTimbrada, cfdiTimbrado.getMetodoPago(), cfdiTimbrado.getTipoDeComprobante().getValor(),cfdiTimbrado.getNoCertificado());
		
		EmailSender mailero = new EmailSender();
		Imagen imagen = imagenDAO.get(cfdiTimbrado.getEmisor().getRfc());
		if (email != null) {
			try{
				mailero.enviaFactura(email, facturaTimbrada, "", imagen, cfdiTimbrado);
			}catch(Exception e){
				
			}
		}
		respPersonalizada = new RespuestaWebServicePersonalizada();
		respPersonalizada.setMensajeRespuesta("¡La factura se timbró con éxito!");
		respPersonalizada.setUuidFactura(timbreFD.getUUID());
		return respPersonalizada;
	}
	private void crearReporteRenglon(FacturaVTT factura, C_MetodoDePago metodoPago, String tipo,String noCertificadoSat){
		
		switch(tipo){
//		case "P":{
//			ComplementoRenglon reporterenglon= new ComplementoRenglon(factura);
//			reporterenglon.setNoCertificadoSat(noCertificadoSat);
//			complementoDAO.guardar(reporterenglon);
//			break;
//		}
		default:{
			ReporteRenglon reporteRenglon = new ReporteRenglon(factura);
			reporteRenglon.setNoCertificadoSat(noCertificadoSat);
			if(metodoPago.getValor().compareTo("PPD")==0){
				reporteRenglon.setTieneComplementoPago(true);
			}
			repRenglonDAO.guardar(reporteRenglon);
			break;
		}
		}
	
	}



}
