package com.msp.springboot.sapp.item.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.msp.springboot.sapp.item.models.Item;
import com.msp.springboot.sapp.item.models.Producto;



@Service("restTemplate")
public class ItemServiceImpl implements ItemService {
	
	//los datos los vamos a obtener de una API-REST se van a comunicar ambos servicios (Item - Producto)
	//necesitamos configurar el RestTemplate (cliente http para consumir API Rest) y registrar este Beans en Spring, creamos la clase AppConfig en el packege principal
	@Autowired
	private RestTemplate clienteRest;

	@Override
	public List<Item> findAll() {
		// Obtenemos el listado de productos
		//List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://localhost:8001/listar", Producto[].class))  ;
		List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://servicio-productos/listar", Producto[].class))  ;
		//convertir un objeto producto en un itam
		return productos.stream().map(p -> new Item(p,1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		//creamos un mapa para pasar el valor al parametro: id
		Map<String, String> pathVariables = new HashMap<String,String>(); 
		pathVariables.put("id", id.toString());
		
		//Producto producto =clienteRest.getForObject("http://localhost:8001/ver/{id}", Producto.class, pathVariables)  ;
		Producto producto =clienteRest.getForObject("http://servicio-productos/ver/{id}", Producto.class, pathVariables)  ;
		
		return new Item(producto, cantidad);
	}

}
