package com.springboot.service.Store.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springboot.service.Store.models.Celular;
import com.springboot.service.Store.models.Store;
@Service("ServiceRest")
@Primary
public class StoreServiceRestImpl implements StoreService {

	@Autowired
	public RestTemplate clientRest;
	@Override
	public List<Store> findAll() {
		List<Celular> Celulares= Arrays.asList(clientRest.getForObject("http://localhost:8081/list",Celular[].class));
		return Celulares.stream().map(c-> new Store(c,5)).collect(Collectors.toList());
	}

	@Override
	public Store findById(Long id, Integer cantidad) {
		Map<String,String>pathVariables= new HashMap<>();
		pathVariables.put("id",id.toString());
		Celular cel =clientRest.getForObject("http://localhost:8081/celular/(id)", Celular.class,pathVariables);
		return new Store(cel,cantidad);
	}

}
