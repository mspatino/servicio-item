package com.msp.springboot.sapp.item;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//creamos un cliente Rest-Template , un cliente para trabajar con http

@Configuration
public class AppConfig {
	
	@Bean("clienteRest")
	@LoadBalanced
	public RestTemplate registrarRestTempplate() {
		return new RestTemplate();
	}

}
