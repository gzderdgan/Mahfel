package com.example.gzde.locationapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class DansMuzik extends AppCompatActivity {


    Button shape,walk,efendi,game,vovin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dans_muzik);

        shape = (Button)findViewById(R.id.shapeOf);
        efendi = (Button) findViewById(R.id.deniz);
        walk = (Button) findViewById(R.id.walking);
        game = (Button) findViewById(R.id.thrones);
        vovin = (Button) findViewById(R.id.therion);


        vovin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=PujzH9Cevpw&feature=youtu.be"));
                startActivity(browserIntent);
            }
        });

        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=u1B3FOBdgQY&feature=youtu.be"));
                startActivity(browserIntent);
            }
        });


        efendi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=2jkkOP01LYA&feature=youtu.be"));
                startActivity(browserIntent);
            }
        });

        walk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=esqLK4BKlHo&feature=youtu.be"));
                startActivity(browserIntent);
            }
        });


        shape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=ZuI61cTNbAk&feature=youtu.be"));
                startActivity(browserIntent);
            }
        });

    }
}
