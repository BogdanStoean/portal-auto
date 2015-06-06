package ro.rocknrolla.portal_auto.controller.saas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.rocknrolla.portal_auto.controller.bean.CarBean;
import ro.rocknrolla.portal_auto.security.CurrentAuthenticatedUser;
import ro.rocknrolla.portal_auto.service.UserCarService;

import java.util.List;

/**
 * Created by Flori on 06.06.2015.
 */

@RestController
@RequestMapping("/cars")
public class UserCarsController {

    @Autowired
    private UserCarService userCarService;

    @RequestMapping(method = RequestMethod.GET)
    public List<CarBean> geuUserCarList() {
        return userCarService.getUserCars(CurrentAuthenticatedUser.getUsername());

    }

}
