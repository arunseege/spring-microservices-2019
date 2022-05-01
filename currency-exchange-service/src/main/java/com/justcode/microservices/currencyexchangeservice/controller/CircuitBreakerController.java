package com.justcode.microservices.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-api-default")
	@Retry(name="default")
	public String sampleApi() {
		logger.info("sample api call received");
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", String.class);
		return forEntity.getBody();
	}
	
	@GetMapping("/sample-api-config")
	@Retry(name="sample-api")
	public String sampleApiConfig() {
		logger.info("sample api call received for 5 appempts");
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", String.class);
		return forEntity.getBody();
	}
	
	@GetMapping("/sample-api-fallback")
	@Retry(name="sample-api-fallback", fallbackMethod="hardcodedResponse")
	public String sampleApiConfigFallback() {
		logger.info("sample api call received for 5 appempts");
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", String.class);
		return forEntity.getBody();
	}
	
	@GetMapping("/sample-api-circuitbreaker")
	@CircuitBreaker(name="sample-api-fallback", fallbackMethod="hardcodedResponse")
	public String sampleApiConfigFallbackCircuitBreakeer() {
		logger.info("sample api call received for 5 appempts");
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", String.class);
		return forEntity.getBody();
	}
	
	public String hardcodedResponse(Exception ex) {
		return "fallback response";
	}
	

}
