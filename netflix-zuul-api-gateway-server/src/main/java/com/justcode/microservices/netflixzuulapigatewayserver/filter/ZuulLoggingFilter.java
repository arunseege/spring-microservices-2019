package com.justcode.microservices.netflixzuulapigatewayserver.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.protocol.RequestContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter{

	/*to log info from request i need logger*/
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean shouldFilter() {
		// should this filter be executed or not ;; true means filter must execute for every request
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		//actual logic of interception goes 
		//here i want to log details of the request
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("request -> {} request uri is -> {}",request,request.getRequestURI());
		return null;
	}

	@Override
	public String filterType() {
		// it tells when should filter be executed (before req. is executed or after
		// request has executed or we want to filter only error request)
		// error req. means request that caused error to happen)
		
		return "pre";
	}

	@Override
	public int filterOrder() {
		// if we have multiple filters like zuulloggingfilter ,zuulsecurityfilter
		// etc we can set priority order between them
		return 1;
	}

}
