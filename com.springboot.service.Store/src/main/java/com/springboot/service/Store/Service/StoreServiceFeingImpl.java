package com.springboot.service.Store.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.springboot.service.Store.client.CelularClientFeign;
import com.springboot.service.Store.models.Store;
@Service("ServiceFeing")
public class StoreServiceFeingImpl implements StoreService {
	@Autowired
	private CelularClientFeign clientFeign;

	@Override
	public List<Store> findAll() {
		return clientFeign.list().stream().map(c-> new Store(c,5)).collect(Collectors.toList());
	}

	@Override
	public Store findById(Long id, Integer cantidad) {
		return new Store(clientFeign.detall(id),cantidad);
	}

}
