package co.javatoday.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mysema.query.types.Predicate;

import co.javatoday.data.model.Article;
import co.javatoday.data.model.BaseModel;
import co.javatoday.data.model.QArticle;
import co.javatoday.data.repository.ArticleRepository;

@Service("articleService")
public class ArticleService implements co.javatoday.service.Service {

	@Autowired
	ArticleRepository articleRepository;
	
	@Override
    public <T extends BaseModel> T save(T obj) {
	    return null;
    }

	@Override
    public <T extends BaseModel> void delete(T obj) {
	    
    }
	
	@Override
	public Page<? extends BaseModel> findAll(Predicate predicate, Pageable pagable) {
	    return (Page<Article>)articleRepository.findAll(predicate, pagable);
    }
	
	@Override
	public Page<? extends BaseModel> findAll(Pageable pagable) {
	    return (Page<Article>)articleRepository.findAll(pagable);
    }

}
