package ro.rocknrolla.portal_auto.controller.bean;

import java.io.Serializable;

/**
 * Created by Bogdan Stoean on 6/7/15.
 */
public class CarRouteModel implements Serializable {


    private Long carId;
    private Double distance;

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}
