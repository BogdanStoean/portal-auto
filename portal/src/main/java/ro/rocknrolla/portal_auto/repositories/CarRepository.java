package ro.rocknrolla.portal_auto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.rocknrolla.portal_auto.entities.Car;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    Car findByDeviceUUIDAndActive(String deviceUUID, boolean active);

    List<Car> findByUserEmail(String email);

    List<Car> findByActiveTrue();


}
