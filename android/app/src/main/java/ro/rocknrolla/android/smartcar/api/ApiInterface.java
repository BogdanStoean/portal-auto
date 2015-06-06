package ro.rocknrolla.android.smartcar.api;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import ro.rocknrolla.common.CarActualDataDTO;
import ro.rocknrolla.common.CarParametersDTO;

public interface ApiInterface {

    @POST("/carinformation")
    void sendCarInformation(@Body CarParametersDTO car, Callback<Object> callback);

    @GET("/checkcar/{carId}")
    void checkCar(@Path("carId") String carId, Callback<Object> callback);

    @GET("/getActualDataForCar/{carId}")
    void getCarStatus(@Path("carId") String carId, Callback<CarActualDataDTO> callback);
}
