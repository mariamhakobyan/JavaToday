package co.javatoday.service;

import co.javatoday.data.model.BaseModel;

public interface Service {

	public <T extends BaseModel> T save(T obj);

	public <T extends BaseModel> void delete(T obj);
	
}
