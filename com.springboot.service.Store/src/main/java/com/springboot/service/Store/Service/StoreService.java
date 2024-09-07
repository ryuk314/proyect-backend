package com.springboot.service.Store.Service;

import java.util.List;

import com.springboot.service.Store.models.Store;

public interface StoreService {

	public List<Store> findAll();
		
	public Store findById (Long id, Integer cantidad);

}
