package co.javatoday.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mysema.query.types.Predicate;

import co.javatoday.data.model.Article;
import co.javatoday.data.repository.ArticleRepository;

@Service("articleService")
public class ArticleService implements co.javatoday.service.Service<Article> {

	@Autowired
	ArticleRepository articleRepository;
	
	@Override
    public Article save(Article obj) {
	    return null;
    }

	@Override
    public void delete(Article obj) {
	    
    }
	
	@Override
	public Page<Article> findAll(Predicate predicate, Pageable pagable) {
	    return (Page<Article>)articleRepository.findAll(predicate, pagable);
    }
	
	@Override
	public Page<Article> findAll(Pageable pagable) {
	    return (Page<Article>)articleRepository.findAll(pagable);
    }

}
