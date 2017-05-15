package com.example.gzde.locationapp;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Ceyiz extends ListActivity {

    private DBManager dbManager;
    private ListView lw;
    String namee;
    ArrayList listem = new ArrayList();
    private ArrayAdapter adapter;
    EditText txt;
    Button btn,btnDel;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ceyiz);

        txt=(EditText)findViewById(R.id.txtItem);
        btn = (Button) findViewById(R.id.btnAdd);
        btnDel = (Button) findViewById(R.id.btnDel);
        lw = (ListView) findViewById(R.id.listim);

        dbManager = new DBManager(this);
        dbManager.open();

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, listem);
      //  adapter.notifyDataSetChanged();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                namee = txt.getText().toString();

                listem.add(namee);
                txt.setText("");
                adapter.notifyDataSetChanged();
           //     dbManager.insert(DatabaseHelper.TABLE_NAME, null, );
           //     lw.setAdapter(adapter);

            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SparseBooleanArray checkedItemPositions = getListView().getCheckedItemPositions();
                int itemCount = getListView().getCount();

                for(int i=itemCount-1; i >= 0; i--){
                    if(checkedItemPositions.get(i)){
                        adapter.remove(listem.get(i));

                    }
                }
                checkedItemPositions.clear();
                adapter.notifyDataSetChanged();

            }
        });


setListAdapter(adapter);

    }
}
