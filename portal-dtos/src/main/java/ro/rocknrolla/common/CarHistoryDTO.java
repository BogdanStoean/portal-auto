package ro.rocknrolla.common;

import java.io.Serializable;

public class CarHistoryDTO implements Serializable {


    private CarDTO car;

    private SensorDTO sensor;

    private Object value;


    public CarDTO getCar() {
        return car;
    }

    public void setCar(CarDTO car) {
        this.car = car;
    }

    public SensorDTO getSensor() {
        return sensor;
    }

    public void setSensor(SensorDTO sensor) {
        this.sensor = sensor;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
