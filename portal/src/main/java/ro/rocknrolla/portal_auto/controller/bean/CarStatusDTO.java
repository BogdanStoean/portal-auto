package ro.rocknrolla.portal_auto.controller.bean;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CarStatusDTO implements Serializable {
    private String carUUID;
    private String name;
    private List<SensorStatusDTO> sensorStatusDTOs = new ArrayList<>();

    public String getCarUUID() {
        return carUUID;
    }

    public void setCarUUID(String carUUID) {
        this.carUUID = carUUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SensorStatusDTO> getSensorStatusDTOs() {
        return sensorStatusDTOs;
    }

    public void setSensorStatusDTOs(List<SensorStatusDTO> sensorStatusDTOs) {
        this.sensorStatusDTOs = sensorStatusDTOs;
    }
}
