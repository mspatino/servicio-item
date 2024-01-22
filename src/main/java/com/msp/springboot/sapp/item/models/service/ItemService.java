package com.msp.springboot.sapp.item.models.service;

import java.util.List;

import com.msp.springboot.sapp.item.models.Item;

public interface ItemService {
	
	public List<Item> findAll();
	
	public Item findById(Long id, Integer cantidad);

}
