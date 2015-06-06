package ro.rocknrolla.portal_auto.controller.webservice;


import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.rocknrolla.common.CarParametersDTO;
import ro.rocknrolla.portal_auto.entities.Car;
import ro.rocknrolla.portal_auto.repositories.CarRepository;

import java.util.List;

@RestController
@RequestMapping("/webservice")
public class DataFetch {

    @Autowired
    private CarRepository carRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(DataFetch.class);

    @RequestMapping(value = "/carInformation", method = RequestMethod.POST)
    public ResponseEntity getPrincipal(@RequestBody CarParametersDTO data) {
        LOGGER.info("Someone is hitting app");
        carRepository.findByDeviceUUIDAndActive("UUID", true);
        if (!isValidData(data)) {
            return ResponseEntity.ok("500 Bad Data");
        }


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

    private CarParametersDTO extractCarParameter(String data) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<CarParametersDTO> carParameters = null;
        try {
            carParameters = objectMapper.readValue(data, TypeFactory.collectionType(List.class, CarParametersDTO.class));
        } catch (Exception e) {
            LOGGER.error("Something went wrong when trying to convert data into DTOs: " + e.getMessage());
        }

        return carParameters.get(0);
    }
}
