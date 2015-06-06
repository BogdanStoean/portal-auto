package ro.rocknrolla.portal_auto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.rocknrolla.common.CarActualDataDTO;
import ro.rocknrolla.common.SensorActualDataDTO;
import ro.rocknrolla.portal_auto.entities.CarHistory;
import ro.rocknrolla.portal_auto.entities.CarSensorCriticalValue;
import ro.rocknrolla.portal_auto.repositories.CarHistoryRepository;
import ro.rocknrolla.portal_auto.repositories.CarRepository;
import ro.rocknrolla.portal_auto.repositories.CarSensorCriticalValueRepository;
import ro.rocknrolla.portal_auto.service.sensorType.SensorTypeFactory;
import ro.rocknrolla.portal_auto.service.sensorType.types.SensorCurrentStatusMessage;

import java.util.List;


@Service
public class CarActualDataService {
    @Autowired
    private CarHistoryRepository carHistoryRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private SensorTypeFactory sensorTypeFactory;

    @Autowired
    private CarSensorCriticalValueRepository carSensorCriticalValueRepository;

    public CarActualDataDTO getIt(String car) {
        CarActualDataDTO carDto = new CarActualDataDTO();

        List<CarHistory> lastSensorValuesForCar = carHistoryRepository.findLastSensorValuesForCar(car);

        List<CarSensorCriticalValue> byCarId = carSensorCriticalValueRepository.findByCarId(carRepository.findByDeviceUUIDAndActive(car, true).getId());

        for (CarHistory carHistory : lastSensorValuesForCar) {
            SensorActualDataDTO obj = new SensorActualDataDTO();
            for (CarSensorCriticalValue carSensorCriticalValue : byCarId) {
                if (carHistory.getSensor().getName().equals(carSensorCriticalValue.getSensor().getName())) {
                    String statusByCriticleValue = sensorTypeFactory.getStatusByCriticleValue(carHistory.getValue(), carSensorCriticalValue.getValue(), carHistory.getSensor().getType());
                    obj.setStatus(statusByCriticleValue);
                    if (statusByCriticleValue.equalsIgnoreCase("ALERT")) {
                        obj.setMesaj(carHistory.getSensor().getAlertMessage());
                    }
                    break;
                }
            }

            if(obj.getStatus() == null){
                obj.setStatus(SensorCurrentStatusMessage.OK.name());
            }
            obj.setName(carHistory.getSensor().getName());
            carDto.getSensorDisplayDTOs().add(obj);

        }
        return carDto;
    }

}
