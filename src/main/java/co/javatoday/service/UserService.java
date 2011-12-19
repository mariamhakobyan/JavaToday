package co.javatoday.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mysema.query.types.Predicate;

import co.javatoday.data.model.BaseModel;
import co.javatoday.data.model.QUser;
import co.javatoday.data.model.User;
import co.javatoday.data.repository.UserRepository;

@Service("userService")
public class UserService implements co.javatoday.service.Service<User> {

	@Autowired
	UserRepository userRepository;

	@Override
	@SuppressWarnings("unchecked")
	public User save(User user) {
		if(user.getId() == null) {
			QUser quser = QUser.user;
			User existingUser = userRepository.findOne(quser.socialId.eq(user.getSocialId()).
					and(quser.userSource.eq(user.getUserSource())));
	
			if(existingUser != null) {
				user.setId(existingUser.getId());
			}
		}
		return userRepository.save(user);
	}

	@Override
	public void delete(User obj) {
		userRepository.delete((User) obj);
	}
	
	@Override
	public Page<User> findAll(Predicate predicate, Pageable pagable) {
		return null;
	}
	
	@Override
	public Page<User> findAll(Pageable pagable) {
		return null;
	}
}
