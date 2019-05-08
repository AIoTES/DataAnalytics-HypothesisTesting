package eu.activage.services.web.rest.vm;

import java.util.Map;

public class TTestModel {

    private DataDesc dataDesc;
    private TestModelOption options;


    /**
     {
     "dataDesc": {
     "query": "select * from env_sensors where ds = 'DS_GRC'"
     },
     "options": {
     "significanceLevel": 0.5,
     "dataInput": {
     "data": [
     {"sensor": [5.1, 3.5, 1.4, 0.2]},
     {"sensor": [5.8, 4.0, 1.2, 0.2]},
     {"sensor": [5.7, 4.4, 1.5, 0.4]},
     {"sensor": [5.4, 3.9, 1.3, 0.4]},
     {"sensor": [5.1, 3.5, 1.4, 0.3]},
     {"sensor": [5.7, 3.8, 1.7, 0.3]},
     {"sensor": [5.1, 3.8, 1.5, 0.3]},
     {"sensor": [5.4, 3.4, 1.7, 0.2]},
     {"sensor": [5.1, 3.7, 1.5, 0.4]},
     {"sensor": [4.6, 3.6, 1.0, 0.2]}
     ]
     },
     "hypothesis": "dataInput is anomalous"
     }
     }
     */
}
