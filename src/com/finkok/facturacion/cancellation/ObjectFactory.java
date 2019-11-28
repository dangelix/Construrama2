
package com.finkok.facturacion.cancellation;

import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


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

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.finkok.facturacion.stamp
     * 
     */
    public ObjectFactory() {
    }

//    /**
//     * Create an instance of {@link SignCancel }
//     * 
//     */
//    public SignCancelLocal createSignCancelLocal() {
//        return new SignCancelLocal();
//    }
//
//    /**
//     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
//     * 
//     */
//    @XmlElementDecl(namespace = "http://facturacion.finkok.com/stamp", name = "sign_cancel")
//    public JAXBElement<SignCancelLocal> createSignCancelLocal(SignCancelLocal value) {
//        return new JAXBElement<SignCancelLocal>(_SignCancel_QNAME, SignCancelLocal.class,null, value);
//    }

    public StringArray createStringArray(){
    	return new StringArray();
    }
}
