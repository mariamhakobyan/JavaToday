package co.javatoday.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mysema.query.types.Predicate;

import co.javatoday.data.model.BaseModel;

public interface Service {

	public <T extends BaseModel> T save(T obj);

	public <T extends BaseModel> void delete(T obj);
	
	public Page<? extends BaseModel> findAll(Predicate predicate, Pageable pagable);
	
	public Page<? extends BaseModel> findAll(Pageable pagable);
	
}
