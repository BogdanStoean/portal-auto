package ro.rocknrolla.android.smartcar.activities;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;

import ro.rocknrolla.android.smartcar.R;
import ro.rocknrolla.android.smartcar.ui.StatusListAdapter;
import ro.rocknrolla.android.smartcar.utils.StatusCar;
import ro.rocknrolla.common.SensorActualDataDTO;

public class StatusActivity extends Activity {

    public static final long NOTIFY_INTERVAL = 5 * 60 * 1000; // 5 minutes
    private Handler mHandler = new Handler();
    private Timer mTimer;

    private ArrayAdapter<SensorActualDataDTO> entitiesAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        listView = (ListView) findViewById(R.id.listView);

        // create the adapter
        entitiesAdapter = new StatusListAdapter(this, R.layout.listview_item_status, StatusCar.getInstance().getList());

        // set the adapter to the listview
        listView.setAdapter(entitiesAdapter);

        // cancel if already existed
        if(mTimer != null) {
            mTimer.cancel();
        } else {
            // recreate new
            mTimer = new Timer();
        }
        // schedule task
        mTimer.scheduleAtFixedRate(new TimeStatusTask(), 0, NOTIFY_INTERVAL);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mTimer != null) {
            mTimer.cancel();
        }
    }

    class TimeStatusTask extends TimerTask {

        @Override
        public void run() {
            // run on another thread
            mHandler.post(new Runnable() {

                @Override
                public void run() {
                    StatusCar.getInstance().refresh(new Callable() {
                        @Override
                        public Object call() throws Exception {
                            entitiesAdapter.notifyDataSetChanged();
                            return null;
                        }
                    });
                }

            });
        }

    }



}
