package com.tikal.cacao.factura.wsfinkok;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.poi.util.IOUtils;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.WebServiceIOException;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.ws.transport.WebServiceMessageSender;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;
import org.springframework.xml.transform.StringResult;
import org.springframework.xml.transform.StringSource;

import com.finkok.facturacion.cancel.CancelaCFDResult;
import com.finkok.facturacion.cancel.GetSATEstatus;
import com.finkok.facturacion.cancel.GetSatStatusResponse;
import com.finkok.facturacion.cancel.SignCancel;
import com.finkok.facturacion.cancel.SignCancelResponse;
import com.finkok.facturacion.cancellation.StringArray;
import com.finkok.facturacion.registration.Add;
import com.finkok.facturacion.registration.AddResponse;
import com.finkok.facturacion.stamp.ObjectFactory;
import com.finkok.facturacion.stamp.SignStamp;
import com.finkok.facturacion.stamp.SignStampResponse;
import com.tikal.cacao.util.Util;

import localhost.EncodeBase64;
import views.core.soap.services.apps.AcuseRecepcionCFDI;
import views.core.soap.services.apps.AcuseSATConsulta;
import views.core.soap.services.apps.UUIDS;

@Service
public class FinkokClient extends WebServiceGatewaySupport {

	private String password;
	private String user;
	private String uri;
	private String uriRegistration;
	private String uriCancela;
	private EncodeBase64 base64 = new EncodeBase64();
	private ObjectFactory of = new ObjectFactory();
	private com.finkok.facturacion.registration.ObjectFactory ofregistra = new com.finkok.facturacion.registration.ObjectFactory();
	private com.finkok.facturacion.cancel.ObjectFactory ofcancela = new com.finkok.facturacion.cancel.ObjectFactory();
	private com.finkok.facturacion.cancellation.ObjectFactory ofcancelacion = new com.finkok.facturacion.cancellation.ObjectFactory();
	private views.core.soap.services.apps.ObjectFactory ofc = new views.core.soap.services.apps.ObjectFactory();

	public AddResponse getRegistraEmisorResponse(String rfcEmisor, String pass, InputStream cer, InputStream ker) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Add.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			StringWriter sw = new StringWriter();
			System.out.println(sw.toString());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
			marshaller.setContextPaths("com.finkok.facturacion.registration");
			this.setMarshaller(marshaller);
			this.setUnmarshaller(marshaller);
			Add request = ofregistra.createAdd();
			request.setCer(ofregistra.createAddCer(IOUtils.toByteArray(cer)));
			request.setKey(ofregistra.createAddKey(IOUtils.toByteArray(ker)));
			request.setPassphrase(ofregistra.createAddPassphrase(pass));
			request.setResellerPassword(ofregistra.createEditResellerPassword(password));
			request.setResellerUsername(ofregistra.createAddResellerUsername(user));
			request.setTaxpayerId(ofregistra.createAddTaxpayerId(rfcEmisor));
			request.setTypeUser(ofregistra.createAddTypeUser("O"));

			JAXBElement<AddResponse> response = (JAXBElement<AddResponse>) getWebServiceTemplate()
					.marshalSendAndReceive(uriRegistration, request,
							new SoapActionCallback("http://facturacion.finkok.com/addResponse"));

			return response.getValue();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	private String getByteArrayBase64(InputStream inputStream) {
		return base64.encodeByteArrayIS(inputStream);
	}

