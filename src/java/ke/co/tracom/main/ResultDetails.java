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
    "messsageID",
    "transactionID",
    "transactionDate"})

@XmlRootElement(name = "resultDetails")
public class ResultDetails implements Serializable {

    @XmlElement(required = true)
    protected String messsageID;
    @XmlElement(required = true)
    protected String transactionID;
    @XmlElement(required = true)
    protected String transactionDate;

    public ResultDetails() {
    }

    public String getMesssageID() {
        return messsageID;
    }

    public void setMesssageID(String messsageID) {
        this.messsageID = messsageID;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }
 
}
