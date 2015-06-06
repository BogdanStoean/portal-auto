package ro.rocknrolla.portal_auto.entities;

import javax.persistence.*;

@Entity
public class Sensor extends AbstractEntity<User>{

    @Id
    @Column(name = "SENSOR_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SENSOR_SEQ_GEN")
    @SequenceGenerator(name = "SENSOR_SEQ_GEN", sequenceName = "SENSOR_ID_SEQ", allocationSize = 1)
    private Long id;

    private String name;
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
