package ro.rocknrolla.common;

import java.util.Comparator;

public class SensorActualDataComparator implements Comparator<SensorActualDataDTO> {

    @Override
    public int compare(SensorActualDataDTO o1, SensorActualDataDTO o2) {
        String status1 = o1.getStatus();
        String status2 = o2.getStatus();

        if (status1 == null) {
            return -1;
        }
        if (status2 == null) {
            return 1;
        }

        if(!status1.equalsIgnoreCase(status2)) {
            if (status1.equalsIgnoreCase("alert"))
                return -1;
            else if (status2.equalsIgnoreCase("alert"))
                return 1;
            else if(status2.equalsIgnoreCase("ok"))
                return -1;
            else
                return 1;
        }

        return 0;

    }

}
