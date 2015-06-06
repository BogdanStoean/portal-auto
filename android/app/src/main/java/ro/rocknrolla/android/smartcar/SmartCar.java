package ro.rocknrolla.android.smartcar;

import android.app.Application;
import android.content.Intent;

import ro.rocknrolla.android.smartcar.services.SenzorsService;

public class SmartCar extends Application {

    @Override
    public void onCreate() {
        startService(new Intent(getBaseContext(), SenzorsService.class));
    }

}
