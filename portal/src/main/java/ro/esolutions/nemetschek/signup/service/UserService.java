package ro.esolutions.nemetschek.signup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;
import ro.esolutions.nemetschek.entities.User;
import ro.esolutions.nemetschek.exception.UniqueViolationException;
import ro.esolutions.nemetschek.repositories.UserRepository;
import ro.esolutions.nemetschek.signup.bean.UserModel;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: marius
 * Date: 5/4/15
 * Time: 2:24 PM
 */

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
