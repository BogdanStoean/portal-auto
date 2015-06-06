package ro.rocknrolla.portal_auto.controller.webservice;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.rocknrolla.common.CarParametersDTO;
import ro.rocknrolla.portal_auto.entities.Car;
import ro.rocknrolla.portal_auto.repositories.CarRepository;
import ro.rocknrolla.portal_auto.service.CarActualDataService;
import ro.rocknrolla.portal_auto.service.CarHistoryService;

@RestController
@RequestMapping("/webservice")
public class DataFetch {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataFetch.class);

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarHistoryService carHistoryService;

    @Autowired
    private CarActualDataService carActualDataService;

    @RequestMapping(value = "/carinformation", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity carInformation(@RequestBody CarParametersDTO data) {
        Car car = carRepository.findByDeviceUUIDAndActive(data.getDeviceId(), true);
        if (car == null) {
            LOGGER.info("Someone is hitting app with an unknown device: " + data.getDeviceId());
            return ResponseEntity.ok("500 Bad Data");
        }
        if (!isValidData(data)) {
            LOGGER.info("Someone is hitting app with bad data");
            return ResponseEntity.ok("500 Bad Data");
        }


        carHistoryService.persistCarHistory(data);
        LOGGER.info("Someone is hitting app");
        return ResponseEntity.ok("");
    }

    public boolean isValidData(CarParametersDTO carParametersDTO) {
        if (carParametersDTO == null) {
            return false;
        }
        String deviceUUD = carParametersDTO.getDeviceId();
        if (deviceUUD == null || deviceUUD.trim().length() == 0) {
            return false;
        }

        Car carEntity = carRepository.findByDeviceUUIDAndActive(carParametersDTO.getDeviceId(), true);
        if (carEntity == null) {
            return false;
        }

        return true;
    }


    @RequestMapping(value = "/checkcar/{car}", method = RequestMethod.GET)
    public ResponseEntity verifyDevice(@PathVariable String car) {
        if (car == null) {
            LOGGER.error("Unknown car in trying the 'check device' endpoint");
            ResponseEntity.notFound();
        }

        Car carEntity = carRepository.findByDeviceUUIDAndActive(car, true);
        if (carEntity == null) {
            LOGGER.error("Unknown car in trying the 'check device' endpoint with unregistered id");
            ResponseEntity.notFound();
        }
        LOGGER.info("Loggin existing car: " + carEntity.getName());
        return ResponseEntity.ok("200");
    }


    @RequestMapping(value = "/getActualDataForCar/{car}", method = RequestMethod.GET)
    public ResponseEntity getDataForDevice(@PathVariable String car) {
        if (car == null) {
            LOGGER.error("Unknow car is trying the 'get actual data for car' endpoint");
            ResponseEntity.notFound();
        }

        return ResponseEntity.ok(carActualDataService.getIt(car));
    }

}
