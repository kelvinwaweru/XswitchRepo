/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.co.tracom.main;


/**
 *
 * @author kelvin
 */
public class ResultsActivity implements java.io.Serializable {
    
    private long transNum; 
    private String transactionID;
    private String messageID;
    private String transactionDate;
    private long advised;
    private String conversationID; 
    private String correlationID;
    private String destinationCode;
    private String externalReference;
    private String internalReference;
    private String originatorConversationID;
    private String statusCode;
    private String statusDescription;
    private String referenceData; 
    private String parameters;         
          
    
    public ResultsActivity(){
        
    }
    
    
    public long getTransNum(){
        return transNum;
    }
    
    public void setTransNum(long transNum){
        this.transNum = transNum;
    }
         
    public String getTransactionID(){
        return transactionID;
    }
    
    public void setTransactionID(String transactionID){
        this.transactionID = transactionID;
    }
           
    public String getMessageID(){
        return messageID;
    }
    
    public void setMessageID(String messageID){
        this.messageID = messageID;
    }
    
    public String getTransactionDate(){
        return transactionDate;
    }
    
    public void setTransactionDate(String transactionDate){
        this.transactionDate = transactionDate;
    }
    
    public long getAdvised(){
        return advised;
    }
    
    public void setAdvised(long advised){
        this.advised = advised;
    }

    public String getConversationID() {
        return conversationID;
    }

    public void setConversationID(String conversationID) {
        this.conversationID = conversationID;
    }

    public String getCorrelationID() {
        return correlationID;
    }

    public void setCorrelationID(String correlationID) {
        this.correlationID = correlationID;
    }

    public String getDestinationCode() {
        return destinationCode;
    }

    public void setDestinationCode(String destinationCode) {
        this.destinationCode = destinationCode;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }

    public String getInternalReference() {
        return internalReference;
    }

    public void setInternalReference(String internalReference) {
        this.internalReference = internalReference;
    }

    public String getOriginatorConversationID() {
        return originatorConversationID;
    }

    public void setOriginatorConversationID(String originatorConversationID) {
        this.originatorConversationID = originatorConversationID;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public String getReferenceData() {
        return referenceData;
    }

    public void setReferenceData(String referenceData) {
        this.referenceData = referenceData;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }
    
}

