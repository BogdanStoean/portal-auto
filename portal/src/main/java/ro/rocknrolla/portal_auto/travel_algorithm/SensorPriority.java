package ro.rocknrolla.portal_auto.travel_algorithm;


public enum SensorPriority {
    CRITICAL {
        @Override
        public double getPoints() {
            return 1;
        }
    }, MEDIUM {
        @Override
        public double getPoints() {
            return 0.6;
        }
    }, LOW {
        @Override
        public double getPoints() {
            return 0.2;
        }
    };


    public abstract double getPoints();
}
