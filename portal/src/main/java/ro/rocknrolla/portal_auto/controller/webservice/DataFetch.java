package ro.rocknrolla.portal_auto.controller.webservice;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.rocknrolla.common.CarParametersDTO;
import ro.rocknrolla.portal_auto.entities.Car;
import ro.rocknrolla.portal_auto.repositories.CarRepository;

@RestController
@RequestMapping("/webservice")
public class DataFetch {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataFetch.class);

    @Autowired
    private CarRepository carRepository;

    @RequestMapping(value = "/carinformation", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity carInformation(@RequestBody CarParametersDTO data) {
        Car car = carRepository.findByDeviceUUIDAndActive(data.getDeviceId(), true);
        if (car == null) {
            LOGGER.info("Someone is hitting app with an unknown device");
            return ResponseEntity.ok("500 Bad Data");
        }
        if (!isValidData(data)) {
            LOGGER.info("Someone is hitting app with bad data");
            return ResponseEntity.ok("500 Bad Data");
        }

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

}
