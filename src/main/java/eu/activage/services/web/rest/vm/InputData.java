package eu.activage.services.web.rest.vm;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Yasar Khan
 *
 */
public class InputData implements Serializable {
	
	private Map<String, Double[]> data;

	public Map<String, Double[]> getData() {
		return data;
	}

	public void setData(Map<String, Double[]> data) {
		this.data = data;
	}
}
