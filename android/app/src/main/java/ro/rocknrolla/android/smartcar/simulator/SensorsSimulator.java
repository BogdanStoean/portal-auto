package ro.rocknrolla.android.smartcar.simulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ro.rocknrolla.common.SensorDTO;

public class SensorsSimulator {
    private static SensorsSimulator instance = null;
    private final List<String> percentSensors = Arrays.asList(
            "ulei",
            "apa de parbriz!",
            "antigel",
            "placute frane",
            "disc frana",
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
            "pozitie",
            "faruri",
            "parcare"
    );

    protected SensorsSimulator() {
    }
    public static SensorsSimulator getInstance() {
        if(instance == null) {
            instance = new SensorsSimulator();
        }
        return instance;
    }

    public List<SensorDTO> getSensors() {
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

        return result;
    }

    private static int getRandomInteger(int maximum, int minimum){
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }
}
