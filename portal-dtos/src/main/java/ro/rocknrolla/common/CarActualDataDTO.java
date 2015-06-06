package ro.rocknrolla.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class CarActualDataDTO implements Serializable {

    private List<SensorActualDataDTO> sensorDisplayDTOs = new ArrayList<>();

    public List<SensorActualDataDTO> getSensorDisplayDTOs() {
        return sensorDisplayDTOs;
    }

    public void setSensorDisplayDTOs(List<SensorActualDataDTO> sensorDisplayDTOs) {
        this.sensorDisplayDTOs = sensorDisplayDTOs;
    }
}
