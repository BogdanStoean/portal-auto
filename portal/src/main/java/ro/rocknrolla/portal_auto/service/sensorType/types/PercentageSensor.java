package ro.rocknrolla.portal_auto.service.sensorType.types;

import org.springframework.stereotype.Component;
import ro.rocknrolla.portal_auto.service.sensorType.SensorType;

@Component
public class PercentageSensor implements SensorType {
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
        Integer current = Integer.valueOf(currentValue);
        Integer critycle = Integer.valueOf(criticleValue);
        if (current < critycle) {
            return SensorCurrentStatusMessage.ALERT.name();
        } else if (current - critycle < 50) {
            return SensorCurrentStatusMessage.WARNING.name();
        } else {
            return SensorCurrentStatusMessage.OK.name();
        }
    }
}
