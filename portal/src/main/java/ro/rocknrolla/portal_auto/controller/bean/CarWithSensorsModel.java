package ro.rocknrolla.portal_auto.controller.bean;

import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Flori on 06.06.2015.
 */
public class CarWithSensorsModel {

    private CarModel carModel;

    private List<CarSensorCriticalValueModel> sensorsList;

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public List<CarSensorCriticalValueModel> getSensorsList() {
        return sensorsList;
    }

    public void setSensorsList(List<CarSensorCriticalValueModel> sensorsList) {
        this.sensorsList = sensorsList;
    }
}
