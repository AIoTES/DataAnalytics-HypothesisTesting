package eu.activage.services.dsl;


import eu.activage.services.statistics.ConfidenceInterval;
import eu.activage.services.statistics.SamplingDistributionOfSampleProportionDifference;

/**
 * Created by xschen on 8/5/2017.
 */
public class ProportionDifference {
   private final SamplingDistributionOfSampleProportionDifference samplingDistributionOfSampleProportionDifference;
   public ProportionDifference(SamplingDistributionOfSampleProportionDifference samplingDistributionOfSampleProportionDifference){
      this.samplingDistributionOfSampleProportionDifference = samplingDistributionOfSampleProportionDifference;
   }

   public ConfidenceInterval confidenceInterval(double confidenceLevel){
      return samplingDistributionOfSampleProportionDifference.confidenceInterval(confidenceLevel);
   }
}
