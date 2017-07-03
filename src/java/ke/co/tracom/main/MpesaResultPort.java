package ke.co.tracom.main;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
//import javax.xml.ws.ResponseWrapper;

/**
 *
 * @author kelvin
 * This MpesaResultPort is an interface to the mpesaResultDetails
 * service it exposes the weParams of the web service it is overridden by the
 * method mpesaResultDetails in the web service class COOPBankMpesaResultService
 */
@WebService(name = "Mpesa_Result_Service_Port", targetNamespace = "http://tracom.co.ke/ResultDetails")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MpesaResultPort {

    /**
     *
     * @param params
     * @param results
     * @param refData
     * @param opParams
     * @return
     * @throws ErrorDetails_Exception
     */
    @WebMethod(action = "http://localhost/mpesaResult")  //TODO set correct IP 
    @WebResult(name = "acknowledgement", targetNamespace = "http://tracom.co.ke/ResultDetails", partName = "acknowledgement")
//    @ResponseWrapper(localName = "acknowledgement", targetNamespace = "http://tracom.co.ke/ResultDetails", className = "ke.co.tracom.main.jaxws.MpesaResultDetailsResponse")

    public Acknowledgement mpesaResultDetails(
            @WebParam(name = "operationParameters", targetNamespace = "http://tracom.co.ke/ResultDetails", partName = "mpesaResultDetails") OperationParameters opParams,
            @WebParam(name = "referenceData", targetNamespace = "http://tracom.co.ke/ResultDetails", partName = "mpesaResultDetails") ReferenceData refData,
            @WebParam(name = "resultDetails", targetNamespace = "http://tracom.co.ke/ResultDetails", partName = "mpesaResultDetails") ResultDetails results,
            @WebParam(name = "parameters", targetNamespace = "http://tracom.co.ke/ResultDetails", partName = "mpesaResultDetails") ArrayOfParameter params)
            throws ErrorDetails_Exception;

}
