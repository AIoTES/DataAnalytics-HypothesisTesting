package eu.activage.services.testing;



import eu.activage.services.enums.DistributionFamily;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.distribution.TDistribution;


/**
 * Created by xschen on 4/5/2017.
 *
 * Hypothesis for difference between two difference population using samples from them
 * H_0: mu_1 == mu_2
 *   in other words values are not different for group1 and group 2
 *
 * H_A: mu_1 != mu_2
 *   in other words values are different for group1 and group 2
 */
@Getter
@Setter
public class TestingOnValueDifference {

   // point estimate of sample mean in group 1
   private double xHat1;

   // point estimate of sample mean in group 2
   private double xHat2;

   // sample standard deviation in group 1
   private double s1;

   // sample standard deviation in group 2
   private double s2;

   // sample size for group 1
   private int n1;

   // sample size for group 2
   private int n2;

   // test statistic
   private double testStatistic;

   // the standard error of the sampling distribution for the sample difference
   private double SE;

   // the probability of observed or more extreme cases assume the null hypothesis is true
   private double pValueOneTail;
   private double pValueTwoTails;

   private double df;

   private DistributionFamily distributionFamily;

   private double significanceLevel = 0.001;

   public TestingOnValueDifference(){

   }


   /**
    * The method calculates the p-value for both one-tail and two-tails testing of values from two different population (i.e., groups)
    * @param xHat1 the point estimate of the sample mean for population 1
    * @param xHat2 the point estimate of the sample mean for population 2
    * @param s1 the point estimate of the sample standard deviation for population 1
    * @param s2 the point estimate of the sample standard deviation for population 2
    * @param n1 the sample size of sample drawn from population 1
    * @param n2 the sample size of sample drawn from population 2
    */
   public void run(double xHat1,double xHat2, double s1, double s2, int n1, int n2){
      this.xHat1 = xHat1;
      this.xHat2 = xHat2;
      this.s1 = s1;
      this.s2 = s2;
      this.n1 = n1;
      this.n2 = n2;

      SE = Math.sqrt(s1 * s1 / n1 + s2 * s2 / n2);

      df = Math.min(n1-1, n2-1);

      double nullValue = 0;
      if(n1 < 30 || n2 < 30) {

         double t_df = ((xHat1 - xHat2) - nullValue) / SE;

         TDistribution distribution = new TDistribution(df);
         double cp = distribution.cumulativeProbability(Math.abs(t_df));
         pValueOneTail = 1 - cp;
         pValueTwoTails = pValueOneTail * 2;
         testStatistic = t_df;
         distributionFamily = DistributionFamily.StudentT;
      } else {
         double Z = ((xHat1 - xHat2) - nullValue) / SE;
         NormalDistribution distribution = new NormalDistribution(0, 1.0);
         double cp = distribution.cumulativeProbability(Math.abs(Z));
         pValueOneTail = 1 - cp;
         pValueTwoTails = pValueOneTail * 2;
         testStatistic = Z;
         distributionFamily = DistributionFamily.Normal;
      }

   }

   public String getSummary(){
      StringBuilder sb = new StringBuilder();
      sb.append("group 1: sample mean: ").append(xHat1).append(" sample sd: ").append(s1).append(" sample size: ").append(n1);
      sb.append("\ngroup 2: sample mean: ").append(xHat2).append(" sample sd: ").append(s2).append(" sample size: ").append(n2);

      sb.append("\nSE of sample difference distribution: ").append(SE);

      if(distributionFamily == DistributionFamily.StudentT) {
         sb.append("\ndegrees of freedom: ").append(df);
      }

      sb.append("\nDistribution is ").append(distributionFamily);
      sb.append("\ntest statistic: ").append(testStatistic);
      sb.append("\np-value (one-tail): ").append(pValueOneTail);
      sb.append("\np-value (two-tail): ").append(pValueTwoTails);

      if(significanceLevel > 0) {
         sb.append("\nSuppose significance level is ").append(significanceLevel).append(", it is possible that:");
         sb.append("\n\t1) There is ").append(pValueOneTail < significanceLevel ? "not " : "").append("difference between group1 and group2").append(" under one-tail test");
         sb.append("\n\t2) There is ").append(pValueTwoTails < significanceLevel ? "not " : "").append("difference between group1 and group2").append(" under two-tails test");
      }

      return sb.toString();
   }

   @Override
   public String toString(){
      return getSummary();
   }


   public void report() {
      System.out.println(toString());
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
}
