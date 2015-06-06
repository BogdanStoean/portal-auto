package ro.rocknrolla.android.smartcar.utils;

import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import ro.rocknrolla.android.smartcar.SmartCar;
import ro.rocknrolla.android.smartcar.api.ApiService;
import ro.rocknrolla.common.CarActualDataDTO;
import ro.rocknrolla.common.SensorActualDataComparator;
import ro.rocknrolla.common.SensorActualDataDTO;

public class StatusCar {
    private static StatusCar instance = null;
    private List<SensorActualDataDTO> list = new ArrayList<>();

    protected StatusCar() {}

    public static StatusCar getInstance() {
        if(instance == null) {
            instance = new StatusCar();
        }
        return instance;
    }

    public List<SensorActualDataDTO> getList() {
        return list;
    }

    public void refresh(final Callable callback) {
        ApiService.getInstance().getCarStatus(SmartCar.android_id, new Callback<CarActualDataDTO>() {
            @Override
            public void success(CarActualDataDTO carActualDataDTOs, Response response) {
                list = carActualDataDTOs.getSensorDisplayDTOs();
                Collections.sort(list, new SensorActualDataComparator());
                try {
                    callback.call();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
