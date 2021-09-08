package com.example.user.focus;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class page1_home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Button toPage2 = (Button)findViewById(R.id.start);
        toPage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(page1_home.this , page2_settime.class);
                startActivity(intent);
            }
        });

        Button toPage4 = (Button)findViewById(R.id.history);
        toPage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(page1_home.this , page4_data.class);
                startActivity(intent);
            }
        });

        Button toPage5 = (Button)findViewById(R.id.universe);
        toPage5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(page1_home.this , page5_universe.class);
                startActivity(intent);
            }
        });
    }
}
