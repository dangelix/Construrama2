
package views.core.soap.services.apps;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.finkok.facturacion.cancellation.StringArray;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the views.core.soap.services.apps package. 
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

    private final static QName _Incidencia_QNAME = new QName("apps.services.soap.core.views", "Incidencia");
    private final static QName _QueryPendingResult_QNAME = new QName("apps.services.soap.core.views", "QueryPendingResult");
    private final static QName _IncidenciaArray_QNAME = new QName("apps.services.soap.core.views", "IncidenciaArray");
    private final static QName _AcuseRecepcionCFDI_QNAME = new QName("apps.services.soap.core.views", "AcuseRecepcionCFDI");
    private final static QName _PDFResult_QNAME = new QName("apps.services.soap.core.views", "PDFResult");
    private final static QName _PDFResultPdf_QNAME = new QName("apps.services.soap.core.views", "pdf");
    private final static QName _PDFResultError_QNAME = new QName("apps.services.soap.core.views", "error");
    private final static QName _AcuseRecepcionCFDIXml_QNAME = new QName("apps.services.soap.core.views", "xml");
    private final static QName _AcuseRecepcionCFDIUUID_QNAME = new QName("apps.services.soap.core.views", "UUID");
    private final static QName _AcuseRecepcionCFDIFaultstring_QNAME = new QName("apps.services.soap.core.views", "faultstring");
    private final static QName _AcuseRecepcionCFDIFecha_QNAME = new QName("apps.services.soap.core.views", "Fecha");
    private final static QName _AcuseRecepcionCFDICodEstatus_QNAME = new QName("apps.services.soap.core.views", "CodEstatus");
    private final static QName _AcuseRecepcionCFDIFaultcode_QNAME = new QName("apps.services.soap.core.views", "faultcode");
    private final static QName _AcuseRecepcionCFDISatSeal_QNAME = new QName("apps.services.soap.core.views", "SatSeal");
    private final static QName _AcuseRecepcionCFDIIncidencias_QNAME = new QName("apps.services.soap.core.views", "Incidencias");
    private final static QName _AcuseRecepcionCFDINoCertificadoSAT_QNAME = new QName("apps.services.soap.core.views", "NoCertificadoSAT");
    private final static QName _QueryPendingResultStatus_QNAME = new QName("apps.services.soap.core.views", "status");
    private final static QName _QueryPendingResultUuid_QNAME = new QName("apps.services.soap.core.views", "uuid");
    private final static QName _QueryPendingResultUuidStatus_QNAME = new QName("apps.services.soap.core.views", "uuid_status");
    private final static QName _QueryPendingResultNextAttempt_QNAME = new QName("apps.services.soap.core.views", "next_attempt");
    private final static QName _QueryPendingResultAttempts_QNAME = new QName("apps.services.soap.core.views", "attempts");
    private final static QName _QueryPendingResultDate_QNAME = new QName("apps.services.soap.core.views", "date");
    private final static QName _IncidenciaIdIncidencia_QNAME = new QName("apps.services.soap.core.views", "IdIncidencia");
    private final static QName _IncidenciaRfcEmisor_QNAME = new QName("apps.services.soap.core.views", "RfcEmisor");
    private final static QName _IncidenciaUuid_QNAME = new QName("apps.services.soap.core.views", "Uuid");
    private final static QName _IncidenciaCodigoError_QNAME = new QName("apps.services.soap.core.views", "CodigoError");
    private final static QName _IncidenciaWorkProcessId_QNAME = new QName("apps.services.soap.core.views", "WorkProcessId");
    private final static QName _IncidenciaMensajeIncidencia_QNAME = new QName("apps.services.soap.core.views", "MensajeIncidencia");
    private final static QName _IncidenciaExtraInfo_QNAME = new QName("apps.services.soap.core.views", "ExtraInfo");
    private final static QName _IncidenciaNoCertificadoPac_QNAME = new QName("apps.services.soap.core.views", "NoCertificadoPac");
    private final static QName _ReceiptResultDate_QNAME = new QName("apps.services.soap.core.views", "date");
    private final static QName _IncidenciaFechaRegistro_QNAME = new QName("apps.services.soap.core.views", "FechaRegistro");
    private final static QName _ReceiptResultError_QNAME = new QName("apps.services.soap.core.views", "error");
    private final static QName _CancelaCFDResultCodEstatus_QNAME = new QName("apps.services.soap.core.views", "CodEstatus");
    private final static QName _CancelaCFDResultRfcEmisor_QNAME = new QName("apps.services.soap.core.views", "RfcEmisor");
    private final static QName _CancelaCFDResultFecha_QNAME = new QName("apps.services.soap.core.views", "Fecha");
    private final static QName _CancelaCFDResultAcuse_QNAME = new QName("apps.services.soap.core.views", "Acuse");
    private final static QName _CancelaUUIDS_QNAME = new QName("apps.services.soap.core.views", "UUIDS");
    private final static QName _CancelUuidsUuids_QNAME = new QName("apps.services.soap.core.views", "uuids");
    private final static QName _ReceiptResultUuid_QNAME = new QName("apps.services.soap.core.views", "uuid");
    private final static QName _ReceiptResultSuccess_QNAME = new QName("apps.services.soap.core.views", "success");
    private final static QName _ReceiptResultReceipt_QNAME = new QName("apps.services.soap.core.views", "receipt");
    private final static QName _ReceiptResultTaxpayerId_QNAME = new QName("apps.services.soap.core.views", "taxpayer_id");
    private final static QName _CancelaCFDResultFolios_QNAME = new QName("apps.services.soap.core.views", "Folios");
    private final static QName _FolioUUID_QNAME = new QName("apps.services.soap.core.views", "UUID");
    private final static QName _FolioEstatusUUID_QNAME = new QName("apps.services.soap.core.views", "EstatusUUID");
    private final static QName _FolioEstatusCancelacion_QNAME = new QName("apps.services.soap.core.views", "EstatusCancelacion");
    private final static QName _AcuseSatConsultaCodigoEstatus_QNAME = new QName("apps.services.soap.core.views", "CodigoEstatus");
    private final static QName _AcuseSatConsultaEsCancelable_QNAME = new QName("apps.services.soap.core.views", "esCancelable");
    private final static QName _AcuseSatConsultaEstado_QNAME = new QName("apps.services.soap.core.views", "estado");
    private final static QName _AcuseSatConsultaEstatusCancelacion_QNAME = new QName("apps.services.soap.core.views", "estatusCancelacion");
    
    
    
    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: views.core.soap.services.apps
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Incidencia }
     * 
     */
    public Incidencia createIncidencia() {
        return new Incidencia();
    }

    /**
     * Create an instance of {@link QueryPendingResult }
     * 
     */
    public QueryPendingResult createQueryPendingResult() {
        return new QueryPendingResult();
    }

    /**
     * Create an instance of {@link IncidenciaArray }
     * 
     */
    public IncidenciaArray createIncidenciaArray() {
        return new IncidenciaArray();
    }

    /**
     * Create an instance of {@link AcuseRecepcionCFDI }
     * 
     */
    public AcuseRecepcionCFDI createAcuseRecepcionCFDI() {
        return new AcuseRecepcionCFDI();
    }

    /**
     * Create an instance of {@link PDFResult }
     * 
     */
    public PDFResult createPDFResult() {
        return new PDFResult();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Incidencia }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "Incidencia")
    public JAXBElement<Incidencia> createIncidencia(Incidencia value) {
        return new JAXBElement<Incidencia>(_Incidencia_QNAME, Incidencia.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryPendingResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "QueryPendingResult")
    public JAXBElement<QueryPendingResult> createQueryPendingResult(QueryPendingResult value) {
        return new JAXBElement<QueryPendingResult>(_QueryPendingResult_QNAME, QueryPendingResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IncidenciaArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "IncidenciaArray")
    public JAXBElement<IncidenciaArray> createIncidenciaArray(IncidenciaArray value) {
        return new JAXBElement<IncidenciaArray>(_IncidenciaArray_QNAME, IncidenciaArray.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AcuseRecepcionCFDI }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "AcuseRecepcionCFDI")
    public JAXBElement<AcuseRecepcionCFDI> createAcuseRecepcionCFDI(AcuseRecepcionCFDI value) {
        return new JAXBElement<AcuseRecepcionCFDI>(_AcuseRecepcionCFDI_QNAME, AcuseRecepcionCFDI.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PDFResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "PDFResult")
    public JAXBElement<PDFResult> createPDFResult(PDFResult value) {
        return new JAXBElement<PDFResult>(_PDFResult_QNAME, PDFResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "pdf", scope = PDFResult.class)
    public JAXBElement<byte[]> createPDFResultPdf(byte[] value) {
        return new JAXBElement<byte[]>(_PDFResultPdf_QNAME, byte[].class, PDFResult.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "error", scope = PDFResult.class)
    public JAXBElement<String> createPDFResultError(String value) {
        return new JAXBElement<String>(_PDFResultError_QNAME, String.class, PDFResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "xml", scope = AcuseRecepcionCFDI.class)
    public JAXBElement<String> createAcuseRecepcionCFDIXml(String value) {
        return new JAXBElement<String>(_AcuseRecepcionCFDIXml_QNAME, String.class, AcuseRecepcionCFDI.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "UUID", scope = AcuseRecepcionCFDI.class)
    public JAXBElement<String> createAcuseRecepcionCFDIUUID(String value) {
        return new JAXBElement<String>(_AcuseRecepcionCFDIUUID_QNAME, String.class, AcuseRecepcionCFDI.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "faultstring", scope = AcuseRecepcionCFDI.class)
    public JAXBElement<String> createAcuseRecepcionCFDIFaultstring(String value) {
        return new JAXBElement<String>(_AcuseRecepcionCFDIFaultstring_QNAME, String.class, AcuseRecepcionCFDI.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "Fecha", scope = AcuseRecepcionCFDI.class)
    public JAXBElement<String> createAcuseRecepcionCFDIFecha(String value) {
        return new JAXBElement<String>(_AcuseRecepcionCFDIFecha_QNAME, String.class, AcuseRecepcionCFDI.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "CodEstatus", scope = AcuseRecepcionCFDI.class)
    public JAXBElement<String> createAcuseRecepcionCFDICodEstatus(String value) {
        return new JAXBElement<String>(_AcuseRecepcionCFDICodEstatus_QNAME, String.class, AcuseRecepcionCFDI.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "faultcode", scope = AcuseRecepcionCFDI.class)
    public JAXBElement<String> createAcuseRecepcionCFDIFaultcode(String value) {
        return new JAXBElement<String>(_AcuseRecepcionCFDIFaultcode_QNAME, String.class, AcuseRecepcionCFDI.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "SatSeal", scope = AcuseRecepcionCFDI.class)
    public JAXBElement<String> createAcuseRecepcionCFDISatSeal(String value) {
        return new JAXBElement<String>(_AcuseRecepcionCFDISatSeal_QNAME, String.class, AcuseRecepcionCFDI.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IncidenciaArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "Incidencias", scope = AcuseRecepcionCFDI.class)
    public JAXBElement<IncidenciaArray> createAcuseRecepcionCFDIIncidencias(IncidenciaArray value) {
        return new JAXBElement<IncidenciaArray>(_AcuseRecepcionCFDIIncidencias_QNAME, IncidenciaArray.class, AcuseRecepcionCFDI.class, value);
    }
    
//    /**
//     * Create an instance of {@link JAXBElement }{@code <}{@link IncidenciaArray }{@code >}}
//     * 
//     */
//    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "UUIDS", scope = Cancel.class)
//    public JAXBElement<UUIDS> createCancelUUIDS(UUIDS value) {
//        return new JAXBElement<UUIDS>(_CancelaUUIDS_QNAME, UUIDS.class, Cancel.class, value);
//    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "NoCertificadoSAT", scope = AcuseRecepcionCFDI.class)
    public JAXBElement<String> createAcuseRecepcionCFDINoCertificadoSAT(String value) {
        return new JAXBElement<String>(_AcuseRecepcionCFDINoCertificadoSAT_QNAME, String.class, AcuseRecepcionCFDI.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "status", scope = QueryPendingResult.class)
    public JAXBElement<String> createQueryPendingResultStatus(String value) {
        return new JAXBElement<String>(_QueryPendingResultStatus_QNAME, String.class, QueryPendingResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "xml", scope = QueryPendingResult.class)
    public JAXBElement<String> createQueryPendingResultXml(String value) {
        return new JAXBElement<String>(_AcuseRecepcionCFDIXml_QNAME, String.class, QueryPendingResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "uuid", scope = QueryPendingResult.class)
    public JAXBElement<String> createQueryPendingResultUuid(String value) {
        return new JAXBElement<String>(_QueryPendingResultUuid_QNAME, String.class, QueryPendingResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "uuid_status", scope = QueryPendingResult.class)
    public JAXBElement<String> createQueryPendingResultUuidStatus(String value) {
        return new JAXBElement<String>(_QueryPendingResultUuidStatus_QNAME, String.class, QueryPendingResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "next_attempt", scope = QueryPendingResult.class)
    public JAXBElement<String> createQueryPendingResultNextAttempt(String value) {
        return new JAXBElement<String>(_QueryPendingResultNextAttempt_QNAME, String.class, QueryPendingResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "attempts", scope = QueryPendingResult.class)
    public JAXBElement<String> createQueryPendingResultAttempts(String value) {
        return new JAXBElement<String>(_QueryPendingResultAttempts_QNAME, String.class, QueryPendingResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "error", scope = QueryPendingResult.class)
    public JAXBElement<String> createQueryPendingResultError(String value) {
        return new JAXBElement<String>(_PDFResultError_QNAME, String.class, QueryPendingResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "date", scope = QueryPendingResult.class)
    public JAXBElement<String> createQueryPendingResultDate(String value) {
        return new JAXBElement<String>(_QueryPendingResultDate_QNAME, String.class, QueryPendingResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "IdIncidencia", scope = Incidencia.class)
    public JAXBElement<String> createIncidenciaIdIncidencia(String value) {
        return new JAXBElement<String>(_IncidenciaIdIncidencia_QNAME, String.class, Incidencia.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "RfcEmisor", scope = Incidencia.class)
    public JAXBElement<String> createIncidenciaRfcEmisor(String value) {
        return new JAXBElement<String>(_IncidenciaRfcEmisor_QNAME, String.class, Incidencia.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "Uuid", scope = Incidencia.class)
    public JAXBElement<String> createIncidenciaUuid(String value) {
        return new JAXBElement<String>(_IncidenciaUuid_QNAME, String.class, Incidencia.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "CodigoError", scope = Incidencia.class)
    public JAXBElement<String> createIncidenciaCodigoError(String value) {
        return new JAXBElement<String>(_IncidenciaCodigoError_QNAME, String.class, Incidencia.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "WorkProcessId", scope = Incidencia.class)
    public JAXBElement<String> createIncidenciaWorkProcessId(String value) {
        return new JAXBElement<String>(_IncidenciaWorkProcessId_QNAME, String.class, Incidencia.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "MensajeIncidencia", scope = Incidencia.class)
    public JAXBElement<String> createIncidenciaMensajeIncidencia(String value) {
        return new JAXBElement<String>(_IncidenciaMensajeIncidencia_QNAME, String.class, Incidencia.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "ExtraInfo", scope = Incidencia.class)
    public JAXBElement<String> createIncidenciaExtraInfo(String value) {
        return new JAXBElement<String>(_IncidenciaExtraInfo_QNAME, String.class, Incidencia.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "NoCertificadoPac", scope = Incidencia.class)
    public JAXBElement<String> createIncidenciaNoCertificadoPac(String value) {
        return new JAXBElement<String>(_IncidenciaNoCertificadoPac_QNAME, String.class, Incidencia.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "FechaRegistro", scope = Incidencia.class)
    public JAXBElement<String> createIncidenciaFechaRegistro(String value) {
        return new JAXBElement<String>(_IncidenciaFechaRegistro_QNAME, String.class, Incidencia.class, value);
    }

    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "date", scope = ReceiptResult.class)
    public JAXBElement<String> createReceiptResultDate(String value) {
        return new JAXBElement<String>(_ReceiptResultDate_QNAME, String.class, ReceiptResult.class, value);
    }
    
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "error", scope = ReceiptResult.class)
    public JAXBElement<String> createReceiptResulError(String value) {
        return new JAXBElement<String>(_ReceiptResultError_QNAME, String.class, ReceiptResult.class, value);
    }
    
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "CodEstatus", scope = CancelaCFDResult.class)
    public JAXBElement<String> createCancelaCFDResultCodEstatus(String value) {
        return new JAXBElement<String>(_CancelaCFDResultCodEstatus_QNAME, String.class, CancelaCFDResult.class, value);
    }
    
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "RfcEmisor", scope = CancelaCFDResult.class)
    public JAXBElement<String> createCancelaCFDResultRfcEmisor(String value) {
        return new JAXBElement<String>(_CancelaCFDResultRfcEmisor_QNAME, String.class, CancelaCFDResult.class, value);
    }
    
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "Fecha", scope = CancelaCFDResult.class)
    public JAXBElement<String> createCancelaCFDResultFecha(String value) {
        return new JAXBElement<String>(_CancelaCFDResultFecha_QNAME, String.class, CancelaCFDResult.class, value);
    }
    
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "Acuse", scope = CancelaCFDResult.class)
    public JAXBElement<String> createCancelaCFDResultAcuse(String value) {
        return new JAXBElement<String>(_CancelaCFDResultAcuse_QNAME, String.class, CancelaCFDResult.class, value);
    }
    
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "uuid", scope = ReceiptResult.class)
    public JAXBElement<String> createReceiptResultUuid(String value) {
        return new JAXBElement<String>(_ReceiptResultUuid_QNAME, String.class, ReceiptResult.class, value);
    }
    
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "success", scope = ReceiptResult.class)
    public JAXBElement<String> createReceiptResultSuccess(String value) {
        return new JAXBElement<String>(_ReceiptResultSuccess_QNAME, String.class, ReceiptResult.class, value);
    }
    
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "receipt", scope = ReceiptResult.class)
    public JAXBElement<String> createReceiptResultReceipt(String value) {
        return new JAXBElement<String>(_ReceiptResultReceipt_QNAME, String.class, ReceiptResult.class, value);
    }
    
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "taxpayer_id", scope = ReceiptResult.class)
    public JAXBElement<String> createReceiptResultTaxpayerI(String value) {
        return new JAXBElement<String>(_ReceiptResultTaxpayerId_QNAME, String.class, ReceiptResult.class, value);
    }
    
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "uuids", scope = UUIDS.class)
    public JAXBElement<StringArray> createUUIDSUuids(StringArray value) {
        return new JAXBElement<StringArray>(_CancelUuidsUuids_QNAME, StringArray.class, UUIDS.class, value);
    }
    
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "Folios", scope = CancelaCFDResult.class)
    public JAXBElement<FolioArray> createCancelaCFDResultFolios(FolioArray value) {
        return new JAXBElement<FolioArray>(_CancelaCFDResultFolios_QNAME, FolioArray.class, CancelaCFDResult.class, value);
    }
    
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "UUID", scope = Folio.class)
    public JAXBElement<String> createCancelaCFDResultFolios(String value) {
        return new JAXBElement<String>(_FolioUUID_QNAME, String.class, Folio.class, value);
    }
    
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "EstatusUUID", scope = Folio.class)
    public JAXBElement<String> createFolioEstatusUUID(String value) {
        return new JAXBElement<String>(_FolioEstatusUUID_QNAME, String.class, Folio.class, value);
    }
    
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "EstatusCancelacion", scope = Folio.class)
    public JAXBElement<String> createFolioEstatusCancelacion(String value) {
        return new JAXBElement<String>(_FolioEstatusCancelacion_QNAME, String.class, Folio.class, value);
    }
    
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "CodigoEstatus", scope = AcuseSATConsulta.class)
    public JAXBElement<String> createAcuseSatConsultaCodigoEstatus(String value) {
        return new JAXBElement<String>(_AcuseSatConsultaCodigoEstatus_QNAME, String.class, AcuseSATConsulta.class, value);
    }
    
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "esCancelable", scope = AcuseSATConsulta.class)
    public JAXBElement<String> createAcuseSatConsultaEsCancelable(String value) {
        return new JAXBElement<String>(_AcuseSatConsultaEsCancelable_QNAME, String.class, AcuseSATConsulta.class, value);
    }
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "estado", scope = AcuseSATConsulta.class)
    public JAXBElement<String> createAcuseSatConsultaEstado(String value) {
        return new JAXBElement<String>(_AcuseSatConsultaEstado_QNAME, String.class, AcuseSATConsulta.class, value);
    }
    @XmlElementDecl(namespace = "apps.services.soap.core.views", name = "estatusCancelacion", scope = AcuseSATConsulta.class)
    public JAXBElement<String> createAcuseSatConsultaEstatusCancelacion(String value) {
        return new JAXBElement<String>(_AcuseSatConsultaEstatusCancelacion_QNAME, String.class, AcuseSATConsulta.class, value);
    }
    
}
