package ro.rocknrolla.portal_auto.entities;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Document extends AbstractEntity<User> {

    @Id
    @Column(name = "DOCUMENT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DOCUMENT_SEQ_GEN")
    @SequenceGenerator(name = "DOCUMENT_SEQ_GEN", sequenceName = "DOCUMENT_ID_SEQ", allocationSize = 1)
    private Long id;

    @JoinColumn(name = "car_id")
    @ManyToOne
    private Car car;

    private String name;
    private Date activationDate;
    private Date expirationDate;

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

    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
