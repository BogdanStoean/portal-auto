package ro.rocknrolla.common;

import java.io.Serializable;
import java.util.List;


/**
 * Class used to transport a set of sensor values for a device.
 */
public class CarParametersDTO implements Serializable {


    private String deviceId;

    private List<SensorDTO> sensors;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public List<SensorDTO> getSensors() {
        return sensors;
    }

    public void setSensors(List<SensorDTO> sensors) {
        this.sensors = sensors;
    }
}
