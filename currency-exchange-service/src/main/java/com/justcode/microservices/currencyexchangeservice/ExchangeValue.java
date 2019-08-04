package com.justcode.microservices.currencyexchangeservice;

import java.math.BigDecimal;

public class ExchangeValue {

	private String from;
	private String to;
	private Long id;
	private BigDecimal conversionMultiple;
	
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
	
	
}
