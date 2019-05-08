package eu.activage.services.dsl;


import eu.activage.services.statistics.ConfidenceInterval;
import eu.activage.services.statistics.SamplingDistributionOfSampleProportion;

/**
 * Created by xschen on 8/5/2017.
 */
public class Proportion {
   private final SamplingDistributionOfSampleProportion samplingDistributionOfSampleProportion;
   public Proportion(SamplingDistributionOfSampleProportion samplingDistributionOfSampleProportion){
      this.samplingDistributionOfSampleProportion = samplingDistributionOfSampleProportion;
   }

   public ConfidenceInterval confidenceInterval(double confidenceLevel){
      return samplingDistributionOfSampleProportion.confidenceInterval(confidenceLevel);
   }
}
