package ro.rocknrolla.portal_auto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.rocknrolla.portal_auto.controller.bean.CarModel;
import ro.rocknrolla.portal_auto.entities.Car;
import ro.rocknrolla.portal_auto.repositories.CarRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Flori on 06.06.2015.
 */

@Service
@Transactional
public class UserCarService {

    @Autowired
    private CarRepository carRepository;

    public List<CarModel> getUserCars(String userEmail){
        List<Car> cars =  carRepository.findByUserEmail(userEmail);
        List<CarModel> results = new ArrayList<>();
        for (Car car : cars) {
            results.add(new CarModel(car));
        }
        return results;
    }
}
