package com.springboot.service.Store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.service.Store.Service.StoreService;
import com.springboot.service.Store.models.Store;

@RestController
public class StoreController {

	@Autowired
	private StoreService storeService;
	@GetMapping ("/List")
	public List<Store> list(){
		return storeService.findAll();
	}
	
	@GetMapping("/Celular/(id)/cantidad/(cantidad)")
	public Store details(@PathVariable Long id, @PathVariable Integer cantidad) {
		return storeService.findById(id,cantidad);
	}
}
