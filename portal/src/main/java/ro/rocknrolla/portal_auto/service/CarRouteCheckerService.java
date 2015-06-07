package ro.rocknrolla.portal_auto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.rocknrolla.portal_auto.controller.bean.CarRouteModel;
import ro.rocknrolla.portal_auto.controller.bean.ResponseModel;
import ro.rocknrolla.portal_auto.entities.CarHistory;
import ro.rocknrolla.portal_auto.repositories.CarHistoryRepository;
import ro.rocknrolla.portal_auto.travel_algorithm.CarHistoryBySensor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bogdan Stoean on 6/7/15.
 */
@Service
@Transactional
public class CarRouteCheckerService {

    @Autowired
    private CarHistoryRepository carHistoryRepository;

    public ResponseModel check(CarRouteModel carRouteModel) {
        List<CarHistory> records = carHistoryRepository.findRecordsByCarIdAndSensorIdGroupedByOPIdentifier(1l, 16l);
        Double tripDistance = carRouteModel.getDistance();
        int previousKM = 0;
        int currentKM = 0;
        List<String> recordsToSearch = new ArrayList<>();

        for (CarHistory carHistory : records) {

            currentKM = Integer.valueOf(carHistory.getValue());
            if (previousKM == 0) {
                previousKM = currentKM;
            }
            if (previousKM <= tripDistance && tripDistance <= currentKM || previousKM <= tripDistance && tripDistance >= currentKM) {
                break;
            }
            recordsToSearch.add(carHistory.getOperationIdentifier());
            previousKM = currentKM;
        }

        List<CarHistory> historyData = new ArrayList<>();
        for (String historyRecord : recordsToSearch) {
            historyData.addAll(carHistoryRepository.findByOperationIdentifier(historyRecord));
        }

        CarHistoryBySensor.convertToMap(historyData);

        return new ResponseModel("OK", "You are free to go!");
    }
}
