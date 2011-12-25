package co.javatoday.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.transaction.annotation.Transactional;

import co.javatoday.data.model.Article;

@Transactional
public interface ArticleRepository extends MongoRepository<Article, String>, QueryDslPredicateExecutor<Article>{
	
}
