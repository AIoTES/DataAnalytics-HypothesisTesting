package eu.activage.services.web.rest;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

import eu.activage.services.web.rest.vm.AnovaDataDesc;
import eu.activage.services.web.rest.vm.AnovaRequestHandler;
import eu.activage.services.web.rest.vm.AnovaResponse;


/**
 * 
 * @author Yasar Khan
 * 
 * Rest Controller for Anova Test
 *
 */
@CrossOrigin(origins = "*", maxAge = 1800, allowedHeaders = "*", exposedHeaders = "Authorization,Link,X-Total-Count", methods = {RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE})
@RestController
@RequestMapping("/api")
public class AnovaResource {
	
	private final Logger log = LoggerFactory.getLogger(AnovaResource.class);

    private static final String ENTITY_NAME = "anova";
    
    @PostMapping("/anova")
    @Timed
    public ResponseEntity<AnovaResponse> anova(@Valid @RequestBody AnovaDataDesc dataDesc) {
    	
    	AnovaRequestHandler handler = new AnovaRequestHandler();
    	
    	AnovaResponse response = handler.handleRequest(dataDesc);
    	
    	return ResponseEntity.ok()
    			.body(response);
    }

}
