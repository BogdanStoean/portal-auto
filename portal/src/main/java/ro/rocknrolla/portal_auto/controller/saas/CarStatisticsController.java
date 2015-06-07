package ro.rocknrolla.portal_auto.controller.saas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.rocknrolla.portal_auto.controller.bean.CarRouteModel;
import ro.rocknrolla.portal_auto.controller.bean.ResponseModel;
import ro.rocknrolla.portal_auto.service.CarRouteCheckerService;

/**
 * Created by Bogdan Stoean on 6/7/15.
 */
@RestController
@RequestMapping("/statistics")
public class CarStatisticsController {

    @Autowired
    private CarRouteCheckerService carRouteCheckerService;


    @RequestMapping(method = RequestMethod.POST, value = "/check")
    public ResponseModel checkCarOnRoute(@RequestBody CarRouteModel model) {
        return carRouteCheckerService.check(model);
    }

}
