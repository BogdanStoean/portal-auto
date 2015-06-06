package ro.rocknrolla.portal_auto.controller.bean;

import ro.rocknrolla.portal_auto.entities.Car;

/**
 * Created by Flori on 06.06.2015.
 */
public class CarModel {

    private Long carId;

    private String name;

    private String deviceUUID;

    private boolean active;

    public CarModel() {
    }

    public CarModel(Car car) {
        this.carId = car.getId();
        this.name = car.getName();
        this.deviceUUID = car.getDeviceUUID();
        this.active = car.getActive();
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeviceUUID() {
        return deviceUUID;
    }

    public void setDeviceUUID(String deviceUUID) {
        this.deviceUUID = deviceUUID;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
