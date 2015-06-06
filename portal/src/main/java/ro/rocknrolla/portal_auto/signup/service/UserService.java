package ro.rocknrolla.portal_auto.signup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;
import ro.rocknrolla.portal_auto.entities.User;
import ro.rocknrolla.portal_auto.exception.UniqueViolationException;
import ro.rocknrolla.portal_auto.repositories.UserRepository;
import ro.rocknrolla.portal_auto.signup.bean.UserModel;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void createUser(UserModel userModel) {
		User user = new User();

		user.setEmail(userModel.getEmail());
		user.setFirstName(userModel.getFirstName());
		user.setLastName(userModel.getLastName());
		user.setCreatedDate(new Date());
		user.setActive(true);

		//TODO add salt field
		user.setPassword(new ShaPasswordEncoder().encodePassword(userModel.getPassword(), null));
		
		checkForDuplicates(user);

		userRepository.save(user);
	}

	private void checkForDuplicates(User user) {
		if (userRepository.findActiveByEmail(user.getEmail()) != null) {
			throw new UniqueViolationException("email", "duplicate.email");
		}
	}
}
