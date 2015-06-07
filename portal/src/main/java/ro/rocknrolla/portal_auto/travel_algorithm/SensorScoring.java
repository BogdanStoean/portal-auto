package ro.rocknrolla.portal_auto.travel_algorithm;


public interface SensorScoring {

    int scoreIt(Long carId, String sensor, SensorPriority sensorPriority, Long KM);
}
