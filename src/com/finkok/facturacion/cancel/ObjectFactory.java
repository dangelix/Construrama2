
package com.finkok.facturacion.cancel;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import views.core.soap.services.apps.AcuseSATConsulta;
import views.core.soap.services.apps.AcuseSatEstatus;
import views.core.soap.services.apps.FolioArray;
import views.core.soap.services.apps.UUIDS;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.finkok.facturacion.stamp package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SignCancel_QNAME = new QName("http://facturacion.finkok.com/cancel", "sign_cancel");
    private final static QName _SignCancelPassword_QNAME = new QName("http://facturacion.finkok.com/cancel", "password");
    private final static QName _SignCancelStorePending_QNAME = new QName("http://facturacion.finkok.com/cancel", "store_pending");
    private final static QName _SignCancelTaxpayerId_QNAME = new QName("http://facturacion.finkok.com/cancel", "taxpayer_id");
    private final static QName _SignCancelRTaxpayerId_QNAME = new QName("http://facturacion.finkok.com/cancel", "rtaxpayer_id");
    private final static QName _SignCancelUsername_QNAME = new QName("http://facturacion.finkok.com/cancel", "username");
    private final static QName _SignCancelSerial_QNAME = new QName("http://facturacion.finkok.com/cancel", "serial");
    private final static QName _SignCancelUUIDS_QNAME = new QName("http://facturacion.finkok.com/cancel", "UUIDS");
    private final static QName _SignCancelCFDResult_QNAME = new QName("http://facturacion.finkok.com/cancel", "sign_cancelResult");
    private final static QName _SignCancelAcuse_QNAME = new QName("http://facturacion.finkok.com/cancel", "Acuse");
    private final static QName _SignCancelFecha_QNAME = new QName("http://facturacion.finkok.com/cancel", "Fecha");
    private final static QName _SignCancelrfcEmisor_QNAME = new QName("http://facturacion.finkok.com/cancel", "rfcEmisor");
    private final static QName _SignCancelcodEstatus_QNAME = new QName("http://facturacion.finkok.com/cancel", "codEstatus");
    private final static QName _SignCancelFolios_QNAME = new QName("apps.services.soap.core.views", "Folios");
    private final static QName _total_QNAME = new QName("http://facturacion.finkok.com/cancel", "total");
    private final static QName _uuid_QNAME = new QName("http://facturacion.finkok.com/cancel", "uuid");
    private final static QName _acuseSatEstatus_QNAME = new QName("apps.services.soap.core.views", "acuseSatEstatus");
    private final static QName _acuseSatError_QNAME = new QName("apps.services.soap.core.views", "error");
    private final static QName _acuseSatSat_QNAME = new QName("apps.services.soap.core.views", "sat");
    private final static QName _acuseSatSingStamp_QNAME = new QName("apps.services.soap.core.views", "signStampResult");
    
    
