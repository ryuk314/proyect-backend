package com.springboot.service.celulares.repository;

import org.springframework.data.repository.CrudRepository;

import com.microservice.store.models.Celular;

public interface CelularDao extends CrudRepository <Celular,Long>{

}