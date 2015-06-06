package ro.rocknrolla.portal_auto.service.sensorType;

public interface SensorType {
    String computeValue(String currentValue);

    String computeByCriticleValue(String currentValue, String criticleValue);
    String getStatusByCriticleValue(String currentValue, String criticleValue);
}
