package ro.rocknrolla.portal_auto.service.sensorType.types;

import org.springframework.stereotype.Component;
import ro.rocknrolla.portal_auto.service.sensorType.SensorType;

@Component
public class LitersSensor implements SensorType {
    @Override
    public String computeValue(String currentValue) {
        return null;
    }

    @Override
    public String computeByCriticleValue(String currentValue, String criticleValue) {
        return null;
    }

    @Override
    public String getStatusByCriticleValue(String currentValue, String criticleValue) {
        return null;
    }
}
