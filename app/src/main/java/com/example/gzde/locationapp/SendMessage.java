package com.example.gzde.locationapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendMessage extends AppCompatActivity {


    Button smsSend;
    EditText mssage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        smsSend = (Button) findViewById(R.id.gonder);
        mssage =(EditText)findViewById(R.id.txtMessage) ;


        smsSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage("+905355858662".toString(), null, mssage.getText().toString().trim(), null, null);

            }
        });
    }
}
