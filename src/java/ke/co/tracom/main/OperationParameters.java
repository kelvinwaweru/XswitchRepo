/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.co.tracom.main;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author kelvin
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "correlationID",
    "destinationCode",
    "statusCode",
    "statusDescription",
    "internalReference",
    "originatorConversationID",
    "externalReference",
    "conversationID"})

@XmlRootElement(name = "operationParameters")
public class OperationParameters implements Serializable {
    
    @XmlElement(required = true)
    protected String correlationID;
    @XmlElement(required = true)
    protected String destinationCode;
    @XmlElement(required = true)
    protected String statusCode;
    @XmlElement(required = true)
    protected String statusDescription;
    @XmlElement(required = true)
    protected String internalReference; 
    @XmlElement(required = true)
    protected String originatorConversationID; 
    @XmlElement(required = true)
    protected String externalReference; 
    @XmlElement(required = true)
    protected String conversationID; 
    
    
    public OperationParameters(){
        
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

    public String getExternalReference() {
        return externalReference;
    }

    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }

    public String getConversationID() {
        return conversationID;
    }

    public void setConversationID(String conversationID) {
        this.conversationID = conversationID;
    }

  
    
    
}
