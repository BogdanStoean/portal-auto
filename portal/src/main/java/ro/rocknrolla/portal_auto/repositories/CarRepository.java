package ro.rocknrolla.portal_auto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.rocknrolla.portal_auto.entities.CarEntity;

/**
 * Created by virgil on 06.06.2015.
 */
public interface CarRepository extends JpaRepository<CarEntity, Long> {
    CarEntity findByDeviceUUIDAndActive(String deviceUUID, boolean active);
}
