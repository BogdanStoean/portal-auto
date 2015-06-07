package ro.rocknrolla.portal_auto.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.rocknrolla.portal_auto.controller.bean.CarRouteModel;
import ro.rocknrolla.portal_auto.controller.bean.ResponseModel;

/**
 * Created by Bogdan Stoean on 6/7/15.
 */
@Service
@Transactional
public class CarRouteCheckerService {

    public ResponseModel check(CarRouteModel carRouteModel) {
        return new ResponseModel("OK", "You are free to go!");
    }
}
