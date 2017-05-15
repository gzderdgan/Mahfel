package com.example.gzde.locationapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {


    ImageButton dans,ceyiz,not,davetli,salon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dans=(ImageButton)findViewById(R.id.bdans);
        ceyiz=(ImageButton)findViewById(R.id.bceyiz);
        not=(ImageButton)findViewById(R.id.bnot);
        davetli=(ImageButton)findViewById(R.id.bdavetli);
        salon=(ImageButton)findViewById(R.id.bsalon);

        salon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), MapsActivity.class);
                   startActivity(intent);
            }
        });
        dans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), DansMuzik.class);
                startActivity(intent);
            }
        });

        ceyiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), Ceyiz.class);
                startActivity(intent);
            }
        });

        davetli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), DavetliListem.class);
                startActivity(intent);
            }
        });

        not.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), Notlar.class);
                startActivity(intent);
            }
        });

    }
}
