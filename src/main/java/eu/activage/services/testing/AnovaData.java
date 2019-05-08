package eu.activage.services.testing;

import java.io.InputStream;

/**
 * 
 * @author Yasar Khan
 *
 */
public class AnovaData {
	
	private String dependentVariableName;
	private String independentVariableName;
	private InputStream anovaDataStream;
	
	
	public String getDependentVariableName() {
		return dependentVariableName;
	}
	
	
	public void setDependentVariableName(String dependentVariableName) {
		this.dependentVariableName = dependentVariableName;
	}
	
	
	public String getIndependentVariableName() {
		return independentVariableName;
	}
	
	
	public void setIndependentVariableName(String independentVariableName) {
		this.independentVariableName = independentVariableName;
	}


	public InputStream getAnovaDataStream() {
		return anovaDataStream;
	}


	public void setAnovaDataStream(InputStream anovaDataStream) {
		this.anovaDataStream = anovaDataStream;
	}
	

}
