package ro.rocknrolla.portal_auto.entities;

import javax.persistence.*;

/**
 * Created by Bogdan Stoean on 6/6/15.
 */
@Entity
public class CarSensorCriticalValue {


    @Id
    @Column(name = "CAR_SENSOR_CRITICAL_VALUE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAR_SENSOR_CRITICAL_VALUE_SEQ_GEN")
    @SequenceGenerator(name = "CAR_SENSOR_CRITICAL_VALUE_SEQ_GEN", sequenceName = "CAR_SENSOR_CRITICAL_VALUE_SEQ", allocationSize = 1)
    private Long id;


    @ManyToOne
    private Sensor sensor;

    @ManyToOne
    private Car car;


    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
