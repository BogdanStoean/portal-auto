package ro.rocknrolla.portal_auto.controller.saas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.rocknrolla.portal_auto.controller.bean.CarModel;
import ro.rocknrolla.portal_auto.controller.bean.CarSensorCriticalValueModel;
import ro.rocknrolla.portal_auto.controller.bean.CarWithSensorsModel;
import ro.rocknrolla.portal_auto.security.CurrentAuthenticatedUser;
import ro.rocknrolla.portal_auto.service.CarSensorCriticalValueService;
import ro.rocknrolla.portal_auto.service.UserCarService;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Flori on 06.06.2015.
 */

@RestController
@RequestMapping("/cars")
public class UserCarsController {

    @Autowired
    private UserCarService userCarService;

    @Autowired
    private CarSensorCriticalValueService carSensorCriticalValueService;

    @RequestMapping(method = RequestMethod.GET)
    public List<CarModel> getUserCarList() {
        return userCarService.getUserCars(CurrentAuthenticatedUser.getUsername());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<CarModel> create(@RequestBody @Valid CarModel carModel) {
        CarModel ret = userCarService.create(carModel);
        return new ResponseEntity<>(ret, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{carId}", method = RequestMethod.GET)
    public CarModel getCarById(@PathVariable("carId") Long carId) {
        return userCarService.getCarById(carId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/editSensors")
    public ResponseEntity<CarWithSensorsModel> editSensors(@RequestBody @Valid CarWithSensorsModel carWithSensorsModel) {

        CarModel ret = userCarService.create(carWithSensorsModel.getCarModel());
        for (CarSensorCriticalValueModel carSensorCriticalValueModel : carWithSensorsModel.getSensorsList()) {
            carSensorCriticalValueService.create(carSensorCriticalValueModel);
        }

        return new ResponseEntity<>(carWithSensorsModel, HttpStatus.OK);
    }

}
