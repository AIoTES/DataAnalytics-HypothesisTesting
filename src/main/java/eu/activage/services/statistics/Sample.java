package eu.activage.services.statistics;



import eu.activage.services.exceptions.NoObservationFoundException;
import eu.activage.services.exceptions.VariableMixedValueTypeException;
import eu.activage.services.exceptions.VariableWrongValueTypeException;

import java.util.*;
import java.util.stream.Collectors;


/**
 * Created by xschen on 3/5/2017.
 */
public class Sample {
   private final List<Observation> observations = new ArrayList<>();
   private Optional<Boolean> isNumeric = Optional.empty();
   private final Set<String> groups = new HashSet<>();
   private SampleMetaData metaData = new SampleMetaData();


   public void add(Observation observation) {
      if(isNumeric.isPresent()){
         boolean numericOnly = isNumeric.get();
         if(observation.isNumeric() != numericOnly) {
            throw new VariableMixedValueTypeException("sample should only contain ".concat(numericOnly ? "numeric" : "categorical").concat(" values"));
         }
      } else {
         isNumeric = Optional.of(observation.isNumeric());
      }

      groups.add(observation.getGroupId());

      observations.add(observation);
   }

   public boolean isNumeric(){
      if(!isNumeric.isPresent()){
         throw new NoObservationFoundException("No observation is found in the sample");
      }
      return isNumeric.get();
   }

   public boolean isCategorical() {
      return !isNumeric();
   }

   public int countByGroupId(String groupId) {
      return (int)observations.stream().filter(o -> groupId == null || groupId.equals(o.getGroupId())).count();
   }

   public int size(){
      return countByGroupId(null);
   }

   public Observation get(int index) {
      return observations.get(index);
   }


   public double proportion(String successLabel, String groupId) {
      if(isNumeric()) {
         throw new VariableWrongValueTypeException("proportional can only be calculated on categorical variables");
      }
      return (double)observations.stream()
              .filter(o -> groupId == null || groupId.equals(o.getGroupId()))
              .filter(o -> o.getCategoricalValue().equals(successLabel)).count() / countByGroupId(groupId);
   }


   public List<Observation> getObservations() {
      return observations;
   }

   public List<String> groups(){
      return groups.stream().collect(Collectors.toList());
   }


   public SampleMetaData metaData(){
      return metaData;
   }

   public boolean containsTwoNumericalVariables(){
      return observations.get(0).containsTwoNumericalVariables();
   }


   public Map<String, SampleDistribution> sampleDistributionsByGroupId() {
      List<String> groups = groups();

      Map<String, SampleDistribution> sampleDistributionByGroupId = new HashMap<>();
      for(int i=0; i < groups.size(); ++i){
         String groupId = groups.get(i);

         SampleDistribution sampleDistributionGroup = new SampleDistribution(this, groupId);
         sampleDistributionByGroupId.put(groupId, sampleDistributionGroup);
      }
      return sampleDistributionByGroupId;
   }
}
