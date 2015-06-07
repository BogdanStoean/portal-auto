package ro.rocknrolla.portal_auto.travel_algorithm;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.rocknrolla.portal_auto.repositories.CarHistoryRepository;

@Component
public class AntigelSensorScorer implements SensorScoring {

    @Autowired
    private CarHistoryRepository carHistoryRepository;

    @Override
    public int scoreIt(Long carId, String sensor, SensorPriority sensorPriority, Long KM) {
        double sensorPriorityPoints = sensorPriority.getPoints();

//        carHistoryRepository.findLastSensorValuesForCar()

        return 0;
    }
}
