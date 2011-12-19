package co.javatoday.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mysema.query.types.Predicate;

import co.javatoday.data.model.BaseModel;

public interface Service<T extends BaseModel> {

	public T save(T obj);

	public void delete(T obj);
	
	public Page<T> findAll(Predicate predicate, Pageable pagable);
	
	public Page<T> findAll(Pageable pagable);
	
}
