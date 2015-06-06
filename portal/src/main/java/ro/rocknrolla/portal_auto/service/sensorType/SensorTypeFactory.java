package ro.rocknrolla.portal_auto.service.sensorType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.rocknrolla.portal_auto.service.sensorType.types.LitersSensor;
import ro.rocknrolla.portal_auto.service.sensorType.types.NumberSensor;
import ro.rocknrolla.portal_auto.service.sensorType.types.PercentageSensor;
import ro.rocknrolla.portal_auto.service.sensorType.types.StatusSensor;

@Component
public class SensorTypeFactory {

    @Autowired
    private LitersSensor litersSensor;

    @Autowired
    private NumberSensor numberSensor;

    @Autowired
    private PercentageSensor percentageSensor;

    @Autowired
    private StatusSensor statusSensor;

    public String compute(String value, String criticleValue, String type) {
        return getSensorTypeForComputing(type).computeByCriticleValue(value, criticleValue);
    }

    public String getStatusByCriticleValue(String value, String criticleValue, String type) {
        return getSensorTypeForComputing(type).getStatusByCriticleValue(value, criticleValue);
    }

    private SensorType getSensorTypeForComputing(String type) {
        switch (type) {
            case "Percentage":
                return percentageSensor;
            case "Liters":
                return litersSensor;
            case "Status":
                return statusSensor;
            case "Number":
                return numberSensor;
            default:
                throw new RuntimeException("Unrecognized sensor type: " + type);
        }


    }


}
