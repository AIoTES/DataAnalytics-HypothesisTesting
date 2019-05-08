package eu.activage.services.dsl;


import eu.activage.services.statistics.ConfidenceInterval;
import eu.activage.services.statistics.SamplingDistributionOfSampleMean;

/**
 * Created by xschen on 8/5/2017.
 */
public class Mean {

   private final SamplingDistributionOfSampleMean samplingDistributionOfSampleMean;
   public Mean(SamplingDistributionOfSampleMean samplingDistributionOfSampleMean) {
      this.samplingDistributionOfSampleMean = samplingDistributionOfSampleMean;
   }
   public ConfidenceInterval confidenceInterval(double significanceLevel){
      return samplingDistributionOfSampleMean.confidenceInterval(significanceLevel);
   }
}
