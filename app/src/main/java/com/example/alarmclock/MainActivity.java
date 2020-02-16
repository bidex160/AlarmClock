package com.example.alarmclock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    Button addb, button2;
    RecyclerView recyclerView;
    Readapter readapter;
    TextView txt;
    int i = 0;
    Array inc;

  private static ArrayList<Array> arrays;

  /*  @Override
    protected void onStart() {

        fragmetdialog fragmetdialog = new fragmetdialog();

        fragmetdialog.show(getSupportFragmentManager(), "Alarm");
        super.onStart();
    }
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (arrays == null){
            arrays = new ArrayList<>();
        }

        txt = (TextView)findViewById(R.id.textView);
        addb = (Button)findViewById(R.id.addbutt);
        recyclerView =(RecyclerView)findViewById(R.id.recy);
        readapter = new Readapter(this);
        recyclerView.setAdapter(readapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        readapter.setArrays(arrays);

          txt.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  fragmetdialog fragmetdialog = new fragmetdialog();

                  fragmetdialog.show(getSupportFragmentManager(), "Alarm");

              }
          });



        addb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, setalarm.class);
                startActivity(intent);


            }
        });

        try {
            Intent intent = getIntent();
           int w = intent.getIntExtra("rh", -1);
            int z = intent.getIntExtra("rm", -1);


           if (w != -1 && z != -1){

               for(Array a:arrays){
                   if(a.getHours() == w && a.getMin() == z){

                        inc = a;
                       arrays.remove(inc);
                   }
               }
           }

        }catch (Exception e){

        }



try {

    Intent intent = getIntent();
    Bundle bundle = intent.getBundleExtra("bundle");

    if (bundle != null){

        i++;
        int ch = bundle.getInt("ch", -1);
        int cm = bundle.getInt("cmm", -1);
        int request = bundle.getInt("requestcode", -1);
        if (ch != -1 && cm != -1 ) {

            Array array = new Array(i,ch, cm);
            Toast.makeText(this, String.valueOf(request), Toast.LENGTH_LONG).show();

            arrays.add(array);

            readapter.setArrays(arrays);


        }

    }else {

    }
}catch (Exception e){

}












    }


}
