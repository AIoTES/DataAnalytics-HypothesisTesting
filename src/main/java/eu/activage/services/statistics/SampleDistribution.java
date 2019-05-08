package eu.activage.services.statistics;


import eu.activage.services.exceptions.NotImplementedException;
import eu.activage.services.exceptions.VariableWrongValueTypeException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by xschen on 3/5/2017.
 * A sample distribution is an observed distribution of the values that a variable is observed to have for a sample of individuals. We have seen numerous sample distributions.
 */
@Getter
@Setter
public class SampleDistribution {

   private double sampleMean;
   private double sampleSd;
   private double sampleVariance;
   private boolean isNumeric;
   private int sampleSize;

   @Getter(AccessLevel.NONE)
   @Setter(AccessLevel.NONE)
   private double proportion;

   @Getter(AccessLevel.NONE)
   @Setter(AccessLevel.NONE)
   private String successLabel;

   @Setter(AccessLevel.NONE)
   private final String groupId;

   @Getter(AccessLevel.NONE)
   @Setter(AccessLevel.NONE)
   private double sumOfSquares;

   private double firstQuartile;

   private double thirdQuartile;

   private double min;

   private double max;

   private double median;

   public SampleDistribution(Sample sample, String groupId){
      if(!sample.isNumeric()){
         throw new VariableWrongValueTypeException("The constructor can only work on numeric variables");
      }

      this.groupId = groupId;

      isNumeric = true;

      List<Double> values = sample.getObservations().stream()
              .filter(o -> groupId == null || groupId.equals(o.getGroupId()))
              .map(Observation::getX)
              .collect(Collectors.toList());

      values.sort(Double::compare);

      sampleMean = values.stream()
              .reduce((a, b) -> a + b).get() / sample.countByGroupId(groupId);

      sumOfSquares = values.stream()
              .map(o -> Math.pow(o - sampleMean, 2.0))
              .reduce((a, b) -> a + b).get();

      min = values.get(0);

      max = values.get(values.size()-1);

      if(values.size() % 2 == 0) {
         median = values.get(values.size() / 2);
      } else {
         median = (values.get((values.size()-1) / 2) + values.get((values.size()+1) / 2)) / 2;
      }

      firstQuartile = values.get((int)(values.size() * 0.25));

      thirdQuartile = values.get((int)(values.size() * 0.75));


      sampleSize = values.size();

      sampleVariance = sumOfSquares / (sampleSize - 1);

      sampleSd = Math.sqrt(sampleVariance);


   }

   public SampleDistribution(Sample sample, String successLabel, String groupId) {
      if(sample.isNumeric()) {
         throw new VariableWrongValueTypeException("The constructor can only work on categorical variables");
      }

      this.groupId = groupId;

      isNumeric = false;

      sampleMean = sample.countByGroupId(groupId) * sample.proportion(successLabel, groupId);

      this.proportion = sample.proportion(successLabel, groupId);
      sampleVariance =  sample.countByGroupId(groupId) * this.proportion * (1-this.proportion);

      sampleSd = Math.sqrt(sampleVariance);

      sampleSize = sample.countByGroupId(groupId);

      this.successLabel = successLabel;
   }


   public SampleDistribution(double sampleMean, int sampleSize, double sampleSd, String groupId) {
      this.sampleMean = sampleMean;
      this.sampleSize = sampleSize;
      this.sampleSd = sampleSd;
      this.sampleVariance = sampleSd * sampleSd;
      this.sumOfSquares = sampleVariance * (sampleSize - 1);
      this.isNumeric = true;
      this.groupId = groupId;
   }

   public SampleDistribution(String successLabel, double sampleProportion, int sampleSize, String groupId) {
      this.proportion = sampleMean;
      this.successLabel = successLabel;
      this.sampleSize = sampleSize;
      this.sampleVariance = sampleSize * ( 1 - proportion) * proportion;
      this.sampleMean = proportion * sampleSize;
      this.sampleSd = Math.sqrt(sampleVariance);
      this.sumOfSquares = sampleVariance * (sampleSize - 1);
      this.isNumeric = false;
      this.groupId = groupId;
   }


   public double getProportion(){
      if(isNumeric()){
         throw new NotImplementedException();
      }
      return proportion;
   }

   public void setProportion(double p) {
      proportion = p;
   }

   public String getSuccessLabel(){
      if(isNumeric()) {
         throw new NotImplementedException();
      }

      return successLabel;
   }

   public void setSuccessLabel(String successLabel) {
      this.successLabel = successLabel;
   }


   public boolean isCategorical() {
      return !isNumeric();
   }

   public double getSumOfSquares() {
      if(!isNumeric()){
         throw new NotImplementedException();
      }

      return sumOfSquares;
   }

    public double getSampleMean() {
        return sampleMean;
    }

    public void setSampleMean(double sampleMean) {
        this.sampleMean = sampleMean;
    }

    public double getSampleSd() {
        return sampleSd;
    }

    public void setSampleSd(double sampleSd) {
        this.sampleSd = sampleSd;
    }

    public double getSampleVariance() {
        return sampleVariance;
    }

    public void setSampleVariance(double sampleVariance) {
        this.sampleVariance = sampleVariance;
    }

    public boolean isNumeric() {
        return isNumeric;
    }

    public void setNumeric(boolean numeric) {
        isNumeric = numeric;
    }

    public int getSampleSize() {
        return sampleSize;
    }

    public void setSampleSize(int sampleSize) {
        this.sampleSize = sampleSize;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setSumOfSquares(double sumOfSquares) {
        this.sumOfSquares = sumOfSquares;
    }

    public double getFirstQuartile() {
        return firstQuartile;
    }

    public void setFirstQuartile(double firstQuartile) {
        this.firstQuartile = firstQuartile;
    }

    public double getThirdQuartile() {
        return thirdQuartile;
    }

    public void setThirdQuartile(double thirdQuartile) {
        this.thirdQuartile = thirdQuartile;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMedian() {
        return median;
    }

    public void setMedian(double median) {
        this.median = median;
    }
}
