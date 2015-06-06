package ro.rocknrolla.portal_auto.controller.bean;

import ro.rocknrolla.portal_auto.entities.CarSensorCriticalValue;
import ro.rocknrolla.portal_auto.entities.Sensor;

/**
 * Created by Bogdan Stoean on 6/6/15.
 */
public class CarSensorCriticalValueModel {

    private Long id;

    private Long carId;

    private Long sensorId;

    private String sensorName;

    private String sensorType;

    private String criticalValue;

    public CarSensorCriticalValueModel() {

    }

    public CarSensorCriticalValueModel(CarSensorCriticalValue carSensorCriticalValue) {
        this.id = carSensorCriticalValue.getId();
        this.carId = carSensorCriticalValue.getCar().getId();
        this.sensorId = carSensorCriticalValue.getSensor().getId();
        this.criticalValue = carSensorCriticalValue.getValue();
        this.sensorName = carSensorCriticalValue.getSensor().getName();
        this.sensorType = carSensorCriticalValue.getSensor().getType();
    }

    public CarSensorCriticalValueModel(Sensor sensor, Long carId) {
        this.sensorId = sensor.getId();
        this.sensorName = sensor.getName();
        this.sensorType = sensor.getType();
        this.carId = carId;
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

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }
}
