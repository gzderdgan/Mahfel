package com.example.gzde.locationapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Notlar extends AppCompatActivity {

    private DBManagerNotlar dbManager;
    Button add;
    EditText isim;
    String name;
    private ListView listView;
    private SimpleCursorAdapter adapter;

    final String[] from = new String[] { DatabaseHelperNotlar._ID,
            DatabaseHelperNotlar.NAME };
    final int[] to = new int[] { R.id.id, R.id.nametxt};

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notlar);

        isim = (EditText) findViewById(R.id.txtItem);
        add = (Button) findViewById(R.id.btnAdd);

        dbManager = new DBManagerNotlar(this);
        dbManager.open();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = isim.getText().toString();

                dbManager.insert(name);

                Intent main = new Intent(getApplication(), Notlar.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(main);


            }
        });
        dbManager = new DBManagerNotlar(this);
        dbManager.open();
        Cursor cursor = dbManager.fetch();


        listView = (ListView) findViewById(R.id.listt);

        adapter = new SimpleCursorAdapter(this, R.layout.view_record, cursor, from, to, 0);
        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);


        //adapter.notifyDataSetChanged();

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, final View view, int position, final long id) {
                AlertDialog.Builder alert = new AlertDialog.Builder(Notlar.this);
                alert.setMessage("Are you sure to delete");
                alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dbManager.delete(id);
                        returnHomee();

                    }
                });
                alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                });

                alert.show();
                return  true;
            }
        });

    }
    public void returnHomee() {
        Intent home = new Intent(getApplicationContext(), Notlar.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home);


    }
}