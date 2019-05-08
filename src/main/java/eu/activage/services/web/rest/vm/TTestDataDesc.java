package eu.activage.services.web.rest.vm;



/**
 * 
 * @author Yasar Khan
 *
 */
public class TTestDataDesc {
	
	private String query;
	private TTestSampleData dataDesc;
	private TTestOptions options;
	
	
	public String getQuery() {
		return query;
	}
	
	
	public void setQuery(String query) {
		this.query = query;
	}
	
	
	public TTestSampleData getDataDesc() {
		return dataDesc;
	}
	
	
	public void setDataDesc(TTestSampleData dataDesc) {
		this.dataDesc = dataDesc;
	}
	
	
	public TTestOptions getOptions() {
		return options;
	}
	
	
	public void setOptions(TTestOptions options) {
		this.options = options;
	}

}
