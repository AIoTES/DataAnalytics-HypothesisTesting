package eu.activage.services.utils;


import lombok.Getter;


/**
 * Created by xschen on 3/5/2017.
 */
@Getter
public class Interval {
   private final double lo;
   private final double hi;

   public Interval(double lo, double hi) {
      this.lo = lo;
      this.hi = hi;
   }

   @Override
   public String toString(){
      return "(" + lo + ", " + hi + ")";
   }


    public double getLo() {
        return lo;
    }

    public double getHi() {
        return hi;
    }
}
