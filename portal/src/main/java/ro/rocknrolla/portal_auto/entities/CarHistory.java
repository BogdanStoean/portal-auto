package ro.rocknrolla.portal_auto.entities;

import javax.persistence.*;

@Entity
public class CarHistory extends AbstractEntity<User> {

    @Id
    @Column(name = "CAR_HISTORY_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAR_HISTORY_SEQ_GEN")
    @SequenceGenerator(name = "CAR_HISTORY_SEQ_GEN", sequenceName = "CAR_HISTORY_ID_SEQ", allocationSize = 1)
    private Long id;

    @JoinColumn(name = "car_id")
    @ManyToOne
    private Car car;

    @JoinColumn(name = "sensor_id")
    @ManyToOne
    private Sensor sensor;

    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
