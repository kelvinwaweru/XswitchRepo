
package ke.co.tracom.main;

/**
 *
 * @author kelvin
 */
public class Xswtch_Parameter implements java.io.Serializable {

    private long tableIndex;
    private String paramName;
    private String paramValue;
    private String paramMisc;

    public Xswtch_Parameter() {
    }

    public long getTableIndex() {
        return tableIndex;
    }

    public void setTableIndex(long tableIndex) {
        this.tableIndex = tableIndex;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getParamMisc() {
        return paramMisc;
    }

    public void setParamMisc(String paramMisc) {
        this.paramMisc = paramMisc;
    }

}
