package ro.rocknrolla.portal_auto.controller.saas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.rocknrolla.portal_auto.bean.Response;
import ro.rocknrolla.portal_auto.entities.CarEntity;
import ro.rocknrolla.portal_auto.repositories.CarRepository;
import ro.rocknrolla.portal_auto.security.CurrentAuthenticatedUser;
import ro.rocknrolla.portal_auto.signup.bean.UserModel;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

/**
 * Created by Flori on 06.06.2015.
 */

@RestController
@RequestMapping("/cars")
public class UserCarsController {

    @Autowired
    private CarRepository carRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<CarEntity> geuUserCarList() {
      return carRepository.findByUserEmail(CurrentAuthenticatedUser.getUsername());
    }

}
