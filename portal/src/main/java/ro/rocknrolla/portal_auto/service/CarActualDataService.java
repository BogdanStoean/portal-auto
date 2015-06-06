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
            for (CarSensorCriticalValue carSensorCriticalValue : byCarId) {
                if (carHistory.getSensor().getName().equals(carSensorCriticalValue.getSensor().getName())) {
                    SensorActualDataDTO obj = new SensorActualDataDTO();
                    obj.setStatus(sensorTypeFactory.getStatusByCriticleValue(carHistory.getValue(),carSensorCriticalValue.getValue(),carHistory.getSensor().getType()));


                }
            }

        }


        SensorActualDataDTO obj = new SensorActualDataDTO();
        obj.setMesaj("test mesaj 1");
        obj.setName(" nume 1 ");
        obj.setStatus("OK");


        SensorActualDataDTO obj2 = new SensorActualDataDTO();
        obj2.setMesaj("ALEEERT");
        obj2.setName(" nume 3333 ");
        obj2.setStatus("ALERT");

        SensorActualDataDTO obj3 = new SensorActualDataDTO();
        obj3.setMesaj("WARNING ceva se va intampla");
        obj3.setName(" atentiune natiune ");
        obj3.setStatus("WARNING");

        SensorActualDataDTO obj4 = new SensorActualDataDTO();
        obj4.setMesaj("Alt mesaj OK");
        obj4.setName(" Nume OK ");
        obj4.setStatus("OK");

        SensorActualDataDTO obj5 = new SensorActualDataDTO();
        obj5.setMesaj("La service cu tine");
        obj5.setName(" Esti praf");
        obj5.setStatus("ALERT");

        SensorActualDataDTO obj6 = new SensorActualDataDTO();
        obj6.setMesaj("Atentiune natiunie");
        obj6.setName(" nume de antiune");
        obj6.setStatus("WARNING");

        carDto.getSensorDisplayDTOs().add(obj);
        carDto.getSensorDisplayDTOs().add(obj2);
        carDto.getSensorDisplayDTOs().add(obj3);
        carDto.getSensorDisplayDTOs().add(obj4);
        carDto.getSensorDisplayDTOs().add(obj5);
        carDto.getSensorDisplayDTOs().add(obj6);

        return carDto;
    }
}
