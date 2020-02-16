package com.example.alarmclock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class Show extends AppCompatActivity  {
    RecyclerView recyclerView;
    ArrayList<Array> arrays ;
    Context context;
    int i= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        recyclerView = (RecyclerView)findViewById(R.id.recyclev);



        Readapter adapter = new Readapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if (null== arrays){
            arrays = new ArrayList<>();
        }

      Intent intent = getIntent();

try {

     String x = String.valueOf(intent.getIntExtra("cmm", 0));

     Toast.makeText(this, x, Toast.LENGTH_LONG).show();

}catch (Exception e){
    Toast.makeText(this, String.valueOf(e), Toast.LENGTH_SHORT).show();
   /* arrays.add(new Array(1, ch, cm));
    arrays.add(new Array(2, ch, cm));
    arrays.add(new Array(3, ch, cm));*/
}


    adapter.setArrays(arrays);




    }
}
