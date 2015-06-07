package ro.rocknrolla.portal_auto.travel_algorithm;


import org.springframework.stereotype.Component;

@Component
public class AntigelSensorScorer implements SensorScoring {

    @Override
    public int scoreIt(Long carId, String sensor, SensorPriority sensorPriority) {
        double sensorPriorityPoints = sensorPriority.getPoints();
        return 0;
    }
}
