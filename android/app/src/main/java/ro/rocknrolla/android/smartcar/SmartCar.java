package ro.rocknrolla.android.smartcar;

import android.app.Application;
import android.content.Intent;
import android.provider.Settings;
import com.parse.Parse;
import com.parse.ParseInstallation;
import ro.rocknrolla.android.smartcar.services.SenzorsService;

public class SmartCar extends Application {

    public static String android_id;

    @Override
    public void onCreate() {
        android_id = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

        // init Parse
        Parse.initialize(this, getString(R.string.parse_application_id),
                getString(R.string.parse_client_key));

        // Save the current Installation to Parse.
        ParseInstallation.getCurrentInstallation().saveInBackground();

        startService(new Intent(getBaseContext(), SenzorsService.class));
    }

}
