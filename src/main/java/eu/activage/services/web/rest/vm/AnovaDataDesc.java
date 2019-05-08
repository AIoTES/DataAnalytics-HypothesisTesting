package eu.activage.services.web.rest.vm;

public class AnovaDataDesc {

    private String query;
    private InputData dataDesc;
    private AnovaOptions options;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
	
	public InputData getDataDesc() {
		return dataDesc;
	}

	public void setDataDesc(InputData data) {
		this.dataDesc = data;
	}

	public AnovaOptions getOptions() {
		return options;
	}

	public void setOptions(AnovaOptions options) {
		this.options = options;
	}
	

	@Override
    public String toString() {
        return "DataDesc{" +
            "query='" + query + '\'' +
            "dataDesc='" + dataDesc + '\'' +
            "options=" + options.toString() +
            '}';
    }
}
