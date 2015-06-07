package ro.rocknrolla.portal_auto.controller.bean;

import java.util.ArrayList;
import java.util.List;


public class CarFleetDTO {

    private List<CarStatusDTO> carFleet = new ArrayList<>();

    public List<CarStatusDTO> getCarFleet() {
        return carFleet;
    }

    public void setCarFleet(List<CarStatusDTO> carFleet) {
        this.carFleet = carFleet;
    }
}
