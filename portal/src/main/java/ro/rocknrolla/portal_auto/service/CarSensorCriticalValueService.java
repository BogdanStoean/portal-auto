package ro.rocknrolla.portal_auto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.rocknrolla.portal_auto.controller.bean.CarSensorCriticalValueModel;
import ro.rocknrolla.portal_auto.entities.CarSensorCriticalValue;
import ro.rocknrolla.portal_auto.entities.Sensor;
import ro.rocknrolla.portal_auto.exception.ServerEntityNotFoundException;
import ro.rocknrolla.portal_auto.repositories.CarRepository;
import ro.rocknrolla.portal_auto.repositories.CarSensorCriticalValueRepository;
import ro.rocknrolla.portal_auto.repositories.SensorRepository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Bogdan Stoean on 6/6/15.
 */
@Service
@Transactional
public class CarSensorCriticalValueService {


    @Autowired
    private CarSensorCriticalValueRepository carSensorCriticalValueRepository;

    @Autowired
    private CarRepository carRepository;


    @Autowired
    private SensorRepository sensorRepository;


    public void create(CarSensorCriticalValueModel model) {
        CarSensorCriticalValue carSensorCriticalValue;

        if (model.getId() != null) {
            carSensorCriticalValue = carSensorCriticalValueRepository.findOne(model.getId());
        } else {
            carSensorCriticalValue = new CarSensorCriticalValue();
        }

        if (carSensorCriticalValue == null) {
            throw new ServerEntityNotFoundException("id", "entity.not.found");
        }

        carSensorCriticalValue.setCar(carRepository.findOne(model.getCarId()));
        carSensorCriticalValue.setSensor(sensorRepository.findOne(model.getSensorId()));
        carSensorCriticalValue.setValue(model.getCriticalValue());
        carSensorCriticalValueRepository.save(carSensorCriticalValue);

    }

    public List<CarSensorCriticalValue> listByCar(Long carId) {
        return carSensorCriticalValueRepository.findByCarId(carId);
    }


    public List<CarSensorCriticalValueModel> listModelByCar(Long carId) {

        List<CarSensorCriticalValue> carSensorCriticalValues = carSensorCriticalValueRepository.findByCarId(carId);

        Map<Long, CarSensorCriticalValueModel> results = new LinkedHashMap<>();
        for (CarSensorCriticalValue carSensorCriticalValue : carSensorCriticalValues) {
            results.put(carSensorCriticalValue.getSensor().getId(), new CarSensorCriticalValueModel(carSensorCriticalValue));
        }

        List<Sensor> sensorList = sensorRepository.findAll();
        for (Sensor sensor : sensorList) {
            if (results.get(sensor.getId()) == null) {
                results.put(sensor.getId(), new CarSensorCriticalValueModel(sensor.getId(), carId));
            }
        }

        return new ArrayList<>(results.values());
    }
}
