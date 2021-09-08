package com.example.user.focus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class page2_settime extends AppCompatActivity {

    private TimePicker timePicker;
    String hour,min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_time);

        timePicker = (TimePicker)findViewById(R.id.time_picker);
        //在timePicker時間改變時 取得數值存進變數中
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener(){
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                hour = String.valueOf(hourOfDay);
                min = String.valueOf(minute);
            }
        });

        Button toPage3 = (Button)findViewById(R.id.ok);
        toPage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("Hour",Integer.valueOf(hour));
                intent.putExtra("Minute",Integer.valueOf(min));
                intent.setClass(page2_settime.this , page3_count.class);
                startActivity(intent);
            }
        });

        Button toPageHome = (Button)findViewById(R.id.home);
        toPageHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(page2_settime.this , page1_home.class);
                startActivity(intent);
            }
        });
    }

    private static String TimeFix(int c){
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }
}