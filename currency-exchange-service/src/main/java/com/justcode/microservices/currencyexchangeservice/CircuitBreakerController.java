package com.justcode.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.micrometer.core.ipc.http.HttpSender.Response;

@RestController
public class CircuitBreakerController {
	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

	@GetMapping("sample-api-retry")
	//@Retry(name="default")
	@Retry(name="sample-api")
	public String sampleApi() {
		logger.info("sample api retry call received");
		// for retry = default ,it will retry for 3 times,if failed all 3 times only then it would return error
		// back
		//how to configure specific number of retries
		
		ResponseEntity<String> forEntity =new  RestTemplate().getForEntity("http://localhost:8080/some-dummy-url",String.class);
		return forEntity.getBody();
	}
	
	@GetMapping("sample-api-fallback")
	//@Retry(name="default")
	@Retry(name="sample-api-fallback", fallbackMethod="hardcodedResponse")
	public String sampleApiFallback() {
		logger.info("sample api retry call received");
		// for retry = default ,it will retry for 3 times,if failed all 3 times only then it would return error
		// back
		//how to configure specific number of retries
		
		ResponseEntity<String> forEntity =new  RestTemplate().getForEntity("http://localhost:8080/some-dummy-url",String.class);
		return forEntity.getBody();
	}
	
	@GetMapping("sample-api-circuitbreaker")
	//@Retry(name="default")
	@CircuitBreaker(name="default", fallbackMethod="hardcodedResponse")
	public String sampleApiCircuitBreaker() {
		logger.info("sample api retry call received");
		// for retry = default ,it will retry for 3 times,if failed all 3 times only then it would return error
		// back
		//how to configure specific number of retries
		
		ResponseEntity<String> forEntity =new  RestTemplate().getForEntity("http://localhost:8080/some-dummy-url",String.class);
		return forEntity.getBody();
	}
	
	public String hardcodedResponse(Exception ex) {
		return "fallback response";
	}
}
