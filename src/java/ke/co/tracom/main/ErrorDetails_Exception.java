
package ke.co.tracom.main;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "errorDetails", targetNamespace = "http://tracom.co.ke/ErrorDetails")
public class ErrorDetails_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ErrorDetails faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public ErrorDetails_Exception(String message, ErrorDetails faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public ErrorDetails_Exception(String message, ErrorDetails faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: ke.tracom.main.ErrorDetails
     */
    public ErrorDetails getFaultInfo() {
        return faultInfo;
    }

}
