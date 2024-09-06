package com.springboot.service.celulares.controllers;

import java.util.List; 

import org.apache.logging.log4j.CloseableThreadContext.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.service.celulares.entity.Celular;
import com.springboot.service.celulares.service.CelularService;

@RestController
public class CelularesController {
	
	@Autowired
    private CelularService service;
    @GetMapping("/list")
    public List<Celular>list(){
        return service.FinAll();
    }

    @DeleteMapping("/Celular/{id}")
        public ResponseEntity<Object> drop (@PathVariable long id){
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }

    @PostMapping("/celular")
    public ResponseEntity<Celular> add(@RequestBody Celular instance){
        Celular cel=service.save(instance);
        return new ResponseEntity<>(cel, HttpStatus.CREATED);
    }
    @PutMapping("/Celular/{id}")
    public ResponseEntity<Celular>update(@PathVariable long id , @RequestBody Celular instance) {
        if (service.existsById(id)) {
            Instance.setId(id);
            Celular cel=service.save(instance);
            return new ResponseEntity<>(cel,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }
}
