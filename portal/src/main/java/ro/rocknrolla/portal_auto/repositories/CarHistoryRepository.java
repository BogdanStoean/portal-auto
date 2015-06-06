package ro.rocknrolla.portal_auto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.rocknrolla.portal_auto.entities.CarHistory;


public interface CarHistoryRepository extends JpaRepository<CarHistory,Long> {
}
