package com.example.alarmclock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.widget.Toast;

public class broadcast extends BroadcastReceiver {
    Vibrator v;
    @Override
    public void onReceive(Context context, Intent intent) {

     //  Toast.makeText(context, "time", Toast.LENGTH_LONG).show();
        v = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(3000);
       Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);

          Ringtone ringtone = RingtoneManager.getRingtone(context, uri);
         ringtone.play();

    }
}
