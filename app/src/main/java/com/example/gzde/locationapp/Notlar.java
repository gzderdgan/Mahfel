package com.example.gzde.locationapp;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Notlar extends ListActivity {


    EditText txt;
    Button btn,btnDel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_notlar);

        txt=(EditText)findViewById(R.id.txtItem);
        btn = (Button) findViewById(R.id.btnAdd);
        btnDel = (Button) findViewById(R.id.btnDel);


    }
}
