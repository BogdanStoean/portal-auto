package ro.rocknrolla.portal_auto.controller.bean;

import java.io.Serializable;

public class SensorStatusDTO implements Serializable{

    private String name;
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
