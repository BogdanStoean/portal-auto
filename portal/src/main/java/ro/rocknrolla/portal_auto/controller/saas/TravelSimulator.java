package ro.rocknrolla.portal_auto.controller.saas;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.rocknrolla.portal_auto.controller.bean.CarRouteModel;
import ro.rocknrolla.portal_auto.controller.bean.ResponseModel;

import javax.validation.Valid;

/**
 * Created by virgil on 07.06.2015.
 */
@RestController
@RequestMapping("/travelSimulator")
public class TravelSimulator {

    @RequestMapping(value = "/initiate", method = RequestMethod.GET)
    public ResponseModel getCarById(@RequestBody @Valid CarRouteModel carRouteModel) {

        return new ResponseModel("Mergi cu Dumnezeu", "La prima dai pe afara!");

    }
}
