package eu.activage.services.dsl;


import eu.activage.services.frame.DataFrame;
import eu.activage.services.frame.DataRow;
import eu.activage.services.statistics.ContingencyTable;
import eu.activage.services.statistics.Observation;
import eu.activage.services.statistics.Sample;
import eu.activage.services.testing.ChiSquareTest;

/**
 * Created by xschen on 12/5/2017.
 */
public class CategoricalToCategoricalSampleKie {
   private final Variable variable;
   private final Variable groupVariable;

   private Sample sample;
   private ContingencyTable contingencyTable;

   public CategoricalToCategoricalSampleKie(Variable variable, Variable groupVariable){
      this.variable = variable;
      this.groupVariable = groupVariable;
   }

   public CategoricalToCategoricalSampleKie addObservation(String value, String groupId){
      if(sample == null){
         sample = new Sample();
      }
      Observation observation = new Observation();
      observation.setCategory(value);
      observation.setGroupId(groupId);
      sample.add(observation);
      contingencyTable = null;
      return this;
   }

   public CategoricalToCategoricalSampleKie fromContingencyTable(ContingencyTable table){
      contingencyTable = table;
      return this;
   }

   public ChiSquareTest test4Independence(){
      if(sample != null){

         return new ChiSquareTest().run(getOrCreateContingencyTable());
      } else {
         return new ChiSquareTest().run(contingencyTable);
      }
   }

   public ContingencyTable getOrCreateContingencyTable(){
      if(contingencyTable == null) {
         if (sample != null) {
            contingencyTable = new ContingencyTable(sample);
         }
      }
      return contingencyTable;
   }


   public void addObservations(DataFrame dataFrame) {
      for(int i=0; i < dataFrame.rowCount(); ++i){
         DataRow row = dataFrame.row(i);
         String value = row.getCategoricalCell(variable.getName());
         String groupId = row.getCategoricalCell(groupVariable.getName());
         addObservation(value, groupId);
      }
   }
}
