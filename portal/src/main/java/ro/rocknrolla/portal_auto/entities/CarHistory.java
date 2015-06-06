package ro.rocknrolla.portal_auto.entities;

import javax.persistence.*;

@Entity
public class CarHistory extends AbstractEntity<CarHistory> {

    @Id
    @Column(name = "CAR_HISTORY_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAR_HISTORY_SEQ_GEN")
    @SequenceGenerator(name = "CAR_HISTORY_SEQ_GEN", sequenceName = "CAR_HISTORY_ID_SEQ", allocationSize = 1)
    private Long id;

    @JoinColumn(name = "car_id")
    @ManyToMany
    private Car car;

    @JoinColumn(name = "sensor_id")
    @ManyToMany
    private Sensor sensor;


}
