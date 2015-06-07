package ro.rocknrolla.portal_auto.travel_algorithm;


public interface SensorScoring {

    int scoreIt(String car, String sensor, SensorPriority sensorPriority);
}
