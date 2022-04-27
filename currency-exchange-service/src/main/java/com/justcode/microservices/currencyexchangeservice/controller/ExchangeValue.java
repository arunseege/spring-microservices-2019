package com.justcode.microservices.currencyexchangeservice.controller;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class ExchangeValue {
	@Id
	private Long id;
	@Column(name="currency_from")
	private String from;
	@Column(name="currency_to")
	private String to;	
	private BigDecimal conversionMultiple;
	private int port;
	private String environment;
	
	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public ExchangeValue() {
	}
	
	public ExchangeValue(String from, String to, Long id, BigDecimal conversionMultiple) {
		super();
		this.from = from;
		this.to = to;
		this.id = id;
		this.conversionMultiple = conversionMultiple;
	}
	public String getFrom() {
		return from;
	}
	public String getTo() {
		return to;
	}
	public Long getId() {
		return id;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	
}
