
package ke.co.tracom.main;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ke.co.tracom.main package. 
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

    private final static QName _CheckSum_QNAME = new QName("http://tracom.co.ke/ResultDetails", "checkSum");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ke.co.tracom.main.ResultDetails
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ResultDetails }
     * 
     * @return 
     */
    public ResultDetails createResultDetails() {
        return new ResultDetails();
    }

   
    /**
     * Create an instance of {@link ErrorDetails }
     * 
     * @return 
     */
    public ErrorDetails createErrorDetails() {
        return new ErrorDetails();
    }

    /**
     * Create an instance of {@link Acknowledgement }
     * 
     * @return 
     */
    public Acknowledgement createAcknowledgement() {
        return new Acknowledgement();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     * @param value
     * @return 
     */
    @XmlElementDecl(namespace = "http://tracom.co.ke/ResultDetails", name = "checkSum")
    public JAXBElement<Object> createCheckSum(Object value) {
        return new JAXBElement<Object>(_CheckSum_QNAME, Object.class, null, value);
    }

}
