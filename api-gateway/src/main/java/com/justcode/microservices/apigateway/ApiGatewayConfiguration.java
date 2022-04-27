package com.justcode.microservices.apigateway;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	@Bean
	public RouteLocator  gatewayRouter(RouteLocatorBuilder builder) {
		
		 //return builder.routes().build();// this is when we not customizing routes
		//ctrl+1 to create local variable
		//ctrl+o to organize imports
		
		/*if req comes to /get we have to redirect to specific uri
		 Function<PredicateSpec, Buildable<Route>> routeFunction
		= p -> p.path("/get")
		.filters(f -> f.addRequestHeader("MyHeader", "MyURI")
				.addRequestParameter("Param", "MyValue"))
		.uri("http://httpbin.org:80"); 
		  
		  
		  return builder.routes().
				route(routeFunction).build();
		 */
		return builder.routes().
				route(p -> p.path("/get")
				.filters(f -> f.addRequestHeader("MyHeader", "MyURI")
						.addRequestParameter("Param", "MyValue"))
				.uri("http://httpbin.org:80"))
				.route(p -> p.path("/currency-exchange/**").uri("lb://currency-exchange-service"))
				.route(p -> p.path("/currency-conversion-feign/**").uri("lb://currency-conversion-service"))
				.route(p -> p.path("/currency-conversion-new/**").filters(f -> f.rewritePath("currency-conversion-new/(?<segment>.*)", "currency-conversion-feign/${segment}")).uri("lb://currency-conversion-service"))
				.route(p -> p.path("/currency-conversion/**").uri("lb://currency-conversion-service")).build();
	}
}
