package ro.rocknrolla.portal_auto.controller.bean;

import ro.rocknrolla.portal_auto.entities.CarSensorCriticalValue;

/**
 * Created by Bogdan Stoean on 6/6/15.
 */
public class CarSensorCriticalValueModel {

    private Long id;

    private Long carId;

    private Long sensorId;

    private String criticalValue;

    public CarSensorCriticalValueModel(CarSensorCriticalValue carSensorCriticalValue) {
        this.id = carSensorCriticalValue.getId();
        this.carId = carSensorCriticalValue.getCar().getId();
        this.sensorId = carSensorCriticalValue.getSensor().getId();
        this.criticalValue = carSensorCriticalValue.getValue();
    }

    public CarSensorCriticalValueModel(Long sensorId, Long carId) {
        this.sensorId = sensorId;
        this.carId = carId;
    }

    public CarSensorCriticalValueModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getSensorId() {
        return sensorId;
    }

    public void setSensorId(Long sensorId) {
        this.sensorId = sensorId;
    }

    public String getCriticalValue() {
        return criticalValue;
    }

    public void setCriticalValue(String criticalValue) {
        this.criticalValue = criticalValue;
    }
}
