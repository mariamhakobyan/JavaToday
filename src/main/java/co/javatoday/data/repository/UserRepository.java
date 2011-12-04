package co.javatoday.data.repository;

import org.springframework.data.document.mongodb.repository.MongoRepository;
import org.springframework.data.document.mongodb.repository.QueryDslPredicateExecutor;
import org.springframework.transaction.annotation.Transactional;

import co.javatoday.data.model.User;

@Transactional
public interface UserRepository extends MongoRepository<User , String>, QueryDslPredicateExecutor<User> {

}
