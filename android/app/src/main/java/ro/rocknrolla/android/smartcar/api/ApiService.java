package ro.rocknrolla.android.smartcar.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;

import java.util.Date;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class ApiService {

    private static final String API_URL = "http://9a12413e.ngrok.io/webservice";
//    private static final String API_URL = "http://67ec0592.ngrok.io/webservice";

    public static ApiInterface getInstance() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateTypeAdapter())
                .serializeNulls()
                .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(API_URL)
                .setConverter(new GsonConverter(gson))
                .build();

        return restAdapter.create(ApiInterface.class);
    }


}
