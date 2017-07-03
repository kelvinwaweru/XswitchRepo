package ke.co.tracom.main;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author kelvin
 */
public class MpesaResultFN {

    /**
     *
     * @param messageID
     * @param transactionID
     * @param conversationID
     * @param correlationID
     * @param destinationCode
     * @param externalReference
     * @param transactionDate
     * @param internalReference
     * @param statusCode
     * @param statusDescription
     * @param originatorConversationID
     * @param referenceData
     * @param params
     * @return result
     */
    public static boolean saveMpesaResult(String messageID, String transactionID, String transactionDate,
            String conversationID, String correlationID, String destinationCode, String externalReference,
            String internalReference, String originatorConversationID, String statusCode, String statusDescription,
            List referenceData, List params) {
        boolean result = false;
        String parametersData = null;
        String refDataParams = null;
        DB db = new DB();
        try {

            if (statusCode.equalsIgnoreCase("0")) {   //successful result

                /* read all parameters(key and value of each) and add them to String parametersData 
                 * in the form key,value;key,value;
                 */
                if (params != null) {           //to avoid null pointer exceptions where no params are sent 
                    if (!params.isEmpty()) {
                        for (Object param : params) {
                            Parameter par = (Parameter) param;
                            String key = par.getKey();
                            String value = par.getValue();
                            if (key == null) {
                                key = "*";
                            }
                            if (value == null) {
                                value = "*";
                            }
                            if (parametersData == null) {
                                parametersData = key + "," + value + ";";
                            } else {
                                parametersData += key + "," + value + ";";
                            }
                        }
                    }
                }

                /* read all parameters(key and value of each) and add them to String refDataParams 
                 * in the form key,value;key,value;
                 */
                if (referenceData != null) {           //to avoid null pointer exceptions where no params are sent 
                    if (!referenceData.isEmpty()) {
                        for (Object param : referenceData) {
                            Parameter par = (Parameter) param;
                            String key = par.getKey();
                            String value = par.getValue();
                            if (key == null) {
                                key = "*";
                            }
                            if (value == null) {
                                value = "*";
                            }
                            if (refDataParams == null) {
                                refDataParams = key + "," + value + ";";
                            } else {
                                refDataParams += key + "," + value + ";";
                            }
                        }
                    }
                }

            }
            System.out.println("parametersData: " + parametersData);
            System.out.println("refDataParams: " + refDataParams);

            db.open();
            Session session = db.session();
            Transaction transaction = session.beginTransaction();
            ResultsActivity activity = new ResultsActivity();

            activity.setAdvised(0l);    //set advised = 0
            activity.setMessageID(messageID);
            activity.setTransactionDate(transactionDate);
            activity.setTransactionID(transactionID);
            activity.setConversationID(conversationID);
            activity.setCorrelationID(correlationID);
            activity.setDestinationCode(destinationCode);
            activity.setExternalReference(externalReference);
            activity.setInternalReference(internalReference);
            activity.setOriginatorConversationID(originatorConversationID);
            activity.setStatusCode(statusCode);
            activity.setStatusDescription(statusDescription);
            activity.setReferenceData(refDataParams);
            activity.setParameters(parametersData);

            session.save(activity);
            transaction.commit();

            result = true;
            System.out.println("Successfully added Result\t" + messageID);
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            db.close();
        }
        return result;
    }

    public static String getParam(String paramToFind) {
        DB db = new DB();
        String paramData = "";
        try {
            db.open();
            Session session = db.session();
            Query query = session.createQuery("from Xswtch_Parameter where paramName='" + paramToFind + "'");
            query.setCacheable(true);
            List paramList = query.list();
            if (paramList.size() > 0) {
                Xswtch_Parameter params;
                params = (Xswtch_Parameter) paramList.get(0);
                paramData = String.valueOf(params.getParamValue().trim());
            } else {
                System.out.println("Parameter  '" + paramToFind + "' Doesnt Exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("The parameter name" + paramToFind + "NOT found");
        } finally {
            db.close();
        }
        return paramData;
    }

}
