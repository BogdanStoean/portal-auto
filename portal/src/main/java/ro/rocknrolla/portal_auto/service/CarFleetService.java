package ro.rocknrolla.portal_auto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.rocknrolla.common.CarActualDataDTO;
import ro.rocknrolla.common.SensorActualDataDTO;
import ro.rocknrolla.portal_auto.controller.bean.CarFleetDTO;
import ro.rocknrolla.portal_auto.controller.bean.CarStatusDTO;
import ro.rocknrolla.portal_auto.controller.bean.SensorStatusDTO;
import ro.rocknrolla.portal_auto.entities.Car;
import ro.rocknrolla.portal_auto.repositories.CarRepository;
import ro.rocknrolla.portal_auto.security.CurrentAuthenticatedUser;

import java.util.List;

@Service
public class CarFleetService {

    @Autowired
    private CarActualDataService carActualDataService;

    @Autowired
    private CarRepository carRepository;

    public CarFleetDTO getAuthenticatedUserFleet() {
        List<Car> userCars = carRepository.findByUserEmail(CurrentAuthenticatedUser.getUsername());
        CarFleetDTO carFleetDTO = new CarFleetDTO();
        for (Car car : userCars) {
            CarActualDataDTO actualDataDTO = carActualDataService.getIt(car.getDeviceUUID());

            CarStatusDTO carStatusDTO = getCarStatusDTO(car);

            addSensorData(actualDataDTO, carStatusDTO);

            carFleetDTO.getCarFleet().add(carStatusDTO);
        }

        return null;
    }

    private void addSensorData(CarActualDataDTO actualDataDTO, CarStatusDTO carStatusDTO) {
        for (SensorActualDataDTO sensorActualDataDTO : actualDataDTO.getSensorDisplayDTOs()) {
            SensorStatusDTO sensorStatusDTO = new SensorStatusDTO();
            sensorStatusDTO.setName(sensorActualDataDTO.getName());
            sensorStatusDTO.setStatus(sensorActualDataDTO.getStatus());
            carStatusDTO.getSensorStatusDTOs().add(sensorStatusDTO);
        }
    }

    private CarStatusDTO getCarStatusDTO(Car car) {
        CarStatusDTO carStatusDTO = new CarStatusDTO();
        carStatusDTO.setCarUUID(car.getDeviceUUID());
        carStatusDTO.setName(car.getName());
        return carStatusDTO;
    }
}
