package ro.rocknrolla.portal_auto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.rocknrolla.portal_auto.controller.bean.CarRouteModel;
import ro.rocknrolla.portal_auto.controller.bean.ResponseModel;
import ro.rocknrolla.portal_auto.entities.CarHistory;
import ro.rocknrolla.portal_auto.entities.Sensor;
import ro.rocknrolla.portal_auto.repositories.CarHistoryRepository;
import ro.rocknrolla.portal_auto.travel_algorithm.CarHistoryBySensor;
import ro.rocknrolla.portal_auto.travel_algorithm.SensorPriority;
import ro.rocknrolla.portal_auto.travel_algorithm.impl.DefaultSensorScorer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Bogdan Stoean on 6/7/15.
 */
@Service
@Transactional
public class CarRouteCheckerService {

    @Autowired
    private CarHistoryRepository carHistoryRepository;

    @Autowired
    private DefaultSensorScorer defaultSensorScorer;

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

        Map<Long, List<CarHistory>> longListMap = CarHistoryBySensor.convertToMap(historyData);

        int counter = 0;
        int grade = 0;
        for (Map.Entry<Long, List<CarHistory>> entrySet : longListMap.entrySet()) {
            counter++;
            Long key = entrySet.getKey();
            Sensor sensor = entrySet.getValue().get(0).getSensor();
            if (sensor.getId() == 1 || sensor.getId() == 3 || sensor.getId() == 4 || sensor.getId() == 5 || sensor.getId() == 10) {
                grade = defaultSensorScorer.scoreIt(entrySet.getValue(), SensorPriority.CRITICAL);
                if (grade == 0) {
                    ResponseModel responseModel = new ResponseModel();
                    responseModel.setStatus("Nu se pleaca");
                    responseModel.setMessage("Cel putin un senzor Important are probleme: " + sensor.getName());
                    return responseModel;
                }
            } else if (sensor.getId() == 7 || sensor.getId() == 9 || sensor.getId() == 11) {
                grade = defaultSensorScorer.scoreIt(entrySet.getValue(), SensorPriority.MEDIUM);
            } else {
                grade = defaultSensorScorer.scoreIt(entrySet.getValue(), SensorPriority.LOW);
            }

        }
        if (counter == 0) {
            ResponseModel responseModel = new ResponseModel();
            responseModel.setStatus("Masina este noua");
            responseModel.setMessage("Nu trebuie sa fie nici o problema in urmatoarea perioada");
            return responseModel;
        }
        int i = grade / counter;
        if (i > 50) {
            ResponseModel responseModel = new ResponseModel();
            responseModel.setStatus("Masina este OK");
            responseModel.setMessage("Nu ar trebui sa apara probleme in aceasta cursa");
            return responseModel;
        } else if (i < 50 || i > 30) {
            ResponseModel responseModel = new ResponseModel();
            responseModel.setStatus("Masina este functionala");
            responseModel.setMessage("O revizie un viitorul apropiat este indicata");
            return responseModel;
        } else {
            ResponseModel responseModel = new ResponseModel();
            responseModel.setStatus("Nu se pleaca");
            responseModel.setMessage("Masina a obtinut un punctaj foarte mic. Se recomanda o revizie generala");
            return responseModel;
        }


//        insert into sensor (sensor_id, name, type,alert_message) VALUES (1,'ulei','Percentage','Trebuie sa adaugi apa de parbriz');
//        insert into sensor (sensor_id, name, type,alert_message) VALUES (2,'apa de parbriz!','Percentage','Trebuie sa adaugi apa de parbriz');
//        insert into sensor (sensor_id, name, type,alert_message) VALUES (3,'antigel','Percentage','Atentie, adauga antigel');
//        insert into sensor (sensor_id, name, type,alert_message) VALUES (4,'placute frane','Status','Placutele de frane sunt pe duca');
//        insert into sensor (sensor_id, name, type,alert_message) VALUES (5,'disc frana','Status','Discurile de frane sunt pe duca');
//        insert into sensor (sensor_id, name, type,alert_message) VALUES (6,'carburant','Liters','Trebuie sa faci plinul in curand');
//        insert into sensor (sensor_id, name, type,alert_message) VALUES (7,'cauciucuri uzura','Percentage','Cauciucurile necesita inlocuire');
//        insert into sensor (sensor_id, name, type,alert_message) VALUES (8,'gradul de uzura la bateriei','Percentage','Bateria o sa te lase in curand');
//        insert into sensor (sensor_id, name, type,alert_message) VALUES (9,'abs','Status','ABS-ul are nevoie de verificare');
//        insert into sensor (sensor_id, name, type,alert_message) VALUES (10,'motor','Status','Motorul are nevoie de verificare');
//        insert into sensor (sensor_id, name, type,alert_message) VALUES (11,'servo directie','Status','Servo-directia are probleme');
//        insert into sensor (sensor_id, name, type,alert_message) VALUES (12,'senzori ploaie','Status','Senzorii de ploaie nu mai functioneaza');
//        insert into sensor (sensor_id, name, type,alert_message) VALUES (13,'pozitie','Status','Senzorii de positie au probleme');
//        insert into sensor (sensor_id, name, type,alert_message) VALUES (14,'faruri','Status','Senzorii de faruri au probleme');
//        insert into sensor (sensor_id, name, type,alert_message) VALUES (15,'parcare','Status','Senzorii de faruri au probleme');
//        insert into sensor (sensor_id, name, type,alert_message) VALUES (16,'km','Number','Meh?!?');

    }
}
