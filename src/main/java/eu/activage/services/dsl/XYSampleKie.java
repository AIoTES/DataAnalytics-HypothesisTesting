package eu.activage.services.dsl;


import eu.activage.services.frame.DataFrame;
import eu.activage.services.frame.DataRow;
import eu.activage.services.statistics.Observation;
import eu.activage.services.statistics.Sample;
import eu.activage.services.statistics.SampleLinearRegression;
import eu.activage.services.testing.Anova4Regression;

/**
 * Created by xschen on 12/5/2017.
 */
public class XYSampleKie {
   private final Variable varX;
   private final Variable varY;
   private final Sample sample = new Sample();

   public XYSampleKie(Variable varX, Variable varY){
      this.varX = varX;
      this.varY = varY;
   }

   public XYSampleKie addObservation(double x, double y){
      Observation observation = new Observation();
      observation.setX(x);
      observation.setY(y);
      sample.add(observation);
      return this;
   }

   public SampleLinearRegression model(){
      return new SampleLinearRegression(sample);
   }

   public Anova4Regression test4Independence() {
      return new Anova4Regression(sample);
   }


   public void addObservations(DataFrame dataFrame) {
      for(int i=0; i < dataFrame.rowCount(); ++i){
         DataRow row = dataFrame.row(i);
         double x = row.getCell(varX.getName());
         double y = row.getTargetCell(varY.getName());
         addObservation(x, y);
      }
   }
}
