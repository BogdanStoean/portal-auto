package ro.rocknrolla.portal_auto.signup.bean;

/**
 * Created by Bogdan Stoean on 6/6/15.
 */
public class CarSensorCriticalValueModel {

    private Long id;

    private Long carId;

    private Long sensorId;

    private String value;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}