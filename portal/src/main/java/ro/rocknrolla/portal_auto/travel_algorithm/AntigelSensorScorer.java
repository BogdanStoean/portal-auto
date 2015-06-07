package ro.rocknrolla.portal_auto.travel_algorithm;


import org.springframework.stereotype.Component;

@Component
public class AntigelSensorScorer implements SensorScoring {

    @Override
    public int scoreIt(String car, String sensor, SensorPriority sensorPriority) {
        return 0;
    }
}
