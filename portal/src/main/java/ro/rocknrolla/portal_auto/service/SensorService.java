package ro.rocknrolla.portal_auto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.rocknrolla.portal_auto.entities.Sensor;
import ro.rocknrolla.portal_auto.repositories.SensorRepository;

import java.util.List;

/**
 * Created by Bogdan Stoean on 6/6/15.
 */
@Service
@Transactional
public class SensorService {


    @Autowired
    private SensorRepository sensorRepository;

    public List<Sensor> listAll() {
        return sensorRepository.findAll();
    }
}
