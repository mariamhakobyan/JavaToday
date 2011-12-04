package co.javatoday.service;

import org.springframework.stereotype.Service;

import co.javatoday.data.model.BaseModel;

@Service("articleService")
public class ArticleService implements co.javatoday.service.Service {

	@Override
    public <T extends BaseModel> T save(T obj) {
	    return null;
    }

	@Override
    public <T extends BaseModel> void delete(T obj) {
	    
    }

}
