package com.msp.springboot.sapp.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;


@RibbonClient( name = "servicio-productos")
@EnableFeignClients//Cliente Feign
@SpringBootApplication
public class SpringbootServiciosItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiciosItemApplication.class, args);
	}

}
