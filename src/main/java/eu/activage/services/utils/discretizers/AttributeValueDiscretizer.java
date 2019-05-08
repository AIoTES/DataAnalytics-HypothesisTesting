package eu.activage.services.utils.discretizers;


import eu.activage.services.frame.DataFrame;
import eu.activage.services.frame.DataRow;

/**
 * Created by xschen on 18/8/15.
 */
public interface AttributeValueDiscretizer  {
    int discretize(double value, String index);
    DataRow transform(DataRow tuple);
    DataFrame fitAndTransform(DataFrame frame);
}
