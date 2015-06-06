package ro.rocknrolla.portal_auto.controller.saas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.rocknrolla.portal_auto.controller.bean.CarModel;
import ro.rocknrolla.portal_auto.security.CurrentAuthenticatedUser;
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

    @RequestMapping(method = RequestMethod.GET)
    public List<CarModel> geuUserCarList() {
        return userCarService.getUserCars(CurrentAuthenticatedUser.getUsername());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<CarModel> create(@RequestBody @Valid CarModel carModel) {
        CarModel ret = userCarService.create(carModel);
        return new ResponseEntity<>(ret, HttpStatus.CREATED);
    }


}
