package com.example.alarmclock;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Calendar;

public class setalarm extends AppCompatActivity {
    Button setbt;
    EditText editText, editTextMin;
    int currenth, currentm,i=0;
    PendingIntent pendingIntent;
  //  Readapter readapter;

    Context context;
    Readapter readapter;
     ArrayList<Array> alarmarrays ;
    int reques =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setalarm);


      readapter = new Readapter(context);
        editText = (EditText)findViewById(R.id.houredit);
        editTextMin =(EditText)findViewById(R.id.medit);
        setbt = (Button)findViewById(R.id.stx);

        if (null == alarmarrays){
            alarmarrays = new ArrayList<>();
        }

        setbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                currenth = Integer.valueOf(String.valueOf(editText.getText()));
                currentm = Integer.valueOf(String.valueOf(editTextMin.getText()));








                xy();
           // /*    if (null != String.valueOf(currenth) && null != String.valueOf(currentm)) {

               if (reques != 0){
                   reques++;
                   Intent intent = new Intent(setalarm.this, MainActivity.class);
                   Bundle bundle = new Bundle();
                   bundle.putInt("ch", currenth);
                   bundle.putInt("cmm", currentm);
                   bundle.putInt("requestcode", reques);

                   intent.putExtra("bundle", bundle);
                   startActivity(intent);
               }


            }
        });





    }
    public void xy(){
        if (null != String.valueOf(currenth) && null != String.valueOf(currentm)){

            i++;




            Calendar c = Calendar.getInstance();
            c.set(Calendar.HOUR, currenth);
            c.set(Calendar.MINUTE, currentm);


            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            Intent intentx = new Intent(this, broadcast.class);
            pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 1, intentx,0);
            alarmManager.set(AlarmManager.RTC_WAKEUP, c.getTime().getTime(), pendingIntent);

            Intent intent = new Intent(this, fragmetdialog.class);
            intent.putExtra("ch", currenth);
            intent.putExtra("cm", currentm);






          //  alarmManager.setRepeating(R);



        }

    }


}