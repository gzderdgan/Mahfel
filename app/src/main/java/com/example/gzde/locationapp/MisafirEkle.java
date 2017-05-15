package com.example.gzde.locationapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MisafirEkle extends AppCompatActivity{


    private DBManager dbManager;
    Button add;
    EditText isim;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_misafir_ekle);

        isim=(EditText) findViewById(R.id.nameEditText);
        add=(Button)findViewById(R.id.addBtn);
        dbManager = new DBManager(this);
        dbManager.open();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = isim.getText().toString();

                dbManager.insert(name);

                Intent main = new Intent(getApplication(), DavetliListem.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(main);


            }
        });




    }
}