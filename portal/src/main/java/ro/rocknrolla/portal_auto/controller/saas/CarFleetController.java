package ro.rocknrolla.portal_auto.controller.saas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.rocknrolla.portal_auto.service.CarFleetService;

@RestController
@RequestMapping("/carFleet")
public class CarFleetController {


    @Autowired
    private CarFleetService carFleetService;

    @RequestMapping(value = "/myFleet", method = RequestMethod.GET)
    public ResponseEntity getCarFleet() {
        return ResponseEntity.ok(carFleetService.getAuthenticatedUserFleet());
    }

}
