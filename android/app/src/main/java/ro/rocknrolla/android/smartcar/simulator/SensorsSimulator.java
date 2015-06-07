package ro.rocknrolla.android.smartcar.simulator;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ro.rocknrolla.common.SensorDTO;

public class SensorsSimulator {
    private int km = 0;
    private static SensorsSimulator instance = null;
    private final List<String> percentSensors = Arrays.asList(
            "ulei",
            "apa de parbriz!",
            "antigel",
            "carburant",
            "cauciucuri uzura",
            "gradul de uzura la bateriei"
    );
    private final List<String> statusSensors = Arrays.asList("ok", "verificare", "defect");
    private final List<String> keySensors = Arrays.asList(
            "abs",
            "motor",
            "servo directie",
            "senzori ploaie",
            "placute frane",
            "disc frana",
            "pozitie",
            "faruri",
            "parcare"
    );

    protected SensorsSimulator() {
        km = km + getRandomInteger(100,10);
    }
    public static SensorsSimulator getInstance() {
        if(instance == null) {
            instance = new SensorsSimulator();
        }
        return instance;
    }

    public List<SensorDTO> getSensors() {
        km = km + getRandomInteger(10,1);
        List<SensorDTO> result = new ArrayList<>();
        SensorDTO s;
        //percent sensors
        for(String sensor : percentSensors) {
            s = new SensorDTO();
            s.setName(sensor);
            s.setValue(""+getRandomInteger(100, 0));
            result.add(s);
        }

        for(String sensor : keySensors) {
            s = new SensorDTO();
            s.setName(sensor);
            s.setValue(statusSensors.get(getRandomInteger(statusSensors.size() - 1, 0)));
            result.add(s);
        }
        s = new SensorDTO();
        s.setName("km");
        s.setValue(""+km);
        result.add(s);

        return result;
    }

    private static int getRandomInteger(int maximum, int minimum){
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }
}
