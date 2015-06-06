package ro.rocknrolla.portal_auto.controller.saas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.rocknrolla.portal_auto.bean.Response;
import ro.rocknrolla.portal_auto.entities.CarSensorCriticalValue;
import ro.rocknrolla.portal_auto.controller.bean.CarSensorCriticalValueModel;
import ro.rocknrolla.portal_auto.service.CarSensorCriticalValueService;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Bogdan Stoean on 6/6/15.
 */
@RestController
@RequestMapping("/carSensorCriticalValue")
public class CarSensorCriticalValueController {


    @Autowired
    private CarSensorCriticalValueService carSensorCriticalValueService;

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<Response> create(@RequestBody @Valid CarSensorCriticalValueModel model) {
        carSensorCriticalValueService.create(model);
        return new ResponseEntity<>(new Response(true), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list/{carId}")
    public List<CarSensorCriticalValueModel> list(@PathVariable("carId") Long carId) {
        return carSensorCriticalValueService.listModelByCar(carId);
    }

}
