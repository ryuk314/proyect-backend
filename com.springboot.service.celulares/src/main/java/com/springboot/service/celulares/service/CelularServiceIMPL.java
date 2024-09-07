package com.springboot.service.celulares.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.service.celulares.entity.Celular;
import com.springboot.service.celulares.repository.CelularDao;
@Service
public class CelularServiceIMPL implements CelularService{
	@Autowired
	private CelularDao celularDao;

	public List <Celular> findAll (){
	    return (List<Celular>) celularDao.findAll;
	}

	public Celular findById (long id){
	    return celularDao.findById(id).orElse(null);
	}

	public void deleteById(long id){
	    celularDao.deleteById(id);
	}

	public Celular save (Celular instance){
	    return celularDao.save(instance);
	}

	public boolean ExistByid(long id){
	    return celularDao.existsById(id);
	}

	@Override
	public List<Celular> FinAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Celular FindById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
}