package com.justcode.microservices.limitsservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsConfigurationController {
	
 @Autowired(required=true)
 private  Configuration configuration;
 
	@GetMapping("/limits")
	public LimitsConfiguration retrieveLimitsFromConfigurations() {
		System.out.println("entered controller");
		return new LimitsConfiguration(configuration.getMaximum(),configuration.getMinimum());
	}
	
	@GetMapping("/fault-tolerance-example")
	@HystrixCommand(fallbackMethod="fallbackRetrieveConfiguration")
	public LimitsConfiguration retrieveConfigurations() {
		System.out.println("entered hystrix controller");
		throw new RuntimeException("not available");
	}
	
	public LimitsConfiguration fallbackRetrieveConfiguration() {
		return new LimitsConfiguration(999, 9);
	}
}
