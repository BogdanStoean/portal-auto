package ro.rocknrolla.portal_auto.travel_algorithm;


public enum SensorPriority {
    CRITICAL {
        @Override
        double getPoints() {
            return 1;
        }
    }, MEDIUM {
        @Override
        double getPoints() {
            return 0.6;
        }
    }, LOW {
        @Override
        double getPoints() {
            return 0.2;
        }
    };

    abstract double getPoints();
}
