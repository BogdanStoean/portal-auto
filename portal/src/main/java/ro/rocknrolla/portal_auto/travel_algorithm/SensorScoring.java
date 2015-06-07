package ro.rocknrolla.portal_auto.travel_algorithm;


import ro.rocknrolla.portal_auto.entities.CarHistory;

import java.util.List;

public interface SensorScoring {

    int scoreIt(List<CarHistory> carHistoryList, SensorPriority sensorPriority);
}
