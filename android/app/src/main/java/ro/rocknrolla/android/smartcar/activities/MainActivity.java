package ro.rocknrolla.android.smartcar.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.parse.ParsePush;
import java.util.concurrent.Callable;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import ro.rocknrolla.android.smartcar.R;
import ro.rocknrolla.android.smartcar.SmartCar;
import ro.rocknrolla.android.smartcar.api.ApiService;
import ro.rocknrolla.android.smartcar.utils.StatusCar;


public class MainActivity extends Activity {

    private FrameLayout frameLayout;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.retrie);
        TextView splashTitle = (TextView) findViewById(R.id.splashTitle);
        splashTitle.setText(Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID));
        frameLayout = (FrameLayout) findViewById(R.id.register);
        progressBar = (ProgressBar) findViewById(R.id.progressSmoothBar);

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
        progressBar.setVisibility(View.VISIBLE);
        //check car device on server
        ApiService.getInstance().checkCar(
                SmartCar.android_id,
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

        StatusCar.getInstance().refresh(new Callable() {
            @Override
            public Object call() throws Exception {
                // add car id to parse
                ParsePush.subscribeInBackground("parse_"+SmartCar.android_id);

                //intent the status view
                Intent statusActiviti = new Intent(getApplicationContext(), StatusActivity.class);
                statusActiviti.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(statusActiviti);

                progressBar.setVisibility(View.GONE);
                finish();
                return null;
            }
        });
    }

    private void showRegister() {
        progressBar.setVisibility(View.GONE);
        frameLayout.setVisibility(View.VISIBLE);
    }

}
