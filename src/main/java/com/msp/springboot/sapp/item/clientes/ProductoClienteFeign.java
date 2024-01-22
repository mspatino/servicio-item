package com.msp.springboot.sapp.item.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.msp.springboot.sapp.item.models.Producto;


//se define q esta interfaz es un cliente feign
//le decimos el nombre del microservicio con el que queremos conectarnos
//@FeignClient(name = "servicio-productos", url = "localhost:8001/api/productos")
@FeignClient(name= "servicio-productos")
public interface ProductoClienteFeign {
	
	//tiene que ser el mismo nombre del end-point para poder consumir el servicio el API-REST 
	@GetMapping("/listar")
	public List<Producto> listar();
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id);

}
