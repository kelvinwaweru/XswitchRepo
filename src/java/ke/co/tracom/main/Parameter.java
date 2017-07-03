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
 * this parameters class is used to receive parameters in the
 * form key and value
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "key",
    "value"})

@XmlRootElement(name = "parameter")
public class Parameter implements Serializable {

    @XmlElement(required = true)
    String key;
    @XmlElement(required = true)
    String value;

    public Parameter() {
        
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}
