package eu.activage.services.testing;

import eu.activage.services.dsl.CategoricalToNumericalSampleKie;
import eu.activage.services.dsl.Variable;
import eu.activage.services.frame.DataFrame;
import eu.activage.services.frame.DataQuery;

/**
 * 
 * @author Yasar Khan
 *
 */
public class AnovaTest {
	
	
	public Anova performOneWayAnova(AnovaData anovaData) {
		
		String depenedentVariableName = anovaData.getDependentVariableName();
		String independentVariableName = anovaData.getIndependentVariableName();
		
		Variable depenedentVariable = new Variable(depenedentVariableName);
		Variable independentVariable = new Variable(independentVariableName);
		
		
		CategoricalToNumericalSampleKie kie = depenedentVariable.multipleGroupNumericalSample(independentVariable);
		
		DataFrame dataFrame = DataQuery.csv(",")
	            .from(anovaData.getAnovaDataStream())
	            .skipRows(0)
	            .selectColumn(0).asNumeric().asInput(depenedentVariableName)
	            .selectColumn(1).asCategory().asInput(independentVariableName)
	            .build();

	        kie.addObservations(dataFrame);
	        
//	        dataFrame.stream().forEach(r -> System.out.println("row: " + r));
	        

	        Anova test = kie.test4Independence();

	        return test;
	}
	
	
	
	/**
	public static void main(String args[]) {
		
		AnovaData anovaData = new AnovaData();
		
		anovaData.setDependentVariableName("stress");
		anovaData.setIndependentVariableName("time");
		
		try {
			InputStream anovaDataStream = FileUtils.getResource("anova-sample.csv");
			anovaData.setAnovaDataStream(anovaDataStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		AnovaTest anovaTest = new AnovaTest();
		Anova test = anovaTest.performOneWayAnova(anovaData);
		
		System.out.println(test.getSummary());
	}
	*/

}
