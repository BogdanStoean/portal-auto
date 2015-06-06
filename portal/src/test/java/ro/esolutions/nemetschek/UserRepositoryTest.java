package ro.esolutions.nemetschek;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ro.esolutions.nemetschek.entities.User;
import ro.esolutions.nemetschek.repositories.UserRepository;

import java.util.List;

/**
 * Created by Bogdan Stoean on 15.04.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ActiveProfiles("test")
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void testFindAll() {
		List<User> users = userRepository.findAll();
		Assert.assertEquals(3, users.size());

	}

}


