package com.justcode.microservices.limitsservice.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("limits-service")
public class Configuration {
	private int maximum;
	private int minimum;
	
	public Configuration() {
		// TODO Auto-generated constructor stub
	}

	public Configuration(int maximum, int minimum) {
		super();
		this.maximum = maximum;
		this.minimum = minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	

}
