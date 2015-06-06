package ro.esolutions.nemetschek.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.esolutions.nemetschek.entities.User;

/**
 * Created by Bogdan Stoean on 15.04.2015.
 */
public interface UserRepository extends JpaRepository<User, Long> {
	User findActiveByEmail(String email);
}
