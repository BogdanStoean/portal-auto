package ro.rocknrolla.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class CarParameterDisplayDTO implements Serializable {

    private List<SensorDisplayDTO> sensorDisplayDTOs = new ArrayList<>();

    public List<SensorDisplayDTO> getSensorDisplayDTOs() {
        return sensorDisplayDTOs;
    }

    public void setSensorDisplayDTOs(List<SensorDisplayDTO> sensorDisplayDTOs) {
        this.sensorDisplayDTOs = sensorDisplayDTOs;
    }
}
