package ke.co.tracom.main;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author kelvin 
 * 
 * response class Acknowledgement
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", namespace = "http://tracom.co.ke/ResultDetails", propOrder = {
    "messageID",
    "messageCode",
    "messageDescription",
    "transactionDate"
})

@XmlRootElement(name = "acknowledgement", namespace = "http://tracom.co.ke/ResultDetails")
public class Acknowledgement implements java.io.Serializable{

    @XmlElement(required = true)
    private String messageID;
    @XmlElement(required = true)
    private String messageCode;
    @XmlElement(required = false)
    private String messageDescription;
    @XmlElement(required = true)
    private String transactionDate;

    public Acknowledgement() {

    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getMessageDescription() {
        return messageDescription;
    }

    public void setMessageDescription(String messageDescription) {
        this.messageDescription = messageDescription;
    }

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

 
}
