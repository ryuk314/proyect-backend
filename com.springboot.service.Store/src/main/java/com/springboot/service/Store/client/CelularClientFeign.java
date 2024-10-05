package com.springboot.service.Store.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.service.Store.models.Celular;

@FeignClient(name="service-store",url="localhost:8081")
public interface CelularClientFeign {

	@GetMapping("/list")
	public List<Celular>list();
	
	@GetMapping("/Celular/{id}")
	public Celular detall (@PathVariable Long id);
}
