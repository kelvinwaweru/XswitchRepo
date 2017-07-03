package ke.co.tracom.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import ke.co.tracom.main.Acknowledgement;
import ke.co.tracom.main.MpesaResultFN;
import javax.jws.WebService;
import javax.xml.datatype.DatatypeConfigurationException;
import ke.co.tracom.main.ArrayOfParameter;
import ke.co.tracom.main.ErrorDetails_Exception;
import ke.co.tracom.main.MpesaResultPort;
import ke.co.tracom.main.OperationParameters;
import ke.co.tracom.main.ReferenceData;
import ke.co.tracom.main.ResultDetails;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author kelvin This class processes the soap result requests from SOA
 * received from Safaricom and saves them in the db for Xswitch consumption
 */
@WebService(serviceName = "MpesaResultService", portName = "Mpesa_Result_Service_Port", endpointInterface = "ke.co.tracom.main.MpesaResultPort", targetNamespace = "http://tracom.co.ke/ResultDetails")
public class CoopBankMpesaResultService implements MpesaResultPort {

    private boolean result = false;
    protected boolean allowed = false;
    Acknowledgement ack = new Acknowledgement();
    @Resource
    WebServiceContext wsctx;

    /**
     *
     * @param mpesaTrans
     * @param params
     * @param refData
     * @param opParams
     * @return ack
     * @throws ErrorDetails_Exception
     */
    @Override
    public Acknowledgement mpesaResultDetails(OperationParameters opParams, ReferenceData refData, ResultDetails mpesaTrans, ArrayOfParameter params) throws ErrorDetails_Exception {
//
//        Date dtStamp = new Date();
//        SimpleDateFormat d = new SimpleDateFormat();
//        GregorianCalendar gregory = new GregorianCalendar();
        String transDate = null;
        Date sdate = new Date();
        GregorianCalendar gcalendar = new GregorianCalendar();
        gcalendar.setTime(sdate);
        try {
            XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcalendar);
            transDate = xmlDate.toString();
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(CoopBankMpesaResultService.class.getName()).log(Level.SEVERE, null, ex);
        }
//        // do authentication
        allowed = doAuthentication();
        if (!allowed) {
            ack.setMessageCode("3");
            ack.setMessageDescription("Access denied");
            ack.setTransactionDate(transDate);
            return ack;
        }
        System.out.println("Status code: " + opParams.getStatusCode());

        if (opParams.getStatusCode().equalsIgnoreCase("0")) {   //successful result
            List paramsList = null;
            List refDataParams = null;
            
            if (params != null) {
                if (!params.getParameter().isEmpty()) {     //error handling
                    paramsList = params.getParameter();
                }
            }
            if (refData != null) {                 //error handling
                if (!refData.getRefParameter().isEmpty()) {
                    refDataParams = refData.getRefParameter();
                }
            }
//        //check that all params are not null
            if (mpesaTrans.getMesssageID() == null || mpesaTrans.getTransactionID() == null) {
                ack.setMessageCode("1");
                ack.setMessageDescription("Mandatory input parameter missing");
                System.out.println("Message ID: " + mpesaTrans.getMesssageID());
                System.out.println("Transaction ID: " + mpesaTrans.getTransactionID());
//                result = MpesaResultFN.saveMpesaResult(mpesaTrans.getMesssageID(), mpesaTrans.getTransactionID(), "", opParams.getConversationID(), opParams.getCorrelationID(), opParams.getDestinationCode(), opParams.getExternalReference(), opParams.getInternalReference(), opParams.getOriginatorConversationID(), opParams.getStatusCode(), opParams.getStatusDescription(), null, null);

            } else {
                System.out.println("result\t" + mpesaTrans.getMesssageID() + "\treceived");

                ack.setMessageID(mpesaTrans.getMesssageID());  //set messageID retuned == messageID received

                result = MpesaResultFN.saveMpesaResult(mpesaTrans.getMesssageID(), mpesaTrans.getTransactionID(), "", opParams.getConversationID(), opParams.getCorrelationID(), opParams.getDestinationCode(), opParams.getExternalReference(), opParams.getInternalReference(), opParams.getOriginatorConversationID(), opParams.getStatusCode(), opParams.getStatusDescription(), refDataParams, paramsList);
//            result = true;  //simulate approval
                if (result) {    //approved
                    ack.setMessageCode("0");
                    ack.setMessageDescription("Received successfully");
                } else {
                    ack.setMessageCode("2");
                    ack.setMessageDescription("Internal server error. Please contact the admin");
                }

            }
        } else {
            System.out.println("Status desc: " + opParams.getStatusDescription());
            result = MpesaResultFN.saveMpesaResult(mpesaTrans.getMesssageID(), mpesaTrans.getTransactionID(), "", opParams.getConversationID(), opParams.getCorrelationID(), opParams.getDestinationCode(), opParams.getExternalReference(), opParams.getInternalReference(), opParams.getOriginatorConversationID(), opParams.getStatusCode(), opParams.getStatusDescription(), null, null);
//            result = true;  //simulate approval
            if (result) {    //approved
                ack.setMessageCode("0");
                ack.setMessageDescription("Received successfully");
            } else {
                ack.setMessageCode("2");
                ack.setMessageDescription("Internal server error. Please contact the admin");
            }
        }

        ack.setTransactionDate(transDate);
        return ack;
    }

    private boolean doAuthentication() {

        MessageContext mctx = wsctx.getMessageContext();
        Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);

        ArrayList list = (ArrayList) http_headers.get("Authorization");
        if (list == null || list.isEmpty()) {
            System.out.println("Authentication failed! This WS needs BASIC Authentication!");
            return false;
        }

        String userpass = (String) list.get(0);
        userpass = userpass.substring(5);
        byte[] buf = Base64.decodeBase64(userpass.getBytes());
        String credentials = new String(buf);

        String username = null;
        String password = null;
//        System.out.println("credentials " + credentials);
        int p = credentials.indexOf(":");
        if (p > -1) {
            username = credentials.substring(0, p);
            password = credentials.substring(p + 1);
        } else {
            System.out.println("There was an error while decoding the Authentication!");
            return false;
        }

//        System.out.println("username " + username);
//        System.out.println("password " + password);
        
        //validate username and password with those from database
        String WsUserName = MpesaResultFN.getParam("SafaricomFloat_WS_userName");
        String Wspassword = MpesaResultFN.getParam("SafaricomFloat_WS_password");
        
//        System.out.println("WsUserName " + WsUserName);
//        System.out.println("Wspassword " + Wspassword);

//        return username.equals("postest") && password.equals("pos123");
        return username.equals(WsUserName) && password.equals(Wspassword);
    }

}
