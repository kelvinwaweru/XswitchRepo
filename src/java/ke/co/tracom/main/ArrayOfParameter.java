/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.co.tracom.main;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kelvin
 */

@XmlRootElement(name = "parameters")
public class ArrayOfParameter implements Serializable{

    /**
     * this receives a list of parameters
     */
    @XmlElement(required = false)
    protected List<Parameter> Parameter;

    public ArrayOfParameter(){
        
    }

    /**
     *
     * @return
     */
    public List<Parameter> getParameter() {
        return Parameter;
    }

    public void setParameter(List<Parameter> Parameter) {
        this.Parameter = Parameter;
    }

    
}
