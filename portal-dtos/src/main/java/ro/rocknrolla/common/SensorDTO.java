package ro.rocknrolla.common;

import java.io.Serializable;


/**
 * Class used for sensor name and value transport.
 */
public class SensorDTO implements Serializable {


    private String name;
    private String value;


    public SensorDTO(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getValue() {
        return value;
    }


    public void setValue(String value) {
        this.value = value;
    }
}
