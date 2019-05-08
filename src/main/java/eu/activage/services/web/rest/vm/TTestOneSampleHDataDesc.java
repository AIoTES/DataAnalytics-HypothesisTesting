package eu.activage.services.web.rest.vm;



/**
 * 
 * @author Yasar Khan
 *
 */
public class TTestOneSampleHDataDesc {
	
	private String query;
	private TTestOneSampleData dataDesc;
	private TTestOneSampleOptions options;
	
	public String getQuery() {
		return query;
	}
	
	
	public void setQuery(String query) {
		this.query = query;
	}
	
	
	public TTestOneSampleData getDataDesc() {
		return dataDesc;
	}
	
	
	public void setDataDesc(TTestOneSampleData dataDesc) {
		this.dataDesc = dataDesc;
	}


	public TTestOneSampleOptions getOptions() {
		return options;
	}


	public void setOptions(TTestOneSampleOptions options) {
		this.options = options;
	}
	

}
