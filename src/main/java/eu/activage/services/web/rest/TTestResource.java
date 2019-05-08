package eu.activage.services.web.rest;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

import eu.activage.services.testing.TTest;
import eu.activage.services.web.rest.vm.TTestDataDesc;
import eu.activage.services.web.rest.vm.TTestHDataDesc;
import eu.activage.services.web.rest.vm.TTestHypothesisResponse;
import eu.activage.services.web.rest.vm.TTestOneSampleDataDesc;
import eu.activage.services.web.rest.vm.TTestOneSampleHDataDesc;
import eu.activage.services.web.rest.vm.TTestResponse;

/**
 * 
 * @author Yasar Khan
 *
 */

@RestController
@RequestMapping("/api")
public class TTestResource {
	
	private final Logger log = LoggerFactory.getLogger(TTestResource.class);

    private static final String ENTITY_NAME = "ttest";
    
    
    @PostMapping("/ttesttwosample")
    @Timed
    public ResponseEntity<TTestResponse> tTest(@Valid @RequestBody TTestDataDesc dataDesc) {
    	
    	TTestResponse response = new TTestResponse();
    	
    	TTest ttest = new TTest();
    	ttest = ttest.twoSampleT(dataDesc);
    	
    	response.settStatistic(ttest.gettStatistics());
    	response.setpValue(ttest.getpValue());
    	
    	return ResponseEntity.ok()
    			.body(response);
    }
    
    
    @PostMapping("/ttesttwosamplehypothesis")
    @Timed
    public ResponseEntity<TTestHypothesisResponse> tTestHypothesis(@Valid @RequestBody TTestHDataDesc dataDesc) {
    	
    	Boolean rejectNullHypothesis = Boolean.FALSE;
    	
    	TTestHypothesisResponse response = new TTestHypothesisResponse();
    	
    	TTest ttest = new TTest();
    	rejectNullHypothesis = ttest.twoSampleTHypothesis(dataDesc);
    	
    	response.setRejectNullHypothesis(rejectNullHypothesis);
    	
    	return ResponseEntity.ok()
    			.body(response);
    }
    
    
    @PostMapping("/ttestonesample")
    @Timed
    public ResponseEntity<TTestResponse> tTestOneSample(@Valid @RequestBody TTestOneSampleDataDesc dataDesc) {
    	
    	TTestResponse response = new TTestResponse();
    	
    	TTest ttest = new TTest();
    	ttest = ttest.oneSampleT(dataDesc);
    	
    	response.settStatistic(ttest.gettStatistics());
    	response.setpValue(ttest.getpValue());
    	
    	return ResponseEntity.ok()
    			.body(response);
    }
    
    
    @PostMapping("/ttestonesamplehypothesis")
    @Timed
    public ResponseEntity<TTestHypothesisResponse> tTestOneSampleHypothesis(@Valid @RequestBody TTestOneSampleHDataDesc dataDesc) {
    	
    	Boolean rejectNullHypothesis = Boolean.FALSE;
    	
    	TTestHypothesisResponse response = new TTestHypothesisResponse();
    	
    	TTest ttest = new TTest();
    	rejectNullHypothesis = ttest.oneSampleTHypothesis(dataDesc);
    	
    	response.setRejectNullHypothesis(rejectNullHypothesis);
    	
    	return ResponseEntity.ok()
    			.body(response);
    }

}
