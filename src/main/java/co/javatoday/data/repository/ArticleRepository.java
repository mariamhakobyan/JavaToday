package co.javatoday.data.repository;

import org.springframework.data.document.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import co.javatoday.data.model.Article;

@Transactional
public interface ArticleRepository extends MongoRepository<Article, String> {
	
}
