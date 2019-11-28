/**
 * 
 */
package com.tikal.cacao.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.stream.StreamSource;

import java.util.GregorianCalendar;

import com.google.appengine.api.utils.SystemProperty;
import com.google.gson.annotations.SerializedName;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;
import com.tikal.cacao.factura.FormatoFecha;
import com.tikal.cacao.model.RegistroBitacora;
import com.tikal.cacao.sat.cfd.Comprobante;
import com.tikal.cacao.sat.cfd.TUbicacion;
import com.tikal.cacao.sat.cfd.catalogos.C_Estado;
import com.tikal.cacao.sat.cfd33.Comprobante.Complemento;
import com.tikal.cacao.sat.timbrefiscaldigital.TimbreFiscalDigital;

import mx.gob.sat.cancelacfd.Acuse;

/**
 * @author Tikal
 *
 */
public class Util {

	/**
	 * Convierte la fecha en el formato "<tt>yyyy-MM-dd'T'HH:mm:ss.SSSZ</tt>" a su representaci&oacute;n en {@code java.util.Date}
	 * @param cadenaFecha fecha con formato "<tt>yyyy-MM-dd'T'HH:mm:ss.SSSZ</tt>"
	 * @return la fecha convertida en un objeto {@code java.util.Date} 
	 */
	public static Date obtenerFecha(String cadenaFecha) {
		DateFormat formato = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		//TODO suposición de que en App Engine esta línea causa error formato.setTimeZone(TimeZone.getTimeZone("America/Mexico_City"));
		Date fechaIngreso = new Date();
		try {
			fechaIngreso = formato.parse(cadenaFecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return fechaIngreso;
	}
	
	/**
	 * Convierte y regresa la cadena especificada en un objeto {@code java.util.Date} utilizando el formato
	 * especificado
	 * @param cadenaFecha la representaci&oacute;n en {@code String} de un objeto {@code java.util.Date}
	 * @param formato el formato que se utiliza para analizar gramaticalmente la cadena especificada
	 * @return la cadena especificada convertida en un objeto {@code java.util.Date}
	 */
	public static Date obtenerFecha(String cadenaFecha, DateFormat formato) {
		formato.setTimeZone(TimeZone.getTimeZone("America/Mexico_City"));
		Date fecha = null;
		cadenaFecha = cambiarNombreDelMes(cadenaFecha);
		try {
			fecha = formato.parse(cadenaFecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return fecha;
	}
	
	/**
	 * 
	 * @param fecha Fecha a la que se le dará el formato
	 * @return una representaci&oacute;n del la fecha en objeto String
	 */
	public static String regresaFechaConFormato(Date fecha) {
		String cadenaFecha = null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		cadenaFecha = df.format(fecha);
		return cadenaFecha;
	}
	
	public static String cambiarNombreDelMes(String strFecha) {
		String mes = strFecha.substring(0, 3);
		switch (mes) {
		case "Jan":
			strFecha = strFecha.replace(mes, "Ene");
			break;
		case "Apr":
			strFecha = strFecha.replace(mes, "Abr");
			break;
		case "Aug":
			strFecha = strFecha.replace(mes, "Ago");
			break;
		case "Dec":
			strFecha = strFecha.replace(mes, "Dic");
			break;
		}
	    return strFecha;
	}
	
	
	/**
	 * Este m&eacute;todo regresa la cantidad de d&iacute;as entre la fecha
	 * especificada y la fecha actual
	 * @param fecha 
	 * @return la cantidad de d&iacute;as entre la fecha indicada y la fecha actual
	 */
	// agregar parametro 'int i' para efect
	public static int obtenerDiasEntre(Date fecha) { //, int i) 
	
		Calendar presente = Calendar.getInstance();
//		if (i >= 2) {
//			presente = new GregorianCalendar();
//			//presente.setTimeInMillis(1_492_268_400_000L); // 15-abril-2017
//			presente.setTimeInMillis(1_493_564_400_000L);
//		} else {
//			presente = Calendar.getInstance();
//		}
		//Calendar presente = new GregorianCalendar(2017, 4, 15);
	    
		Calendar pasado = Calendar.getInstance();
	    pasado.setTime(fecha);

	    int dias = 0;

	    while (pasado.before(presente)) {
	        pasado.add(Calendar.DATE, 1);
	        if (pasado.before(presente)) {
	            dias++;
	        }
	    } return dias;
	}
	
	public static int obtenerDiasEntre(Date fechaIn, Date fechaFin) {
		Calendar cFechaFin = Calendar.getInstance();
		Calendar cFechaIn = Calendar.getInstance();
	    cFechaIn.setTime(fechaIn);
	    cFechaFin.setTime(fechaFin);

	    int dias = 0;

	    while (cFechaIn.before(cFechaFin)) {
	        cFechaIn.add(Calendar.DATE, 1);
	        if (cFechaIn.before(cFechaFin)) {
	            dias++;
	        }
	    } return dias;
	}
	
	public static int obtenerMesesEntre(Date fechaIn, Date fechaFin) {
		Calendar cFechaFin = Calendar.getInstance();
		Calendar cFechaIn = Calendar.getInstance();
	    cFechaIn.setTime(fechaIn);
	    cFechaFin.setTime(fechaFin);
	    
	    int meses = 0;
	    while (cFechaIn.before(cFechaFin)) {
	    	cFechaIn.add(Calendar.MONTH, 1);
	    	if (cFechaIn.before(cFechaFin)) {
	    		meses++;
	    	}
	    }
		return meses;
	}
	
	
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();
	
	public static String randomString( int len ){
		   StringBuilder sb = new StringBuilder( len );
		   for( int i = 0; i < len; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		   return sb.toString();
		}
	
	public static BigDecimal redondearBigD(double cantidad) {
		BigDecimal bigD = BigDecimal.valueOf(cantidad).setScale(2, RoundingMode.HALF_UP);
		return bigD;
	}
	
	public static BigDecimal redondearBigD(BigDecimal bigDecimal, int decimales) {
		return bigDecimal.setScale(decimales, RoundingMode.HALF_UP);
	}
	
	public static String formatearCantidad(double valor, int decimales) {
		//StringBuilder valorConFormato = new StringBuilder(String.valueOf(valor));
		DecimalFormat decimalFormatter = null;
		//String[] valoresALaIzqDelPuntoDecimal = {"#,###.00", "#,###.000", "#,###.0000", "#,###.00000", "#,###.000000"}; 
		int decimalesALaIzqDelPuntoDecimal = Util.obtenerDecimales(valor);
		switch (decimalesALaIzqDelPuntoDecimal) {
			case 0:
			case 1:
			case 2:
				decimalFormatter = new DecimalFormat("#,###.00");
				break;
			case 3:
				decimalFormatter = new DecimalFormat("#,###.000");
				break;
			case 4:
				decimalFormatter = new DecimalFormat("#,###.0000");
				break;
			case 5:
				decimalFormatter = new DecimalFormat("#,###.00000");
				break;
			case 6:
				decimalFormatter = new DecimalFormat("#,###.000000");
				break;
			default:
				decimalFormatter = new DecimalFormat("#,###.000000");
		}
		
		String valorConFormato = decimalFormatter.format(valor);
		StringBuilder strBuilder = new StringBuilder(valorConFormato);
		strBuilder.insert(0, "$");
		return strBuilder.toString();
	}
	
	public static int obtenerDecimales(double valor) {
		String strValor = String.valueOf(valor);
		String[] split = strValor.split("\\.");
		String strDecimales = split[1];
		return strDecimales.length();
	}
	
	public static String quitarCarateresNoNumericos(String cadenaNumero) {
		if(cadenaNumero.contains("$")){
			cadenaNumero=cadenaNumero.replaceAll("[$]", "");
			cadenaNumero=cadenaNumero.replaceAll(",", "");
			cadenaNumero=cadenaNumero.replaceAll("\"", "");
			cadenaNumero=cadenaNumero.trim();
		}
		return cadenaNumero;
	}
	
	/**
	 * &Eacute;ste m&eacute;todo regresa el n&uacute;mero decimal especificado con un redondeo a 
	 * dos valores a la derecha del punto decimal.
	 * @param cantidad la cantidad a redonear
	 * @return la cantidad con solo dos valores a la derecha del punto decimal
	 */
	public static double redondear(double cantidad) {
		return redondearBigD(cantidad).doubleValue();
	}
	
	public static double truncar(double cantidad) {
		BigDecimal bigD = BigDecimal.valueOf(cantidad).setScale(0, RoundingMode.DOWN);
		return bigD.doubleValue();
	}
	
	/**
	 * &Eacute;ste m&eacute;todo crea un objeto {@link RegistroBitacora } con el <em>tipo</em> y <em>evento</em> 
	 * especificados. El par&aacute;metro <em>sesion</em> debe tener un atributo que indique el 
	 * nombre del usuario de la sesi&oacute;n.
	 * @param sesion la sesi&oacute;n que se utiliza para obtener el nombre del usuario que realizo el evento
	 * @param tipo inidica si el objeto {@code RegistroBitacora} es de tipo Operacional o Administrativo
	 * @param evento texto que especifica el evento que se desea registrar
	 * @return un objeto {@code RegistroBitacora} listo para persistirse
	 */
	
	public static Date regresarFecha(int dia){
        int fechin = dia;
        String nueva = "";
        Date fechaPago = null;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date now = new Date();
        String fecha = df.format(now).toString();
        String febrero = fecha.substring(3,5);
        if(fechin > 28 && febrero.equals("02")){
            nueva = fecha.replace(fecha.substring(0,2),Integer.toString(28));
        }else {
            nueva = fecha.replace(fecha.substring(0, 2), Integer.toString(fechin));
        }
        try {
            fechaPago = df.parse(nueva);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return fechaPago;
    }
	
	
	/**
	 * &Eacute;ste m&eacute;todo regresa un objeto {@code Date} representando
	 * el momento actual del mes que resulte de restar a &eacute;ste, el n&uacute;mero de meses
	 * especificado.
	 * @param meses n&uacute;mero de meses que se restar&aacute;n de la fecha actual
	 * @return un objeto {@code Date} que resulte de restar al momento actual el n&uacute;mero de meses
	 */
	public static Date obtenerFechaMesesAntes(int meses) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -meses);
		return calendar.getTime();
	}
	
	
	public static XMLGregorianCalendar getXMLDate(Date date, FormatoFecha formato) {
		GregorianCalendar c = new GregorianCalendar( TimeZone.getTimeZone("America/Mexico_City") );
    	Date dateMexico = c.getTime();
    	System.out.println(dateMexico);
    	if (!date.after(dateMexico)) {
    		c.setTime(date);
    	}
    	XMLGregorianCalendar date2 = null;
    	try {
	    	switch (formato) {
			case COMPROBANTE:
				date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(
						c.get(Calendar.YEAR), c.get(Calendar.MONTH)+1, c.get(Calendar.DAY_OF_MONTH),
						c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), c.get(Calendar.SECOND),
						DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED);
				break;
			case NOMINA:
				c.setTime(date);
				date2 = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(
						c.get(Calendar.YEAR), c.get(Calendar.MONTH)+1, c.get(Calendar.DAY_OF_MONTH), DatatypeConstants.FIELD_UNDEFINED);
				break;
			default:
				break;
			}
    	} catch (DatatypeConfigurationException exception) {
    		return date2;
    	}
    	 
    	return date2;
    }

	public static C_Estado convertir(String estado) {
		switch (estado) {
		case "":
			break;
		}
		return null;
	}
	
	public static com.tikal.cacao.sat.cfd33.Comprobante unmarshallCFDI33XML(String cadenaXML) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(com.tikal.cacao.sat.cfd33.Comprobante.class, mx.gob.sat.timbrefiscaldigital.TimbreFiscalDigital.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			StringBuffer xmlStr = new StringBuffer(cadenaXML);
			com.tikal.cacao.sat.cfd33.Comprobante comprobante = 
					(com.tikal.cacao.sat.cfd33.Comprobante) unmarshaller.unmarshal(new StreamSource( new StringReader(xmlStr.toString() ) ) );
			return comprobante;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Comprobante unmarshallXML(String cadenaXML) {
		try {
			//TODO en el caso de nomina agregar al método newInstance la clase NominaElement.class
			JAXBContext jaxbContext = JAXBContext.newInstance(Comprobante.class, TimbreFiscalDigital.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			StringBuffer xmlStr = new StringBuffer(cadenaXML);
			Comprobante comprobante = (Comprobante) unmarshaller.unmarshal(new StreamSource( new StringReader(xmlStr.toString() ) ) );
			return comprobante;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Convierte una cadena xml que representa el acuse de cancelaci&oacute;n a un objeto {@code Acuse}
	 * @param acuseXML cadena xml del acuse de cancelaci&oacute;n
	 * @return el acuse de cancelaci&oacute;n
	 */
	public static Acuse unmarshallAcuseXML(String acuseXML) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Acuse.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			StringBuffer xmlStr = new StringBuffer(acuseXML);
			Acuse acuse = (Acuse) unmarshaller.unmarshal(new StreamSource( new StringReader( xmlStr.toString() ) ) );
			return acuse;
		} catch (JAXBException e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}
	
	public static String marshallComprobante(com.tikal.cacao.sat.cfd.Comprobante c, boolean esNomina) {
		try {
			JAXBContext jaxbContext;
			Marshaller jaxbMarshaller;
			if (esNomina) {
				jaxbContext = JAXBContext.newInstance(com.tikal.cacao.sat.cfd.Comprobante.class);
				jaxbMarshaller = jaxbContext.createMarshaller();
				jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,
						"http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv32.xsd " 
						+ "http://www.sat.gob.mx/nomina12 http://www.sat.gob.mx/sitio_internet/cfd/nomina/nomina12.xsd");
			} else {
				jaxbContext = JAXBContext.newInstance(com.tikal.cacao.sat.cfd.Comprobante.class);
				jaxbMarshaller = jaxbContext.createMarshaller();
				jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,	
						"http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv32.xsd ");
			}
			jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			StringWriter sw = new StringWriter();
			jaxbMarshaller.marshal(c, sw);
			return sw.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String marshallComprobante33(com.tikal.cacao.sat.cfd33.Comprobante c) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(com.tikal.cacao.sat.cfd33.Comprobante.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		
			jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,	
				"http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv33.xsd");
		
			StringWriter sw = new StringWriter();
			jaxbMarshaller.marshal(c, sw);
			return sw.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String marshallComprobante33(com.tikal.cacao.sat.cfd33.Comprobante c, boolean esNomina) {
		try {
			JAXBContext jaxbContext;
			Marshaller jaxbMarshaller;
			if (esNomina) {
				jaxbContext = JAXBContext.newInstance(com.tikal.cacao.sat.cfd33.Comprobante.class);
				jaxbMarshaller = jaxbContext.createMarshaller();
				jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,	
						"http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv33.xsd " +
								"http://www.sat.gob.mx/nomina12 http://www.sat.gob.mx/sitio_internet/cfd/nomina/nomina12.xsd");
			} else {
				jaxbContext = JAXBContext.newInstance(com.tikal.cacao.sat.cfd33.Comprobante.class);
				jaxbMarshaller = jaxbContext.createMarshaller();
				jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,	
						"http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv33.xsd");
			}
		
			jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			StringWriter sw = new StringWriter();
			jaxbMarshaller.marshal(c, sw);
			return sw.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String regresaTextoOCadenaVacia(String texto) {
		if (texto == null) {
			texto = "";
		}	
		return texto;
	}
	

	public static void validarDomicilioReceptor(TUbicacion domicilio) {
		if (domicilio.getCalle() != null)
			if (domicilio.getCalle().equals(""))
				domicilio.setCalle(null);
		
		if (domicilio.getNoExterior() != null)
			if (domicilio.getNoExterior().equals(""))
				domicilio.setNoExterior(null);
		
		if (domicilio.getNoInterior() != null)
			if (domicilio.getNoInterior().equals(""))
				domicilio.setNoInterior(null);
		
		if (domicilio.getColonia() != null)
			if (domicilio.getColonia().equals(""))
				domicilio.setColonia(null);
		
		if (domicilio.getLocalidad() != null)
			if (domicilio.getLocalidad().equals(""))
				domicilio.setLocalidad(null);
		
		if (domicilio.getReferencia() != null)
			if (domicilio.getReferencia().equals(""))
				domicilio.setReferencia(null);
		
		if (domicilio.getMunicipio() != null)
			if (domicilio.getMunicipio().equals(""))
				domicilio.setMunicipio(null);
		
		if (domicilio.getEstado() != null)
			if (domicilio.getEstado().equals(""))
				domicilio.setEstado(null);
		
		if (domicilio.getCodigoPostal() != null)
			if (domicilio.getCodigoPostal().equals(""))
				domicilio.setCodigoPostal(null);

	}
	
	public static Date xmlGregorianAFecha(XMLGregorianCalendar calendar) {
		if (calendar == null) {
			return null;
		}
		GregorianCalendar gCalendar = calendar.toGregorianCalendar();
		gCalendar.setTimeZone(TimeZone.getTimeZone("America/Mexico_City"));
		int horaDelDia = gCalendar.get(Calendar.HOUR_OF_DAY) - 1;
		if (horaDelDia < 0) { // CASO DE LA MEDIA NOCHE, DESPUÉS DE LAS 00:00:00 HORAS
			gCalendar.set(Calendar.HOUR_OF_DAY,  23);
			
			int diaDelMes = gCalendar.get(Calendar.DAY_OF_MONTH) - 1 ;
			if (diaDelMes <= 0) {
				gCalendar.set(Calendar.DAY_OF_MONTH, 1);
				
				int mes = gCalendar.get(Calendar.MONTH) +1;
				if (mes < 0) {
					mes = 1;
				}
				gCalendar.set(Calendar.MONTH, mes);
				
			} else {
				gCalendar.set(Calendar.DAY_OF_MONTH, diaDelMes);
			}
			
			
		} else {
			gCalendar.set(Calendar.HOUR_OF_DAY,  horaDelDia);
		}
		
		return gCalendar.getTime();
	}
	
	public static boolean detectarAmbienteProductivo() {
		if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
			// Production   
			return true;
		} else {
		  // Local development server
		  // which is: SystemProperty.Environment.Value.Development
			 return false;
		}
	}
	
	public static String getSerializedName(Enum<?> e) {
	    try {
	        Field f = e.getClass().getField(e.name());
	        SerializedName a = f.getAnnotation(SerializedName.class);
	        return a == null ? null : a.value();
	    } catch (NoSuchFieldException ignored) {
	        return null;
	    }
	}
	public static byte[] generate(String code) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			String aux= code.replace(":", "%3A");
			aux=aux.replace("/", "%2F");
			aux= aux.replace("?", "%3F");
			aux= aux.replace("&", "%26");
			aux= aux.replace("=", "%3D");
			String url= "https://chart.googleapis.com/chart?chs=500x500&cht=qr&chl="+aux+"%2F&choe=UTF-8";
			Image imgLogo;
	//		if (imagen != null) {
			
			imgLogo = Image.getInstance(new URL(url));
//			imgLogo.setScaleToFitHeight(false);
//			imgLogo.scaleToFit(125F, 37.25F);
			
			byte[] bytes= imgLogo.getRawData();
			bytes= url.getBytes();
//			BarcodeQRCode barcodeQRCode = new BarcodeQRCode(url, 1000, 1000, null);
//			Image codeQrImage = barcodeQRCode.getImage();
//			return codeQrImage.getRawData();
			return bytes;
			} catch (BadElementException e) {
				e.printStackTrace();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
//		} // else {
		return null;
	}
	
	public static RegistroBitacora crearRegistroBitacora(HttpSession sesion, String tipo, String evento) {
		RegistroBitacora registroBitacora = new RegistroBitacora();
		registroBitacora.setUsuario((String) sesion.getAttribute("userName"));
		registroBitacora.setTipo(tipo);
		registroBitacora.setEvento(evento);
		registroBitacora.setFecha(new Date());
		return registroBitacora;
	}
	
	public static byte[] getQR(String sello, String uuid, String rfcEmisor, String rfcReceptor, String total) {
		String uri = "https://verificacfdi.facturaelectronica.sat.gob.mx/default.aspx&id=" + uuid;
		uri += "&re=" + rfcEmisor;
		uri += "&rr=" + rfcReceptor;
		uri += "&tt=" + total;
		String last5 = sello.substring(sello.length() - 5);
		uri += "&fe=" + last5;
//		return uri.getBytes();
		return Util.generate(uri);
	}
	
	public static Date xmlGregorianAFecha(XMLGregorianCalendar calendar, boolean off) {
		if (calendar == null) {
			return null;
		}
		GregorianCalendar gCalendar = calendar.toGregorianCalendar();
		gCalendar.setTimeZone(TimeZone.getTimeZone("America/Mexico_City"));
		if (off) {

			gCalendar.add(GregorianCalendar.HOUR_OF_DAY, -6);

			// int horaDelDia = gCalendar.get(Calendar.HOUR_OF_DAY) - 1;
			// if (horaDelDia < 0) { // CASO DE LA MEDIA NOCHE, DESPUï¿½S DE LAS
			// 00:00:00 HORAS
			// gCalendar.set(Calendar.HOUR_OF_DAY, 23);
			//
			// int diaDelMes = gCalendar.get(Calendar.DAY_OF_MONTH) - 1 ;
			// if (diaDelMes <= 0) {
			// gCalendar.set(Calendar.DAY_OF_MONTH, 1);
			//
			// int mes = gCalendar.get(Calendar.MONTH) +1;
			// if (mes < 0) {
			// mes = 1;
			// }
			// gCalendar.set(Calendar.MONTH, mes);
			//
			// } else {
			// gCalendar.set(Calendar.DAY_OF_MONTH, diaDelMes);
			// }
			//
			// } else {
			// gCalendar.set(Calendar.HOUR_OF_DAY, horaDelDia);
			// }
		}
		// GregorianCalendar c = new GregorianCalendar(
		// TimeZone.getTimeZone("America/Mexico_City") );
		// Date dateMexico = c.getTime();
		// System.out.println(dateMexico);
		return gCalendar.getTime();

	}
}
