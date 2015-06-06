package ro.rocknrolla.portal_auto.controller.saas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.rocknrolla.portal_auto.entities.Sensor;
import ro.rocknrolla.portal_auto.service.SensorService;

import java.util.List;

/**
 * Created by Bogdan Stoean on 6/6/15.
 */
@RestController
@RequestMapping("/sensors")
public class SensorController {


    @Autowired
    private SensorService sensorService;


    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public List<Sensor> list() {
        return sensorService.listAll();
    }
}
