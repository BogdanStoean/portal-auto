package ro.rocknrolla.android.smartcar.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.IBinder;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import ro.rocknrolla.android.smartcar.SmartCar;
import ro.rocknrolla.android.smartcar.api.ApiService;
import ro.rocknrolla.android.smartcar.simulator.SensorsSimulator;
import ro.rocknrolla.common.CarParametersDTO;
import ro.rocknrolla.common.SensorDTO;

public class SenzorsService extends Service {

    private SharedPreferences sharedPreferences;

    public static final long NOTIFY_INTERVAL = 10 * 1000; // 10 seconds
    private Handler mHandler = new Handler();
    private Timer mTimer;

    @Override
    public void onCreate() {

        sharedPreferences = getSharedPreferences("ro.rocknrolla.android.smartcar", Context.MODE_PRIVATE);

        // cancel if already existed
        if(mTimer != null) {
            mTimer.cancel();
        } else {
            // recreate new
            mTimer = new Timer();
        }
        // schedule task
        mTimer.scheduleAtFixedRate(new TimeDisplayTimerTask(), 0, NOTIFY_INTERVAL);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        return Service.START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    class TimeDisplayTimerTask extends TimerTask {

        @Override
        public void run() {
            if(!sharedPreferences.getBoolean("approved", false)) return;
            // run on another thread
            mHandler.post(new Runnable() {

                @Override
                public void run() {
                    List<SensorDTO> sensors = SensorsSimulator.getInstance().getSensors();
                    CarParametersDTO car = new CarParametersDTO();
                    car.setDeviceId(SmartCar.android_id);
                    car.setSensors(sensors);
                    ApiService.getInstance().sendCarInformation(car, new Callback<Object>() {
                        @Override
                        public void success(Object o, Response response) {
                        }

                        @Override
                        public void failure(RetrofitError error) {
                        }
                    });
                }

            });
        }

    }
}
