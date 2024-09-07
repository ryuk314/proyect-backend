package com.springboot.service.celulares.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.service.celulares.entity.Celular;

@Service
public interface CelularService {
    
    public List<Celular>FinAll();
    
    public Celular FindById(long id);

    public void deleteById(long id);

    public Celular save (Celular instance);

    public boolean existsById(long id);
}
