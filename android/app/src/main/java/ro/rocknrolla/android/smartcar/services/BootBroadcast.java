package ro.rocknrolla.android.smartcar.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.parse.PushService;

public class BootBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context ctx, Intent intent) {
        ctx.startService(new Intent(ctx, SenzorsService.class));
        ctx.startService(new Intent(ctx, PushService.class));
    }

}
