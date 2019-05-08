package eu.activage.services.web.rest;

import eu.activage.services.dsl.Mean;
import eu.activage.services.dsl.NumericalSampleKie;
import eu.activage.services.dsl.Variable;
import eu.activage.services.statistics.ConfidenceInterval;
import eu.activage.services.testing.TestingOnValue;

public class TTestDemo {
    /**
    public static void main(String args[]) {
        Variable variable = new Variable("Amount");
        NumericalSampleKie kie = variable.numericalSample();
        kie.addObservations(new double[] { 0.2, 0.4, 0.6, 0.12, 0.9, 0.13, -0.12, -0.55, 0.5});

        Mean mean = kie.mean();
        double confidenceLevel = 0.95;
        ConfidenceInterval confidenceInterval = mean.confidenceInterval(confidenceLevel);

        System.out.println("sample.mean: " + kie.getSampleMean());
        System.out.println("sample.sd: " + kie.getSampleSd());
        System.out.println("sample.size: " + kie.getSampleSize());
        System.out.println("sample.median: " + kie.getSampleMedian());
        System.out.println("sample.max: " + kie.getSampleMax());
        System.out.println("sample.min: " + kie.getSampleMin());
        System.out.println("sample.1st.quartile: " + kie.getSampleFirstQuartile());
        System.out.println("sample.3rd.quartile: " + kie.getSampleThirdQuartile());

        System.out.println("sampling distribution: " + kie.getSamplingDistribution());

        System.out.println("confidence interval for Amount: " + confidenceInterval);




        double expected_mean = 0.5;
        TestingOnValue test = kie.test4MeanEqualTo(expected_mean);

        System.out.println("sampling distribution: " + test.getDistributionFamily());
        System.out.println("test statistic: " + test.getTestStatistic());
       System.out.println("p-value (one-tail): " + test.getpValueOneTail());
        System.out.println("p-value (two-tails): " + test.getpValueTwoTails());

    }
   */

}
