package ro.rocknrolla.portal_auto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.rocknrolla.portal_auto.entities.Sensor;

/**
 * Created by Bogdan Stoean on 6/6/15.
 */
public interface SensorRepository extends JpaRepository<Sensor, Long> {
}
