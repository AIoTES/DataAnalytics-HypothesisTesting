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
