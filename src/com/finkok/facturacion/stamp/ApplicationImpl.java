
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.finkok.facturacion.stamp;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.15
 * 2018-05-31T12:13:20.242-05:00
 * Generated source version: 3.1.15
 * 
 */

@javax.jws.WebService(
                      serviceName = "StampSOAP",
                      portName = "Application",
                      targetNamespace = "http://facturacion.finkok.com/stamp",
                      wsdlLocation = "file:/C:/Users/Israel/workspace/WSClientesaso/WebContent/WEB-INF/timboxtest.wsdl",
                      endpointInterface = "com.finkok.facturacion.stamp.Application")
                      
public class ApplicationImpl implements Application {

    private static final Logger LOG = Logger.getLogger(ApplicationImpl.class.getName());

    /* (non-Javadoc)
     * @see com.finkok.facturacion.stamp.Application#queryPending(java.lang.String username, java.lang.String password, java.lang.String uuid)*
     */
    public views.core.soap.services.apps.QueryPendingResult queryPending(java.lang.String username, java.lang.String password, java.lang.String uuid) { 
        LOG.info("Executing operation queryPending");
        System.out.println(username);
        System.out.println(password);
        System.out.println(uuid);
        try {
            views.core.soap.services.apps.QueryPendingResult _return = new views.core.soap.services.apps.QueryPendingResult();
            javax.xml.bind.JAXBElement<java.lang.String> _returnStatus = null;
            _return.setStatus(_returnStatus);
            javax.xml.bind.JAXBElement<java.lang.String> _returnXml = null;
            _return.setXml(_returnXml);
            javax.xml.bind.JAXBElement<java.lang.String> _returnUuid = null;
            _return.setUuid(_returnUuid);
            javax.xml.bind.JAXBElement<java.lang.String> _returnUuidStatus = null;
            _return.setUuidStatus(_returnUuidStatus);
            javax.xml.bind.JAXBElement<java.lang.String> _returnNextAttempt = null;
            _return.setNextAttempt(_returnNextAttempt);
            javax.xml.bind.JAXBElement<java.lang.String> _returnAttempts = null;
            _return.setAttempts(_returnAttempts);
            javax.xml.bind.JAXBElement<java.lang.String> _returnError = null;
            _return.setError(_returnError);
            javax.xml.bind.JAXBElement<java.lang.String> _returnDate = null;
            _return.setDate(_returnDate);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.finkok.facturacion.stamp.Application#stamp(byte[] xml, java.lang.String username, java.lang.String password)*
     */
    public views.core.soap.services.apps.AcuseRecepcionCFDI stamp(byte[] xml, java.lang.String username, java.lang.String password) { 
        LOG.info("Executing operation stamp");
        System.out.println(xml);
        System.out.println(username);
        System.out.println(password);
        try {
            views.core.soap.services.apps.AcuseRecepcionCFDI _return = new views.core.soap.services.apps.AcuseRecepcionCFDI();
            javax.xml.bind.JAXBElement<java.lang.String> _returnXml = null;
            _return.setXml(_returnXml);
            javax.xml.bind.JAXBElement<java.lang.String> _returnUUID = null;
            _return.setUUID(_returnUUID);
            javax.xml.bind.JAXBElement<java.lang.String> _returnFaultstring = null;
            _return.setFaultstring(_returnFaultstring);
            javax.xml.bind.JAXBElement<java.lang.String> _returnFecha = null;
            _return.setFecha(_returnFecha);
            javax.xml.bind.JAXBElement<java.lang.String> _returnCodEstatus = null;
            _return.setCodEstatus(_returnCodEstatus);
            javax.xml.bind.JAXBElement<java.lang.String> _returnFaultcode = null;
            _return.setFaultcode(_returnFaultcode);
            javax.xml.bind.JAXBElement<java.lang.String> _returnSatSeal = null;
            _return.setSatSeal(_returnSatSeal);
            javax.xml.bind.JAXBElement<views.core.soap.services.apps.IncidenciaArray> _returnIncidencias = null;
            _return.setIncidencias(_returnIncidencias);
            javax.xml.bind.JAXBElement<java.lang.String> _returnNoCertificadoSAT = null;
            _return.setNoCertificadoSAT(_returnNoCertificadoSAT);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.finkok.facturacion.stamp.Application#signStamp(byte[] xml, java.lang.String username, java.lang.String password)*
     */
    public views.core.soap.services.apps.AcuseRecepcionCFDI signStamp(byte[] xml, java.lang.String username, java.lang.String password) { 
        LOG.info("Executing operation signStamp");
        System.out.println(xml);
        System.out.println(username);
        System.out.println(password);
        try {
            views.core.soap.services.apps.AcuseRecepcionCFDI _return = new views.core.soap.services.apps.AcuseRecepcionCFDI();
            javax.xml.bind.JAXBElement<java.lang.String> _returnXml = null;
            _return.setXml(_returnXml);
            javax.xml.bind.JAXBElement<java.lang.String> _returnUUID = null;
            _return.setUUID(_returnUUID);
            javax.xml.bind.JAXBElement<java.lang.String> _returnFaultstring = null;
            _return.setFaultstring(_returnFaultstring);
            javax.xml.bind.JAXBElement<java.lang.String> _returnFecha = null;
            _return.setFecha(_returnFecha);
            javax.xml.bind.JAXBElement<java.lang.String> _returnCodEstatus = null;
            _return.setCodEstatus(_returnCodEstatus);
            javax.xml.bind.JAXBElement<java.lang.String> _returnFaultcode = null;
            _return.setFaultcode(_returnFaultcode);
            javax.xml.bind.JAXBElement<java.lang.String> _returnSatSeal = null;
            _return.setSatSeal(_returnSatSeal);
            javax.xml.bind.JAXBElement<views.core.soap.services.apps.IncidenciaArray> _returnIncidencias = null;
            _return.setIncidencias(_returnIncidencias);
            javax.xml.bind.JAXBElement<java.lang.String> _returnNoCertificadoSAT = null;
            _return.setNoCertificadoSAT(_returnNoCertificadoSAT);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.finkok.facturacion.stamp.Application#quickStamp(byte[] xml, java.lang.String username, java.lang.String password)*
     */
    public views.core.soap.services.apps.AcuseRecepcionCFDI quickStamp(byte[] xml, java.lang.String username, java.lang.String password) { 
        LOG.info("Executing operation quickStamp");
        System.out.println(xml);
        System.out.println(username);
        System.out.println(password);
        try {
            views.core.soap.services.apps.AcuseRecepcionCFDI _return = new views.core.soap.services.apps.AcuseRecepcionCFDI();
            javax.xml.bind.JAXBElement<java.lang.String> _returnXml = null;
            _return.setXml(_returnXml);
            javax.xml.bind.JAXBElement<java.lang.String> _returnUUID = null;
            _return.setUUID(_returnUUID);
            javax.xml.bind.JAXBElement<java.lang.String> _returnFaultstring = null;
            _return.setFaultstring(_returnFaultstring);
            javax.xml.bind.JAXBElement<java.lang.String> _returnFecha = null;
            _return.setFecha(_returnFecha);
            javax.xml.bind.JAXBElement<java.lang.String> _returnCodEstatus = null;
            _return.setCodEstatus(_returnCodEstatus);
            javax.xml.bind.JAXBElement<java.lang.String> _returnFaultcode = null;
            _return.setFaultcode(_returnFaultcode);
            javax.xml.bind.JAXBElement<java.lang.String> _returnSatSeal = null;
            _return.setSatSeal(_returnSatSeal);
            javax.xml.bind.JAXBElement<views.core.soap.services.apps.IncidenciaArray> _returnIncidencias = null;
            _return.setIncidencias(_returnIncidencias);
            javax.xml.bind.JAXBElement<java.lang.String> _returnNoCertificadoSAT = null;
            _return.setNoCertificadoSAT(_returnNoCertificadoSAT);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.finkok.facturacion.stamp.Application#getPdf(java.lang.String username, java.lang.String password, java.lang.String uuid)*
     */
    public views.core.soap.services.apps.PDFResult getPdf(java.lang.String username, java.lang.String password, java.lang.String uuid) { 
        LOG.info("Executing operation getPdf");
        System.out.println(username);
        System.out.println(password);
        System.out.println(uuid);
        try {
            views.core.soap.services.apps.PDFResult _return = new views.core.soap.services.apps.PDFResult();
            javax.xml.bind.JAXBElement<byte[]> _returnPdf = null;
            _return.setPdf(_returnPdf);
            javax.xml.bind.JAXBElement<java.lang.String> _returnError = null;
            _return.setError(_returnError);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.finkok.facturacion.stamp.Application#stamped(byte[] xml, java.lang.String username, java.lang.String password)*
     */
    public views.core.soap.services.apps.AcuseRecepcionCFDI stamped(byte[] xml, java.lang.String username, java.lang.String password) { 
        LOG.info("Executing operation stamped");
        System.out.println(xml);
        System.out.println(username);
        System.out.println(password);
        try {
            views.core.soap.services.apps.AcuseRecepcionCFDI _return = new views.core.soap.services.apps.AcuseRecepcionCFDI();
            javax.xml.bind.JAXBElement<java.lang.String> _returnXml = null;
            _return.setXml(_returnXml);
            javax.xml.bind.JAXBElement<java.lang.String> _returnUUID = null;
            _return.setUUID(_returnUUID);
            javax.xml.bind.JAXBElement<java.lang.String> _returnFaultstring = null;
            _return.setFaultstring(_returnFaultstring);
            javax.xml.bind.JAXBElement<java.lang.String> _returnFecha = null;
            _return.setFecha(_returnFecha);
            javax.xml.bind.JAXBElement<java.lang.String> _returnCodEstatus = null;
            _return.setCodEstatus(_returnCodEstatus);
            javax.xml.bind.JAXBElement<java.lang.String> _returnFaultcode = null;
            _return.setFaultcode(_returnFaultcode);
            javax.xml.bind.JAXBElement<java.lang.String> _returnSatSeal = null;
            _return.setSatSeal(_returnSatSeal);
            javax.xml.bind.JAXBElement<views.core.soap.services.apps.IncidenciaArray> _returnIncidencias = null;
            _return.setIncidencias(_returnIncidencias);
            javax.xml.bind.JAXBElement<java.lang.String> _returnNoCertificadoSAT = null;
            _return.setNoCertificadoSAT(_returnNoCertificadoSAT);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
