package ro.rocknrolla.portal_auto;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ro.rocknrolla.portal_auto.entities.CarEntity;
import ro.rocknrolla.portal_auto.entities.User;
import ro.rocknrolla.portal_auto.repositories.CarRepository;

import java.util.List;

/**
 * Created by Flori on 06.06.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ActiveProfiles("test")
public class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Test
    public void testFindByUserName() {
        List<CarEntity> cars = carRepository.findByUserEmail("admin@portal_auto.ro");
        Assert.assertEquals(0, cars.size());

    }
}
