package eu.activage.services.web.rest.vm;



/**
 * 
 * @author Yasar Khan
 *
 */
public class TTestHDataDesc {
	
	private String query;
	private TTestSampleData dataDesc;
	private TTestHOptions options;
	
	
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
	
	
	public TTestHOptions getOptions() {
		return options;
	}
	
	
	public void setOptions(TTestHOptions options) {
		this.options = options;
	}

}
