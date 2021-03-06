package eu.activage.services.dsl;


import eu.activage.services.frame.DataFrame;
import eu.activage.services.frame.DataRow;
import eu.activage.services.statistics.Observation;
import eu.activage.services.statistics.Sample;
import eu.activage.services.statistics.SampleDistribution;
import eu.activage.services.statistics.SamplingDistributionOfSampleMeanDifference;
import eu.activage.services.testing.TestingOnValueDifference;

/**
 * Created by xschen on 11/5/2017.
 */
public class TwoGroupNumericalSampleKie {
   private final Variable variable;
   private final Variable groupVariable;
   private Sample sample = new Sample();

   private final String group1Id;
   private final String group2Id;

   private double sample1Mean;
   private double sample1Sd;
   private int sample1Size;

   private double sample2Mean;
   private double sample2Sd;
   private int sample2Size;

   private SampleDistribution sample1Distribution = null;
   private SampleDistribution sample2Distribution = null;

   private SamplingDistributionOfSampleMeanDifference samplingDistributionOfSampleMeanDifference = null;

   public TwoGroupNumericalSampleKie(Variable variable, Variable groupVariable, String group1Id, String group2Id) {
      this.variable = variable;
      this.groupVariable = groupVariable;

      this.group1Id = group1Id;
      this.group2Id = group2Id;
   }

   public TwoGroupNumericalSampleKie fromSampleDistributions(double sample1Mean, double sample2Mean, double sample1Sd, double sample2Sd, int sample1Size, int sample2Size) {

      this.sample = null;
      this.sample1Mean = sample1Mean;
      this.sample1Size = sample1Size;
      this.sample1Sd = sample1Sd;

      this.sample2Mean = sample2Mean;
      this.sample2Size = sample2Size;
      this.sample2Sd = sample2Sd;

      sample1Distribution = new SampleDistribution(sample1Mean, sample1Size, sample1Sd, group1Id);
      sample2Distribution = new SampleDistribution(sample2Mean, sample2Size, sample2Sd, group2Id);
      samplingDistributionOfSampleMeanDifference = new SamplingDistributionOfSampleMeanDifference(
              sample1Mean,
              sample2Mean,
              sample1Sd,
              sample2Sd,
              sample1Size,
              sample2Size,
              group1Id,
              group2Id);
      return this;
   }

   public TwoGroupNumericalSampleKie addObservation(double value, String groupId){
      if(sample == null) {
         throw new RuntimeException("distribution is already provided, cannot add observation");
      }

      Observation observation = new Observation();
      observation.setX(value);
      observation.setGroupId(groupId);
      sample.add(observation);

      if(groupId.equals(group1Id)) {
         sample1Distribution = null;
      }
      if(groupId.equals(group2Id)) {
         sample2Distribution = null;
      }
      samplingDistributionOfSampleMeanDifference = null;

      return this;
   }

   private SampleDistribution getGroup1SampleDistribution(){
      if(sample1Distribution == null) {
         sample1Distribution = new SampleDistribution(sample, group1Id);
      }
      return sample1Distribution;
   }

   private SampleDistribution getGroup2SampleDistribution(){
      if(sample2Distribution == null) {
         sample2Distribution = new SampleDistribution(sample, group2Id);
      }
      return sample2Distribution;
   }

   public SamplingDistributionOfSampleMeanDifference getSamplingDistribution(){
      if(samplingDistributionOfSampleMeanDifference == null) {
         samplingDistributionOfSampleMeanDifference = new SamplingDistributionOfSampleMeanDifference(getGroup1SampleDistribution(),
                 getGroup2SampleDistribution());
      }
      return samplingDistributionOfSampleMeanDifference;
   }

   public MeanDifference difference(){
      return new MeanDifference(getSamplingDistribution());
   }

   private String group1Id(){
      return group1Id;
   }

   private String group2Id(){
      return group2Id;
   }

   public TestingOnValueDifference test4GroupDifference() {
      if(sample != null) {
         TestingOnValueDifference test = new TestingOnValueDifference();
         SampleDistribution distribution1 = getGroup1SampleDistribution();
         SampleDistribution distribution2 = getGroup2SampleDistribution();
         double xHat1 = distribution1.getSampleMean();
         double sd1 = distribution1.getSampleSd();
         int n1 = distribution1.getSampleSize();
         double xHat2 = distribution2.getSampleMean();
         double sd2 = distribution2.getSampleSd();
         int n2 = distribution2.getSampleSize();
         test.run(xHat1, xHat2, sd1, sd2, n1, n2);
         return test;
      } else {
         TestingOnValueDifference test = new TestingOnValueDifference();
         test.run(sample1Mean, sample2Mean, sample1Sd, sample2Sd, sample1Size, sample2Size);
         return test;
      }
   }


   public void addObservations(DataFrame dataFrame) {
      for(int i=0; i < dataFrame.rowCount(); ++i){
         DataRow row = dataFrame.row(i);
         String groupId = row.getCategoricalCell(groupVariable.getName());
         if(groupId.equals(group1Id) || groupId.equals(group2Id)){
            double value = row.getCell(variable.getName());
            addObservation(value, groupId);
         }
      }
   }
   
   public double getGroup1SampleMean(){
      return getGroup1SampleDistribution().getSampleMean();
   }
   
   public double getGroup1SampleSd(){
      return getGroup1SampleDistribution().getSampleSd();
   }
   
   public double getGroup1SampleSize(){
      return getGroup1SampleDistribution().getSampleSize();
   }

   public double getGroup2SampleMean(){
      return getGroup2SampleDistribution().getSampleMean();
   }

   public double getGroup2SampleSd(){
      return getGroup2SampleDistribution().getSampleSd();
   }

   public double getGroup2SampleSize(){
      return getGroup2SampleDistribution().getSampleSize();
   }


   public double getGroup1SampleMin() { return getGroup1SampleDistribution().getMin(); }

   public double getGroup1SampleMax() { return getGroup1SampleDistribution().getMax(); }

   public double getGroup1SampleMedian() { return getGroup1SampleDistribution().getMedian(); }

   public double getGroup1SampleFirstQuartile() { return getGroup1SampleDistribution().getFirstQuartile(); }

   public double getGroup1SampleThirdQuartile() { return getGroup1SampleDistribution().getThirdQuartile(); }

   public double getGroup2SampleMin() { return getGroup2SampleDistribution().getMin(); }

   public double getGroup2SampleMax() { return getGroup2SampleDistribution().getMax(); }

   public double getGroup2SampleMedian() { return getGroup2SampleDistribution().getMedian(); }

   public double getGroup2SampleFirstQuartile() { return getGroup2SampleDistribution().getFirstQuartile(); }

   public double getGroup2SampleThirdQuartile() { return getGroup2SampleDistribution().getThirdQuartile(); }
}
