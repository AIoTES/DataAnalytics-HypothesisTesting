/** 
* Copyright 2020 National University of Ireland Galway 
* 
* See the NOTICE file distributed with this work for additional information
* regarding copyright ownership.
*
* Licensed under the EUPL, Version 1.2 or – as soon the European Commission 
* approves - subsequent versions of the EUPL (the "Licence"); 
* You may not use this work except in compliance with the Licence. 
* You may obtain a copy of the Licence at: 
*
*     https://joinup.ec.europa.eu/software/page/eupl 
*
* Unless required by applicable law or agreed to in writing, software 
* distributed under the Licence is distributed on an "AS IS" basis, 
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
* See the Licence for the specific language governing permissions and 
* limitations under the Licence. 
*/

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