//    apps.services.soap.core.views
    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.finkok.facturacion.stamp
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SignCancel }
     * 
     */
    public SignCancel createSignCancelLocal() {
        return new SignCancel();
    }

    public GetSATEstatus createGetSATEstatus() {
    	return new GetSATEstatus();
    }
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/cancel", name = "sign_cancel")
    public JAXBElement<SignCancel> createSignCancelLocal(SignCancel value) {
        return new JAXBElement<SignCancel>(_SignCancel_QNAME, SignCancel.class,null, value);
    }

    @XmlElementDecl(namespace = "http://facturacion.finkok.com/cancel", name = "password", scope= SignCancel.class)
    public JAXBElement<String> createCancelPassword(String value){
    	return new JAXBElement<String>(_SignCancelPassword_QNAME, String.class, SignCancel.class, value);
    }
    
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/cancel", name = "password", scope= GetSATEstatus.class)
    public JAXBElement<String> createGetSATEstatusPassword(String value){
    	return new JAXBElement<String>(_SignCancelPassword_QNAME, String.class, GetSATEstatus.class, value);
    }
    
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/cancel", name = "store_pending", scope= SignCancel.class)
    public JAXBElement<Boolean> createCancelStorePending(Boolean value){
    	return new JAXBElement<Boolean>(_SignCancelStorePending_QNAME, Boolean.class, SignCancel.class, value);
    }
    
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/cancel", name = "taxpayer_id", scope= SignCancel.class)
    public JAXBElement<String> createCancelTaxpayerId(String value){
    	return new JAXBElement<String>(_SignCancelTaxpayerId_QNAME, String.class, SignCancel.class, value);
    }
    
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/cancel", name = "taxpayer_id", scope= GetSATEstatus.class)
    public JAXBElement<String> createGetSATEstatusTaxpayerId(String value){
    	return new JAXBElement<String>(_SignCancelTaxpayerId_QNAME, String.class, GetSATEstatus.class, value);
    }
    
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/cancel", name = "rtaxpayer_id", scope= GetSATEstatus.class)
    public JAXBElement<String> createGetSATEstatusRTaxpayerId(String value){
    	return new JAXBElement<String>(_SignCancelRTaxpayerId_QNAME, String.class, GetSATEstatus.class, value);
    }
    
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/cancel", name = "total", scope= GetSATEstatus.class)
    public JAXBElement<String> createTotal(String value){
    	return new JAXBElement<String>(_total_QNAME, String.class, GetSATEstatus.class, value);
    }
    
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/cancel", name = "uuid", scope= GetSATEstatus.class)
    public JAXBElement<String> createUuid(String value){
    	return new JAXBElement<String>(_uuid_QNAME, String.class, GetSATEstatus.class, value);
    }
    
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/cancel", name = "username", scope= SignCancel.class)
    public JAXBElement<String> createCancelUsername(String value){
    	return new JAXBElement<String>(_SignCancelUsername_QNAME, String.class, SignCancel.class, value);
    }
    
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/cancel", name = "username", scope= GetSATEstatus.class)
    public JAXBElement<String> createGetSATEstatusUsername(String value){
    	return new JAXBElement<String>(_SignCancelUsername_QNAME, String.class, GetSATEstatus.class, value);
    }
    
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/cancel", name = "serial", scope= SignCancel.class)
    public JAXBElement<String> createSignCancelSerial(String value){
    	return new JAXBElement<String>(_SignCancelSerial_QNAME, String.class, SignCancel.class, value);
    }
    
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "UUIDS", scope= SignCancel.class)
    public JAXBElement<UUIDS> createSignCancelUUIDS(UUIDS value){
    	return new JAXBElement<UUIDS>(_SignCancelUUIDS_QNAME, UUIDS.class, SignCancel.class, value);
    }
    
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/cancel", name = "sign_cancelResponse")
    public JAXBElement<SignCancelResponse> createSignCancelResponse(SignCancelResponse value){
    	return new JAXBElement<SignCancelResponse>(_SignCancelUUIDS_QNAME, SignCancelResponse.class, null, value);
    }
    
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/cancel", name = "sign_cancelResult", scope= SignCancelResponse.class)
    public JAXBElement<CancelaCFDResult> createSignCancelResponseResult(CancelaCFDResult value){
    	return new JAXBElement<CancelaCFDResult>(_SignCancelUUIDS_QNAME, CancelaCFDResult.class, SignCancelResponse.class, value);
    }
    
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "Folios", scope= CancelaCFDResult.class)
    public JAXBElement<FolioArray> createSignCancelResponseResult(FolioArray value){
    	return new JAXBElement<FolioArray>(_SignCancelFolios_QNAME, FolioArray.class, CancelaCFDResult.class, value);
    }
    
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "Acuse", scope= CancelaCFDResult.class)
    public JAXBElement<String> createSignCancelResponseAcuse(String value){
    	return new JAXBElement<String>(_SignCancelAcuse_QNAME, String.class, CancelaCFDResult.class, value);
    }
    
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "Fecha", scope= CancelaCFDResult.class)
    public JAXBElement<String> createSignCancelResponseFecha(String value){
    	return new JAXBElement<String>(_SignCancelFecha_QNAME, String.class, CancelaCFDResult.class, value);
    }
    
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "RfcEmisor", scope= CancelaCFDResult.class)
    public JAXBElement<String> createSignCancelResponseRfcEmisor(String value){
    	return new JAXBElement<String>(_SignCancelrfcEmisor_QNAME, String.class, CancelaCFDResult.class, value);
    }
    
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "CodEstatus", scope= CancelaCFDResult.class)
    public JAXBElement<String> createSignCancelResponseCodEstatus(String value){
    	return new JAXBElement<String>(_SignCancelAcuse_QNAME, String.class, CancelaCFDResult.class, value);
    }
    
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/cancel", name = "get_sat_statusResponse")
    public JAXBElement<GetSatStatusResponse> createGetSatStatusResponse(GetSatStatusResponse value){
    	return new JAXBElement<GetSatStatusResponse>(_SignCancelUUIDS_QNAME, GetSatStatusResponse.class, null, value);
    }
    
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "acuseSatEstatus", scope= GetSatStatusResponse.class)
    public JAXBElement<AcuseSatEstatus> createGetSatStatusResponseAcuse(AcuseSatEstatus value){
    	return new JAXBElement<AcuseSatEstatus>(_acuseSatEstatus_QNAME, AcuseSatEstatus.class, GetSatStatusResponse.class, value);
    }
    
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "error", scope= AcuseSatEstatus.class)
    public JAXBElement<String> createAcuseSatEstatusError(String value){
    	return new JAXBElement<String>(_acuseSatError_QNAME, String.class, AcuseSatEstatus.class, value);
    }
    
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "sat", scope= AcuseSatEstatus.class)
    public JAXBElement<AcuseSATConsulta> createGetSatStatusResponseAcuseSat(AcuseSATConsulta value){
    	return new JAXBElement<AcuseSATConsulta>(_acuseSatSat_QNAME, AcuseSATConsulta.class, AcuseSatEstatus.class, value);
    }
    
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "signStampResult", scope= AcuseSatEstatus.class)
    public JAXBElement<AcuseSATConsulta> createGetSatStatusResponseAcuseSignStampResult(AcuseSATConsulta value){
    	return new JAXBElement<AcuseSATConsulta>(_acuseSatSingStamp_QNAME, AcuseSATConsulta.class, AcuseSatEstatus.class, value);
    }
}
