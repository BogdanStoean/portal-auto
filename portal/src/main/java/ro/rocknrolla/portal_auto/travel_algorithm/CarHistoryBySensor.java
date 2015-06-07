package ro.rocknrolla.portal_auto.travel_algorithm;


import ro.rocknrolla.portal_auto.entities.CarHistory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class CarHistoryBySensor {

    private CarHistoryBySensor(){
    }

    public static Map<Long, List<CarHistory>> convertToMap(List<CarHistory> historyData) {
        Map<Long, List<CarHistory>> sensorHistoryData = new HashMap<>();

        for (CarHistory carHistory : historyData) {
            if (sensorHistoryData.get(carHistory.getSensor().getId()) != null) {
                sensorHistoryData.get(carHistory.getSensor().getId()).add(carHistory);
            } else {
                List<CarHistory> list = new ArrayList<>();
                list.add(carHistory);
                sensorHistoryData.put(carHistory.getSensor().getId(), list);
            }
        }

        return sensorHistoryData;
    }


}