	public FinkokClient() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPaths("com.finkok.facturacion.registration", "com.finkok.facturacion.stamp", "cancel",
				"views.core.soap.services.apps");
		this.setMarshaller(marshaller);
		this.setUnmarshaller(marshaller);
		if (Util.detectarAmbienteProductivo()) {
			uri = "https://facturacion.finkok.com/servicios/soap/stamp.wsdl";
			uriCancela = "https://facturacion.finkok.com/servicios/soap/cancel.wsdl";
			uriRegistration = "https://facturacion.finkok.com/servicios/soap/registration.wsdl";
			user = "no.reply.fcon@gmail.com";
			this.password = "finkokProd123.";
			this.getWebServiceTemplate().getMessageSenders()[0] = this.crearMessageSender();
		} else {
			uri = "https://demo-facturacion.finkok.com/servicios/soap/stamp.wsdl";
			uriRegistration = "https://demo-facturacion.finkok.com/servicios/soap/registration.wsdl";
			uriCancela = "https://demo-facturacion.finkok.com/servicios/soap/cancel.wsdl";
			user = "no.reply.fcon@gmail.com";
			this.password = "finkokTest12.";
			this.getWebServiceTemplate().setMessageSenders(this.configurarMessageSenders());
		}
	}

	public AcuseRecepcionCFDI getStampResponse(String xml) {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPaths("com.finkok.facturacion.stamp", "views.core.soap.services.apps");
		this.setMarshaller(marshaller);
		this.setUnmarshaller(marshaller);

		ObjectFactory factory = new ObjectFactory();
		SignStamp timbra = factory.createSignStamp();

		timbra.setPassword(factory.createStampedPassword(password));
		timbra.setUsername(factory.createStampedUsername(user));
		timbra.setXml(factory.createStampXml(xml.getBytes()));

		try {

			JAXBElement<SignStampResponse> response = (JAXBElement<SignStampResponse>) this.getWebServiceTemplate()
					.marshalSendAndReceive(uri, timbra,
							new SoapActionCallback("http://facturacion.finkok.com/stampResponse"));
			AcuseRecepcionCFDI acuse = response.getValue().getSignStampResult().getValue();
			return acuse;

		} catch (WebServiceIOException e) {
			System.out.println(e.getMessage());
			AcuseRecepcionCFDI responseError = null;
			return responseError;
		}

	}

	public CancelaCFDResult cancela(String uuid, String rfcEmisor, String serial) {
//		
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPaths("com.finkok.facturacion.cancel", "views.core.soap.services.apps");
		this.setMarshaller(marshaller);
		this.setUnmarshaller(marshaller);

		SignCancel c = new SignCancel();
		c.setPassword(ofcancela.createCancelPassword(this.password));
		c.setStorePending(ofcancela.createCancelStorePending(true));
		c.setTaxpayerId(ofcancela.createCancelTaxpayerId(rfcEmisor));
		c.setUsername(ofcancela.createCancelUsername(user));
		c.setSerial(ofcancela.createSignCancelSerial(serial));

		UUIDS ids = new UUIDS();

		StringArray sa = ofcancelacion.createStringArray();
		sa.getString().add(uuid.toLowerCase());
		ids.setUuids(this.ofc.createUUIDSUuids(sa));
		c.setUUIDS(ofcancela.createSignCancelUUIDS(ids));

		Jaxb2Marshaller jaxbMarshaller = (Jaxb2Marshaller) this.getMarshaller();
		StringResult sw = new StringResult();

		jaxbMarshaller.marshal(c, sw);

		String result = sw.toString();
		try {

			ByteArrayOutputStream bytArrayOutputStream = new ByteArrayOutputStream();
			StreamSource source = new StreamSource(new StringReader(result));
			StreamResult results = new StreamResult(bytArrayOutputStream);
			WebServiceTemplate wst = this.getWebServiceTemplate();
			wst.setDefaultUri(this.uriCancela);
			wst.sendSourceAndReceiveToResult(source, results);
			String olv = new String(bytArrayOutputStream.toByteArray());

			JAXBElement<SignCancelResponse> response = (JAXBElement<SignCancelResponse>) marshaller
					.unmarshal(new StringSource(olv));
//			SignCancelResponse response = (SignCancelResponse) marshaller.unmarshal(new StringSource(olv));

//			JAXBElement<SignCancelResponse> response = (JAXBElement<SignCancelResponse>) this.getWebServiceTemplate()
//					.marshalSendAndReceive(uriCancela, c, new SoapActionCallback("http://facturacion.finkok.com/sign_cancelResponse"));
//			System.out.println("a ver a ver");

//			JAXBContext jaxbContext = JAXBContext.newInstance(SignCancelResponse.class);
//			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//		
////			jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,	
////				"http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv33.xsd");
//		
//			Jaxb2Marshaller msh= (Jaxb2Marshaller) this.getMarshaller();
//			StringWriter sw = new StringWriter();
//			
//			msh.getJaxbContext().createMarshaller().marshal(c, sw);
//			jaxbMarshaller.marshal(response, sw);
			CancelaCFDResult cresult = response.getValue().getSignCancelResult().getValue();
//			CancelaCFDResult cresult=response.getSignCancelResult().getValue();
			if (cresult.getCodEstatus() != null) {
				String status = cresult.getCodEstatus().getValue();
				if (status.startsWith("Error:") && status.length() < 8) {
					cresult.getCodEstatus().setValue(cresult.getCodEstatus().getValue() + " " + result);
				}
			}
			return cresult;

		} catch (WebServiceIOException e) {
			System.out.println(e.getMessage());
			AcuseRecepcionCFDI responseError = null;
			return null;
		}
	}

	public AcuseSATConsulta getEstatus(String rfcEmisor, String rfcReceptor, String uuid, String total) {
		GetSATEstatus getSat = ofcancela.createGetSATEstatus();
		getSat.setUsername(ofcancela.createGetSATEstatusUsername(this.user));
		getSat.setPassword(ofcancela.createCancelPassword(this.password));
		getSat.setRtaxpayer_id(ofcancela.createGetSATEstatusRTaxpayerId(rfcReceptor));
		getSat.setTaxpayer_id(ofcancela.createGetSATEstatusTaxpayerId(rfcEmisor));
		getSat.setTotal(ofcancela.createTotal(total));
		getSat.setUuid(ofcancela.createUuid(uuid));

		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPaths("com.finkok.facturacion.cancel", "views.core.soap.services.apps");
		this.setMarshaller(marshaller);
		this.setUnmarshaller(marshaller);

		StringResult sw = new StringResult();
		marshaller.marshal(getSat, sw);
		String peticion = sw.toString();
		try {

			ByteArrayOutputStream bytArrayOutputStream = new ByteArrayOutputStream();
			StreamSource source = new StreamSource(new StringReader(peticion));
			StreamResult results = new StreamResult(bytArrayOutputStream);
			WebServiceTemplate wst = this.getWebServiceTemplate();
			wst.setDefaultUri(this.uriCancela);
			wst.sendSourceAndReceiveToResult(source, results);
			String olv = new String(bytArrayOutputStream.toByteArray());

			JAXBElement<GetSatStatusResponse> response = (JAXBElement<GetSatStatusResponse>) marshaller
					.unmarshal(new StringSource(olv));
			
			return response.getValue().getGetSatStatusResult().getValue().getSignStampResult().getValue();
			
		} catch (WebServiceIOException e) {
			System.out.println(e.getMessage());
			AcuseRecepcionCFDI responseError = null;
			return null;
		}
		
	}

	private HttpComponentsMessageSender crearMessageSender() {
		HttpComponentsMessageSender messageSender = new HttpComponentsMessageSender();
		messageSender.setConnectionTimeout(60000);
		messageSender.setReadTimeout(60000);
		// messageSender.
		return messageSender;
	}

	private WebServiceMessageSender[] configurarMessageSenders() {
		List<WebServiceMessageSender> messageSenders = new ArrayList<>();
		WebServiceMessageSender httpUrlConnectionMS = this.getWebServiceTemplate().getMessageSenders()[0];
		WebServiceMessageSender httpComponetsMS = this.crearMessageSender();
		messageSenders.add(httpUrlConnectionMS);
		messageSenders.add(httpComponetsMS);

		WebServiceMessageSender[] arregloMessageSenders;
		arregloMessageSenders = messageSenders.toArray(new WebServiceMessageSender[2]);
		return arregloMessageSenders;
	}

}
