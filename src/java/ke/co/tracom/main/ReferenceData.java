
package ke.co.tracom.main;

//import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kelvin
 */
@XmlRootElement(name = "referenceData")
public class ReferenceData implements Serializable{
    

    /**
     * this receives a list of parameters
     */
    @XmlElement(required = false)
    protected List<Parameter> refParam;

    public ReferenceData(){
        
    }

    public List<Parameter> getRefParameter() {
        return refParam;
    }

    public void setRefParameter(List<Parameter> refParam) {
        this.refParam = refParam;
    }

     
}
