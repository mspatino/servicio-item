package com.msp.springboot.sapp.item.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.msp.springboot.sapp.item.clientes.ProductoClienteFeign;
import com.msp.springboot.sapp.item.models.Item;

//TODO tenemos 2 servicios que implementan la misma interfaz: 
//RestTemplate y FeignClient, con @Primary indicamos cual es el servicio principal que debe injectar spring por defecto
@Service("serviceFeign")
@Primary
public class ItemServiceFeign implements ItemService {
	
	@Autowired
	private ProductoClienteFeign clienteFeign;

	@Override
	public List<Item> findAll() {
		return clienteFeign.listar().stream().map(p -> new Item(p,1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		return new Item(clienteFeign.detalle(id), cantidad) ;
	}

}
