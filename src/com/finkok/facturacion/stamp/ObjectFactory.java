
package com.finkok.facturacion.stamp;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import views.core.soap.services.apps.AcuseRecepcionCFDI;
import views.core.soap.services.apps.PDFResult;
import views.core.soap.services.apps.QueryPendingResult;


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

    private final static QName _Stamped_QNAME = new QName("http://facturacion.finkok.com/stamp", "stamped");
    private final static QName _SignStamp_QNAME = new QName("http://facturacion.finkok.com/stamp", "sign_stamp");
    private final static QName _StampedResponse_QNAME = new QName("http://facturacion.finkok.com/stamp", "stampedResponse");
    private final static QName _QuickStampResponse_QNAME = new QName("http://facturacion.finkok.com/stamp", "quick_stampResponse");
    private final static QName _QueryPendingResponse_QNAME = new QName("http://facturacion.finkok.com/stamp", "query_pendingResponse");
    private final static QName _GetPdf_QNAME = new QName("http://facturacion.finkok.com/stamp", "get_pdf");
    private final static QName _SignStampResponse_QNAME = new QName("http://facturacion.finkok.com/stamp", "sign_stampResponse");
    private final static QName _Stamp_QNAME = new QName("http://facturacion.finkok.com/stamp", "stamp");
    private final static QName _StampResponse_QNAME = new QName("http://facturacion.finkok.com/stamp", "stampResponse");
    private final static QName _QuickStamp_QNAME = new QName("http://facturacion.finkok.com/stamp", "quick_stamp");
    private final static QName _QueryPending_QNAME = new QName("http://facturacion.finkok.com/stamp", "query_pending");
    private final static QName _GetPdfResponse_QNAME = new QName("http://facturacion.finkok.com/stamp", "get_pdfResponse");
    private final static QName _GetPdfResponseGetPdfResult_QNAME = new QName("http://facturacion.finkok.com/stamp", "get_pdfResult");
    private final static QName _QueryPendingUsername_QNAME = new QName("http://facturacion.finkok.com/stamp", "username");
    private final static QName _QueryPendingPassword_QNAME = new QName("http://facturacion.finkok.com/stamp", "password");
    private final static QName _QueryPendingUuid_QNAME = new QName("http://facturacion.finkok.com/stamp", "uuid");
    private final static QName _QuickStampXml_QNAME = new QName("http://facturacion.finkok.com/stamp", "xml");
    private final static QName _StampResponseStampResult_QNAME = new QName("http://facturacion.finkok.com/stamp", "stampResult");
    private final static QName _SignStampResponseSignStampResult_QNAME = new QName("http://facturacion.finkok.com/stamp", "sign_stampResult");
    private final static QName _QueryPendingResponseQueryPendingResult_QNAME = new QName("http://facturacion.finkok.com/stamp", "query_pendingResult");
    private final static QName _QuickStampResponseQuickStampResult_QNAME = new QName("http://facturacion.finkok.com/stamp", "quick_stampResult");
    private final static QName _StampedResponseStampedResult_QNAME = new QName("http://facturacion.finkok.com/stamp", "stampedResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.finkok.facturacion.stamp
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Stamped }
     * 
     */
    public Stamped createStamped() {
        return new Stamped();
    }

    /**
     * Create an instance of {@link SignStamp }
     * 
     */
    public SignStamp createSignStamp() {
        return new SignStamp();
    }

    /**
     * Create an instance of {@link StampedResponse }
     * 
     */
    public StampedResponse createStampedResponse() {
        return new StampedResponse();
    }

    /**
     * Create an instance of {@link QuickStampResponse }
     * 
     */
    public QuickStampResponse createQuickStampResponse() {
        return new QuickStampResponse();
    }

    /**
     * Create an instance of {@link QueryPendingResponse }
     * 
     */
    public QueryPendingResponse createQueryPendingResponse() {
        return new QueryPendingResponse();
    }

    /**
     * Create an instance of {@link GetPdf }
     * 
     */
    public GetPdf createGetPdf() {
        return new GetPdf();
    }

    /**
     * Create an instance of {@link SignStampResponse }
     * 
     */
    public SignStampResponse createSignStampResponse() {
        return new SignStampResponse();
    }

    /**
     * Create an instance of {@link Stamp }
     * 
     */
    public Stamp createStamp() {
        return new Stamp();
    }

    /**
     * Create an instance of {@link StampResponse }
     * 
     */
    public StampResponse createStampResponse() {
        return new StampResponse();
    }

    /**
     * Create an instance of {@link QuickStamp }
     * 
     */
    public QuickStamp createQuickStamp() {
        return new QuickStamp();
    }

    /**
     * Create an instance of {@link QueryPending }
     * 
     */
    public QueryPending createQueryPending() {
        return new QueryPending();
    }

    /**
     * Create an instance of {@link GetPdfResponse }
     * 
     */
    public GetPdfResponse createGetPdfResponse() {
        return new GetPdfResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Stamped }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "stamped")
    public JAXBElement<Stamped> createStamped(Stamped value) {
        return new JAXBElement<Stamped>(_Stamped_QNAME, Stamped.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignStamp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "sign_stamp")
    public JAXBElement<SignStamp> createSignStamp(SignStamp value) {
        return new JAXBElement<SignStamp>(_SignStamp_QNAME, SignStamp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StampedResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "stampedResponse")
    public JAXBElement<StampedResponse> createStampedResponse(StampedResponse value) {
        return new JAXBElement<StampedResponse>(_StampedResponse_QNAME, StampedResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuickStampResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "quick_stampResponse")
    public JAXBElement<QuickStampResponse> createQuickStampResponse(QuickStampResponse value) {
        return new JAXBElement<QuickStampResponse>(_QuickStampResponse_QNAME, QuickStampResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryPendingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "query_pendingResponse")
    public JAXBElement<QueryPendingResponse> createQueryPendingResponse(QueryPendingResponse value) {
        return new JAXBElement<QueryPendingResponse>(_QueryPendingResponse_QNAME, QueryPendingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPdf }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "get_pdf")
    public JAXBElement<GetPdf> createGetPdf(GetPdf value) {
        return new JAXBElement<GetPdf>(_GetPdf_QNAME, GetPdf.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignStampResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "sign_stampResponse")
    public JAXBElement<SignStampResponse> createSignStampResponse(SignStampResponse value) {
        return new JAXBElement<SignStampResponse>(_SignStampResponse_QNAME, SignStampResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Stamp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "stamp")
    public JAXBElement<Stamp> createStamp(Stamp value) {
        return new JAXBElement<Stamp>(_Stamp_QNAME, Stamp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StampResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "stampResponse")
    public JAXBElement<StampResponse> createStampResponse(StampResponse value) {
        return new JAXBElement<StampResponse>(_StampResponse_QNAME, StampResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuickStamp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "quick_stamp")
    public JAXBElement<QuickStamp> createQuickStamp(QuickStamp value) {
        return new JAXBElement<QuickStamp>(_QuickStamp_QNAME, QuickStamp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryPending }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "query_pending")
    public JAXBElement<QueryPending> createQueryPending(QueryPending value) {
        return new JAXBElement<QueryPending>(_QueryPending_QNAME, QueryPending.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPdfResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "get_pdfResponse")
    public JAXBElement<GetPdfResponse> createGetPdfResponse(GetPdfResponse value) {
        return new JAXBElement<GetPdfResponse>(_GetPdfResponse_QNAME, GetPdfResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PDFResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "get_pdfResult", scope = GetPdfResponse.class)
    public JAXBElement<PDFResult> createGetPdfResponseGetPdfResult(PDFResult value) {
        return new JAXBElement<PDFResult>(_GetPdfResponseGetPdfResult_QNAME, PDFResult.class, GetPdfResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "username", scope = QueryPending.class)
    public JAXBElement<String> createQueryPendingUsername(String value) {
        return new JAXBElement<String>(_QueryPendingUsername_QNAME, String.class, QueryPending.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "password", scope = QueryPending.class)
    public JAXBElement<String> createQueryPendingPassword(String value) {
        return new JAXBElement<String>(_QueryPendingPassword_QNAME, String.class, QueryPending.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "uuid", scope = QueryPending.class)
    public JAXBElement<String> createQueryPendingUuid(String value) {
        return new JAXBElement<String>(_QueryPendingUuid_QNAME, String.class, QueryPending.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "xml", scope = QuickStamp.class)
    public JAXBElement<byte[]> createQuickStampXml(byte[] value) {
        return new JAXBElement<byte[]>(_QuickStampXml_QNAME, byte[].class, QuickStamp.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "username", scope = QuickStamp.class)
    public JAXBElement<String> createQuickStampUsername(String value) {
        return new JAXBElement<String>(_QueryPendingUsername_QNAME, String.class, QuickStamp.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "password", scope = QuickStamp.class)
    public JAXBElement<String> createQuickStampPassword(String value) {
        return new JAXBElement<String>(_QueryPendingPassword_QNAME, String.class, QuickStamp.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AcuseRecepcionCFDI }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "stampResult", scope = StampResponse.class)
    public JAXBElement<AcuseRecepcionCFDI> createStampResponseStampResult(AcuseRecepcionCFDI value) {
        return new JAXBElement<AcuseRecepcionCFDI>(_StampResponseStampResult_QNAME, AcuseRecepcionCFDI.class, StampResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "xml", scope = Stamp.class)
    public JAXBElement<byte[]> createStampXml(byte[] value) {
        return new JAXBElement<byte[]>(_QuickStampXml_QNAME, byte[].class, Stamp.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "username", scope = Stamp.class)
    public JAXBElement<String> createStampUsername(String value) {
        return new JAXBElement<String>(_QueryPendingUsername_QNAME, String.class, Stamp.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "password", scope = Stamp.class)
    public JAXBElement<String> createStampPassword(String value) {
        return new JAXBElement<String>(_QueryPendingPassword_QNAME, String.class, Stamp.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AcuseRecepcionCFDI }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "sign_stampResult", scope = SignStampResponse.class)
    public JAXBElement<AcuseRecepcionCFDI> createSignStampResponseSignStampResult(AcuseRecepcionCFDI value) {
        return new JAXBElement<AcuseRecepcionCFDI>(_SignStampResponseSignStampResult_QNAME, AcuseRecepcionCFDI.class, SignStampResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "username", scope = GetPdf.class)
    public JAXBElement<String> createGetPdfUsername(String value) {
        return new JAXBElement<String>(_QueryPendingUsername_QNAME, String.class, GetPdf.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "password", scope = GetPdf.class)
    public JAXBElement<String> createGetPdfPassword(String value) {
        return new JAXBElement<String>(_QueryPendingPassword_QNAME, String.class, GetPdf.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "uuid", scope = GetPdf.class)
    public JAXBElement<String> createGetPdfUuid(String value) {
        return new JAXBElement<String>(_QueryPendingUuid_QNAME, String.class, GetPdf.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryPendingResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "query_pendingResult", scope = QueryPendingResponse.class)
    public JAXBElement<QueryPendingResult> createQueryPendingResponseQueryPendingResult(QueryPendingResult value) {
        return new JAXBElement<QueryPendingResult>(_QueryPendingResponseQueryPendingResult_QNAME, QueryPendingResult.class, QueryPendingResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AcuseRecepcionCFDI }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "quick_stampResult", scope = QuickStampResponse.class)
    public JAXBElement<AcuseRecepcionCFDI> createQuickStampResponseQuickStampResult(AcuseRecepcionCFDI value) {
        return new JAXBElement<AcuseRecepcionCFDI>(_QuickStampResponseQuickStampResult_QNAME, AcuseRecepcionCFDI.class, QuickStampResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AcuseRecepcionCFDI }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "stampedResult", scope = StampedResponse.class)
    public JAXBElement<AcuseRecepcionCFDI> createStampedResponseStampedResult(AcuseRecepcionCFDI value) {
        return new JAXBElement<AcuseRecepcionCFDI>(_StampedResponseStampedResult_QNAME, AcuseRecepcionCFDI.class, StampedResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "xml", scope = SignStamp.class)
    public JAXBElement<byte[]> createSignStampXml(byte[] value) {
        return new JAXBElement<byte[]>(_QuickStampXml_QNAME, byte[].class, SignStamp.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "username", scope = SignStamp.class)
    public JAXBElement<String> createSignStampUsername(String value) {
        return new JAXBElement<String>(_QueryPendingUsername_QNAME, String.class, SignStamp.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "password", scope = SignStamp.class)
    public JAXBElement<String> createSignStampPassword(String value) {
        return new JAXBElement<String>(_QueryPendingPassword_QNAME, String.class, SignStamp.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "xml", scope = Stamped.class)
    public JAXBElement<byte[]> createStampedXml(byte[] value) {
        return new JAXBElement<byte[]>(_QuickStampXml_QNAME, byte[].class, Stamped.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "username", scope = Stamped.class)
    public JAXBElement<String> createStampedUsername(String value) {
        return new JAXBElement<String>(_QueryPendingUsername_QNAME, String.class, Stamped.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "password", scope = Stamped.class)
    public JAXBElement<String> createStampedPassword(String value) {
        return new JAXBElement<String>(_QueryPendingPassword_QNAME, String.class, Stamped.class, value);
    }

}
