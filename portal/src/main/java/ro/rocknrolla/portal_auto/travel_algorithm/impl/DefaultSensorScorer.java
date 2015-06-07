package ro.rocknrolla.portal_auto.travel_algorithm.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.rocknrolla.portal_auto.entities.CarHistory;
import ro.rocknrolla.portal_auto.entities.CarSensorCriticalValue;
import ro.rocknrolla.portal_auto.repositories.CarSensorCriticalValueRepository;
import ro.rocknrolla.portal_auto.service.sensorType.SensorTypeFactory;
import ro.rocknrolla.portal_auto.travel_algorithm.SensorPriority;
import ro.rocknrolla.portal_auto.travel_algorithm.SensorScoring;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
public class DefaultSensorScorer implements SensorScoring {


    @Autowired
    private CarSensorCriticalValueRepository carSensorCriticalValueRepository;

    @Autowired
    private SensorTypeFactory sensorTypeFactory;

    @Override
    public int scoreIt(final List<CarHistory> carHistoryList, SensorPriority sensorPriority) {
        double sensorPriorityPoints = sensorPriority.getPoints();

        Collections.sort(carHistoryList, new Comparator<CarHistory>() {
            @Override
            public int compare(CarHistory o1, CarHistory o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });

        // making business only on the last data
        CarHistory carHistory = carHistoryList.get(0);
        CarSensorCriticalValue criticalValue = carSensorCriticalValueRepository.findOneByCarIdAndSensorId(carHistory.getCar().getId(), carHistory.getSensor().getId());

        if (criticalValue == null) {
            return 100;
        }
        String statusByCriticleValue = sensorTypeFactory.getStatusByCriticleValue(carHistory.getValue(), criticalValue.getValue(), carHistory.getSensor().getType());
        if (statusByCriticleValue.equalsIgnoreCase("ALERT") && (sensorPriority.getPoints() == SensorPriority.CRITICAL.getPoints())) {
            return 0;
        } else if (statusByCriticleValue.equalsIgnoreCase("WARNING") && (sensorPriority.getPoints() == SensorPriority.CRITICAL.getPoints())) {
            return (int) (20 * sensorPriorityPoints);
        } else if (statusByCriticleValue.equalsIgnoreCase("ALERT") && (sensorPriority.getPoints() == SensorPriority.MEDIUM.getPoints())) {
            return 40;
        } else if (statusByCriticleValue.equalsIgnoreCase("WARNING") && (sensorPriority.getPoints() == SensorPriority.MEDIUM.getPoints())) {
            return (int) (60 * sensorPriorityPoints);
        }

        return 100;
    }
}
