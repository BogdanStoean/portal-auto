package ro.rocknrolla.portal_auto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.rocknrolla.portal_auto.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findActiveByEmail(String email);
}
