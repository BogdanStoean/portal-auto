package ro.rocknrolla.portal_auto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.rocknrolla.common.CarParametersDTO;
import ro.rocknrolla.common.SensorDTO;
import ro.rocknrolla.portal_auto.entities.Car;
import ro.rocknrolla.portal_auto.entities.CarHistory;
import ro.rocknrolla.portal_auto.entities.Sensor;
import ro.rocknrolla.portal_auto.repositories.CarHistoryRepository;
import ro.rocknrolla.portal_auto.repositories.CarRepository;
import ro.rocknrolla.portal_auto.repositories.SensorRepository;

import javax.transaction.Transactional;


@Service
@Transactional
public class CarHistoryService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private CarHistoryRepository carHistoryRepository;

    public void persistCarHistory(CarParametersDTO carParameters) {
        Car car = carRepository.findByDeviceUUIDAndActive(carParameters.getDeviceId(), true);
        for(SensorDTO sensorDTO: carParameters.getSensors()){
            Sensor byName = sensorRepository.findByName(sensorDTO.getName());
            if(byName == null){
                continue;
            }
            CarHistory carHistory = new CarHistory();
            carHistory.setSensor(byName);
            carHistory.setCar(car);
            carHistory.setValue(sensorDTO.getValue());
            carHistoryRepository.save(carHistory);
        }

    }
}
