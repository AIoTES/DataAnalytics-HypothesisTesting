/** 
* Copyright 2020 National University of Ireland Galway 
* 
* See the NOTICE file distributed with this work for additional information
* regarding copyright ownership.
*
* Licensed under the EUPL, Version 1.2 or – as soon the European Commission 
* approves - subsequent versions of the EUPL (the "Licence"); 
* You may not use this work except in compliance with the Licence. 
* You may obtain a copy of the Licence at: 
*
*     https://joinup.ec.europa.eu/software/page/eupl 
*
* Unless required by applicable law or agreed to in writing, software 
* distributed under the Licence is distributed on an "AS IS" basis, 
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
* See the Licence for the specific language governing permissions and 
* limitations under the Licence. 
*/

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
