package com.microcervice.usuarios;

import java.lang.reflect.Method;
import java.util.Optional;

import org.apache.commons.codec.language.bm.Rule;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.support.RepositoryInvoker;
import org.springframework.util.MultiValueMap;
import org.springframework.web.servlet.config.annotation.CorsRegistry;



@Configuration

public class RepositoryConfig implements RepositoryInvoker{
	
	public void configureRepositoryRestConfiguration(RepositoryRestMvcAutoConfiguration config,CorsRegistry core) {
		config.ExposeIdsFor(Usuario.class,Rule.class);
	}

	@Override
	public boolean hasSaveMethod() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasDeleteMethod() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasFindOneMethod() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasFindAllMethod() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T invokeSave(T object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Optional<T> invokeFindById(Object id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Iterable<Object> invokeFindAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Object> invokeFindAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void invokeDeleteById(Object id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Object> invokeQueryMethod(Method method, MultiValueMap<String, ? extends Object> parameters,
			Pageable pageable, Sort sort) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
