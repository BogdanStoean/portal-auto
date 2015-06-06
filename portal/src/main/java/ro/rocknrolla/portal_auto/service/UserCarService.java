package ro.rocknrolla.portal_auto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.rocknrolla.portal_auto.controller.bean.CarModel;
import ro.rocknrolla.portal_auto.entities.Car;
import ro.rocknrolla.portal_auto.exception.ServerEntityNotFoundException;
import ro.rocknrolla.portal_auto.repositories.CarRepository;
import ro.rocknrolla.portal_auto.repositories.UserRepository;
import ro.rocknrolla.portal_auto.security.CurrentAuthenticatedUser;

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

    @Autowired
    private UserRepository userRepository;

    public List<CarModel> getUserCars(String userEmail) {
        List<Car> cars = carRepository.findByUserEmail(userEmail);
        List<CarModel> results = new ArrayList<>();
        for (Car car : cars) {
            results.add(new CarModel(car));
        }
        return results;
    }

    public void create(CarModel carModel) {

        Car car;

        if (carModel.getCarId() != null) {
            car = carRepository.findOne(carModel.getCarId());
        } else {
            car = new Car();
        }

        if (car == null) {
            throw new ServerEntityNotFoundException("id", "entity.not.found");
        }

        car.setActive(true);
        car.setDeviceUUID(carModel.getDeviceUUID());
        car.setName(carModel.getName());
        car.setUser(userRepository.findActiveByEmail(CurrentAuthenticatedUser.getUsername()));

        carRepository.save(car);
    }
}
