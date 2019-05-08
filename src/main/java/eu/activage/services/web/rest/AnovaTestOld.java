package eu.activage.services.web.rest;

import eu.activage.services.dsl.CategoricalToNumericalSampleKie;
import eu.activage.services.dsl.Variable;
import eu.activage.services.frame.DataFrame;
import eu.activage.services.frame.DataQuery;
import eu.activage.services.frame.DataRow;
import eu.activage.services.testing.Anova;
import eu.activage.services.utils.FileUtils;


import java.io.IOException;
import java.io.InputStream;

public class AnovaTestOld {
	/**
    public static void main(String args[]) throws IOException {
        Variable variable1 = new Variable("stress");
        Variable variable2 = new Variable("time");

        CategoricalToNumericalSampleKie kie = variable1.multipleGroupNumericalSample(variable2);

        InputStream inputStream = FileUtils.getResource("anova-sample.csv");
        DataFrame dataFrame = DataQuery.csv(",")
            .from(inputStream)
            .skipRows(1)
            .selectColumn(1).asNumeric().asInput("stress")
            .selectColumn(2).asCategory().asInput("time")
            .build();

        kie.addObservations(dataFrame);
        
        dataFrame.stream().forEach(r -> System.out.println("row: " + r));
        

        Anova test = kie.test4Independence();

        System.out.println(test.getSummary());
        
        
        
//        Variable variable1 = new Variable("Age");
//        Variable variable2 = new Variable("LiveChannel");
//
//        CategoricalToNumericalSampleKie kie = variable1.multipleGroupNumericalSample(variable2);
//
//        InputStream inputStream = FileUtils.getResource("contraception.csv");
//        DataFrame dataFrame = DataQuery.csv(",")
//            .from(inputStream)
//            .skipRows(1)
//            .selectColumn(5).asNumeric().asInput("Age")
//            .selectColumn(4).asCategory().asInput("LiveChannel")
//            .build();
//
//        kie.addObservations(dataFrame);
//        
//        dataFrame.stream().forEach(r -> System.out.println("row: " + r));
//        for(DataRow r : dataFrame) {
//         System.out.println("row: "+ r);
//        }
//
//        Anova test = kie.test4Independence();
//
//        System.out.println(test.getSummary());
    } */
}
