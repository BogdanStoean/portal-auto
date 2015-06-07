package ro.rocknrolla.portal_auto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.rocknrolla.portal_auto.entities.Car;
import ro.rocknrolla.portal_auto.entities.CarHistory;

import java.util.List;

public interface CarHistoryRepository extends JpaRepository<CarHistory,Long> {

    @Query(value = "SELECT * FROM car_history * WHERE car_id = (select car_id from car where deviceuuid= ? ) ORDER BY last_modified_date DESC LIMIT 16",nativeQuery = true)
    List<CarHistory> findLastSensorValuesForCar(String deviceUUID);
}
