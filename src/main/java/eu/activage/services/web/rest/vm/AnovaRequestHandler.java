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

import java.io.ByteArrayInputStream;
import java.util.Map;
import java.util.Set;

import eu.activage.services.testing.Anova;
import eu.activage.services.testing.AnovaData;
import eu.activage.services.testing.AnovaTest;

/**
 * 
 * @author Yasar Khan
 *
 */
public class AnovaRequestHandler {
	
	
	public AnovaResponse handleRequest(AnovaDataDesc requestData) {
		
		
		InputData inputData = requestData.getDataDesc();
		AnovaOptions options = requestData.getOptions();
		
		String csvData = getCSVData(inputData);
		
		AnovaData anovaData = new AnovaData();
		anovaData.setAnovaDataStream(new ByteArrayInputStream(csvData.getBytes()));
		anovaData.setDependentVariableName(options.getDepenedentVariable());
		anovaData.setIndependentVariableName(options.getIndepenedentVariable());
		
		AnovaTest anovaTest = new AnovaTest();
		Anova anova = anovaTest.performOneWayAnova(anovaData);
		
		AnovaResponse response = new AnovaResponse();
		response.setfStatistic(anova.getF());
		response.setpValue(anova.getpValue());
		
		return response;
	}
	
	
	public String getCSVData(InputData inputData) {
		
		String csvData = "";
		
		Map<String, Double[]> inputDataMap = inputData.getData();
		
		Set<String> levels = inputDataMap.keySet(); 
		
		for (String level : levels) {
			
			Double dataArray[] = inputDataMap.get(level);
			
			for (int i=0; i<dataArray.length; i++) {
				csvData += dataArray[i] + "," + level + System.lineSeparator();
			}
			
		}
		
		return csvData;
	}

}
