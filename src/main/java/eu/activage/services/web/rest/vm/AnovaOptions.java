package eu.activage.services.web.rest.vm;



/**
 * 
 * @author Yasar Khan
 *
 */
public class AnovaOptions {
	
	private String depenedentVariable;
	private String indepenedentVariable;	
	
	
	public String getDepenedentVariable() {
		return depenedentVariable;
	}
	
	
	public void setDepenedentVariable(String depenedentVariable) {
		this.depenedentVariable = depenedentVariable;
	}
	
	
	public String getIndepenedentVariable() {
		return indepenedentVariable;
	}
	
	
	public void setIndepenedentVariable(String indepenedentVariable) {
		this.indepenedentVariable = indepenedentVariable;
	}
	
	
	@Override
    public String toString() {
        return "AnovaOption{" +
            ", depenedentVariable='" + depenedentVariable + '\'' +
            ", indepenedentVariable='" + indepenedentVariable + '\'' +
            '}';
    }

}
