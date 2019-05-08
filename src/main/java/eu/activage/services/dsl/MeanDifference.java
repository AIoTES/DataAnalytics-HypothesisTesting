package eu.activage.services.dsl;


import eu.activage.services.statistics.ConfidenceInterval;
import eu.activage.services.statistics.SamplingDistributionOfSampleMeanDifference;

/**
 * Created by xschen on 8/5/2017.
 */
public class MeanDifference {

   private final SamplingDistributionOfSampleMeanDifference samplingDistributionOfSampleMeanDifference;
   public MeanDifference(SamplingDistributionOfSampleMeanDifference samplingDistributionOfSampleMeanDifference) {
      this.samplingDistributionOfSampleMeanDifference = samplingDistributionOfSampleMeanDifference;
   }
   public ConfidenceInterval confidenceInterval(double significanceLevel){
      return samplingDistributionOfSampleMeanDifference.confidenceInterval(significanceLevel);
   }
}
