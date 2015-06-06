package ro.rocknrolla.android.smartcar;

import android.app.Application;
import android.content.Intent;
import android.provider.Settings;

import java.util.ArrayList;
import java.util.List;

import ro.rocknrolla.android.smartcar.services.SenzorsService;
import ro.rocknrolla.common.CarActualDataDTO;

public class SmartCar extends Application {

    public static String android_id;

    @Override
    public void onCreate() {
        android_id = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        startService(new Intent(getBaseContext(), SenzorsService.class));
    }

}
