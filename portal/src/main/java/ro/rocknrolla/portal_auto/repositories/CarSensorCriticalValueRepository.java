package ro.rocknrolla.portal_auto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.rocknrolla.portal_auto.entities.CarSensorCriticalValue;

import java.util.List;

/**
 * Created by Bogdan Stoean on 6/6/15.
 */
public interface CarSensorCriticalValueRepository extends JpaRepository<CarSensorCriticalValue, Long> {

    List<CarSensorCriticalValue> findByCarId(Long carId);
}
