package eu.activage.services.testing;



import eu.activage.services.enums.DistributionFamily;
import eu.activage.services.misc.Simulation;
import eu.activage.services.utils.Count;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.math3.distribution.NormalDistribution;

import java.util.List;


/**
 * Created by xschen on 3/5/2017.
 * H_0: p_null = p_null
 *    that is proportion p_null is p_null
 *
 * H_A: p_null != p_null
 *    that is the true proportion p_null is not equal p_null
 */
@Getter
@Setter
public class TestingOnProportion {

   // point estimate of proportion (observed value)
   private double pHat;

   // null value of proportion (value assumed to be the true proportion in the null hypothesis)
   private double pNull;

   // sample size
   private int sampleSize;

   // test statistic under null hypothesis, defined only if normal distribution holds for the sample proportion under CLT
   private double testStatistic;

   // probability of observed event or more extreme cases assuming the null hypothesis is true
   private double pValueOneTail;
   private double pValueTwoTails;

   private DistributionFamily distributionFamily;

   private double significanceLevel;

   private int simulationCount = 100;

   private String successLabel = "";


   // pHat: observed sample proportion
   // p_null: expected proportion proposed by the null hypothesis
   public TestingOnProportion(){

   }

   public void run(String successLabel, double pHat, int sampleSize, double p){
      run(successLabel, pHat, sampleSize, p, 0.05);
   }


   /**
    * The method return the p-value for both one-tail and two-tails testing of proportion of success for a categorical variable
    * @param successLabel the label for the "success" of proportion
    * @param pHat the point estimate $p_{hat}$ of sample proportion $p_{bar}$
    * @param sampleSize the sample size of sample drawn from the population
    * @param pNull the null value $p_0$ for true $p$ of the population under $H_0$
    * @param significanceLevel the significance level $alpha$ which is usually 0.05
    */
   public void run(String successLabel, double pHat, int sampleSize, double pNull, double significanceLevel) {

      this.pHat = pHat;
      this.pNull = pNull;
      this.successLabel = successLabel;

      this.sampleSize = sampleSize;

      int successCount = (int)(sampleSize * pNull);
      int failureCount = (int)(sampleSize * (1-pNull));

      if(successCount < 10 || failureCount < 10) {
         distributionFamily = DistributionFamily.SimulationOnly;
         List<Double> proportions = Simulation.binomial(pNull, sampleSize, simulationCount);

         double cp = 0;
         if(pHat > 0.5) {
            cp = Count.cumulativeProbability(proportions, pHat);
         } else {
            cp = 1 - Count.cumulativeProbability(proportions, pHat);
         }

         pValueOneTail = 1 - cp;
         pValueTwoTails = pValueOneTail * 2;


      } else {
         // standard error of the sample proportion under null hypothesis
         double standardError = calculateStandardError(pNull, sampleSize);

         double Z = (pHat - pNull) / standardError;

         NormalDistribution distribution = new NormalDistribution(0, 1.0);
         double cp = distribution.cumulativeProbability(Math.abs(Z));
         pValueOneTail = 1 - cp;
         pValueTwoTails = pValueOneTail * 2;

         distributionFamily = DistributionFamily.Normal;
         testStatistic = Z;
      }

      this.significanceLevel = significanceLevel;
   }

   private double calculateStandardError(double p, double n ){
      return Math.sqrt(p * (1-p) / n);
   }

   /**
    * The method reject null hypothesis if the p-value calculated from the sample is smaller than the significance level
    * @param significanceLevel the significance level, usually about 0.05
    * @param twoTails true if the testing is two tails; false otherwise
    * @return true if the null hypothesis H_0 is rejected; false if H_0 fails to be rejected
    */
   public boolean willRejectH0(double significanceLevel, boolean twoTails) {
      if(twoTails){
         return pValueTwoTails < significanceLevel;
      } else {
         return pValueOneTail < significanceLevel;
      }
   }

   public String getSummary() {
      StringBuilder sb = new StringBuilder();

      sb.append("Sample proportion: ").append(pHat).append(" Sample size: ").append(sampleSize);
      sb.append("\nDistribution: ").append(distributionFamily);
      sb.append("\np-value (one-tail): ").append(pValueOneTail);
      sb.append("\np-value (two-tails): ").append(pValueTwoTails);

      if(significanceLevel > 0) {
         sb.append("\nSuppose significance level is ").append(significanceLevel);
         sb.append("\n\t1) population proportion of \"").append(successLabel).append("\" is likely ").append(pValueOneTail < significanceLevel ? "not" : "").append(" to be ").append(pNull).append(" under one-tail test");
         sb.append("\n\t2) population proportion is \"").append(successLabel).append("\" is likely ").append(pValueTwoTails < significanceLevel ? "not" : "").append(" to be ").append(pNull).append(" under two-tails test");
      }

      return sb.toString();
   }

   @Override
   public String toString(){
      return getSummary();
   }

   public void report(){
      System.out.println(toString());
   }



}
