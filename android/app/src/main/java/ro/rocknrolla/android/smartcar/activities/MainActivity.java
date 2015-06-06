package ro.rocknrolla.android.smartcar.activities;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import ro.rocknrolla.android.smartcar.R;
import ro.rocknrolla.android.smartcar.api.ApiService;


public class MainActivity extends Activity {

    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.retrie);
        TextView splashTitle = (TextView) findViewById(R.id.splashTitle);
        splashTitle.setText(Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID));
        frameLayout = (FrameLayout) findViewById(R.id.register);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frameLayout.setVisibility(View.GONE);
                checkcar();
            }
        });

        checkcar();

    }

    private void checkcar() {
        //todo: check car device on server
        ApiService.getInstance().checkCar(
                Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID),
                new Callback<Object>() {
                    @Override
                    public void success(Object o, Response response) {
                        if(response.getStatus() == 200) {
                            gotoHome();
                        }
                        else {
                            showRegister();
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        showRegister();
                    }
                });
    }

    private void gotoHome() {
        SharedPreferences sharedPreferences = getSharedPreferences("ro.rocknrolla.android.smartcar", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("approved", true);
        editor.commit();
        //todo: intent the app home view
    }

    private void showRegister() {
        frameLayout.setVisibility(View.VISIBLE);
    }

}
