package com.justcode.microservices.limitsservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {
	
 @Autowired(required=true)
 private  Configuration configuration;
 
	@GetMapping("/limits")
	public LimitsConfiguration retrieveLimitsFromConfigurations() {
		System.out.println("entered controller");
		return new LimitsConfiguration(configuration.getMaximum(),configuration.getMinimum());
	}
}
