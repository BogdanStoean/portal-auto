package ro.rocknrolla.portal_auto.entities;

import javax.persistence.*;

@Entity
public class Car extends AbstractEntity<User> {

    @Id
    @Column(name = "CAR_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAR_SEQ_GEN")
    @SequenceGenerator(name = "CAR_SEQ_GEN", sequenceName = "CAR_ID_SEQ", allocationSize = 1)
    private Long id;

    private String name;
    private String deviceUUID;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    private boolean active;

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

    public String getDeviceUUID() {
        return deviceUUID;
    }

    public void setDeviceUUID(String deviceUUID) {
        this.deviceUUID = deviceUUID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
