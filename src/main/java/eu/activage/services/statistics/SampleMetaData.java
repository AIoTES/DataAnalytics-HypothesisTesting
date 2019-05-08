package eu.activage.services.statistics;


import lombok.Getter;
import lombok.Setter;


/**
 * Created by xschen on 8/5/2017.
 */
@Getter
@Setter
public class SampleMetaData {

   private boolean randomlySampledOrAssigned = true;
   private boolean sampledWithReplacement = true;
   // true population size, usually unknown and only used when sampled without replacement
   private int truePopulationSize = -1;

    public boolean isRandomlySampledOrAssigned() {
        return randomlySampledOrAssigned;
    }

    public void setRandomlySampledOrAssigned(boolean randomlySampledOrAssigned) {
        this.randomlySampledOrAssigned = randomlySampledOrAssigned;
    }

    public boolean isSampledWithReplacement() {
        return sampledWithReplacement;
    }

    public void setSampledWithReplacement(boolean sampledWithReplacement) {
        this.sampledWithReplacement = sampledWithReplacement;
    }

    public int getTruePopulationSize() {
        return truePopulationSize;
    }

    public void setTruePopulationSize(int truePopulationSize) {
        this.truePopulationSize = truePopulationSize;
    }
}
