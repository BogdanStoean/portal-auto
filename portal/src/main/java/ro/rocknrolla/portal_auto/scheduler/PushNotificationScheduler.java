package ro.rocknrolla.portal_auto.scheduler;

import org.parse4j.Parse;
import org.parse4j.ParseException;
import org.parse4j.ParsePush;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ro.rocknrolla.common.CarActualDataDTO;
import ro.rocknrolla.common.SensorActualDataDTO;
import ro.rocknrolla.portal_auto.entities.Car;
import ro.rocknrolla.portal_auto.repositories.CarRepository;
import ro.rocknrolla.portal_auto.service.CarActualDataService;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Bogdan Stoean on 6/7/15.
 */
@Service
public class PushNotificationScheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(PushNotificationScheduler.class);
    private static final String PREFIX = "parse_";

    @Value("${com.parse.api_id}")
    private String applicationId;


    @Value("${com.parse.api_key}")
    private String apiKey;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarActualDataService carActualDataService;

    @PostConstruct
    protected void init() {
        Parse.initialize(applicationId, apiKey);
    }


    @Scheduled(fixedRate = 20000)
    public void pushNotifications() {

        LOGGER.info("Analyzing latest car information ...");

        List<Car> cars = carRepository.findByActiveTrue();

        for (Car car : cars) {
            CarActualDataDTO carActualDataDTO = carActualDataService.getIt(car.getDeviceUUID());
            List<SensorActualDataDTO> sensorActualDataDTOs = carActualDataDTO.getSensorDisplayDTOs();
            for (SensorActualDataDTO sensorActualDataDTO : sensorActualDataDTOs) {
                if ("ALERT".equalsIgnoreCase(sensorActualDataDTO.getStatus())) {
                    sendNotification(sensorActualDataDTO.getMesaj(), car.getDeviceUUID());
                }
            }
        }
    }


    /**
     * Send notification.
     *
     * @param message    - message to be sent.
     * @param deviceUUID - device id.
     */
    private void sendNotification(String message, String deviceUUID) {
        ParsePush push = new ParsePush();
        push.setMessage(message);
        push.setChannel(PREFIX + deviceUUID);
        try {
            LOGGER.info("Sending notification to device: " + deviceUUID);
            push.send();
        } catch (ParseException e) {
            LOGGER.error("Error sending notification: ", e);
        }
    }
}
