package ro.rocknrolla.portal_auto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.rocknrolla.portal_auto.entities.Sensor;

public interface SensorRepository extends JpaRepository<Sensor, Long> {

    Sensor findByName(String name);
}
