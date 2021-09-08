package com.example.user.focus;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Calendar;
import java.util.List;

public class page3_count extends AppCompatActivity {
    private Calendar calendar;
    private TextView currentTime, userSetTime, mTextView;
    private MediaPlayer mp;
    String a, b;
    int time=0;
    int star=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.count);

        //取得當前時間
        calendar = Calendar.getInstance();
        currentTime = (TextView) findViewById(R.id.currentTime);
        if (calendar.get(Calendar.MINUTE) < 10) {
            a = "0" + calendar.get(Calendar.MINUTE);
        } else
            a = String.valueOf(calendar.get(Calendar.MINUTE));
        currentTime.setText(calendar.get(Calendar.HOUR_OF_DAY) + " : " + a);

        //取得p3設定的時間
        Bundle bundle = this.getIntent().getExtras();
        userSetTime = (TextView) findViewById(R.id.userSetTime);
        if (bundle.getInt("Minute") < 10) {
            b = "0" + bundle.getInt("Minute");
        } else
            b = String.valueOf(bundle.getInt("Minute"));
        userSetTime.setText(bundle.getInt("Hour") + " : " + b);

        //計算出總時長秒數
        time = (bundle.getInt("Hour")*60+bundle.getInt("Minute")*60)-(calendar.get(Calendar.HOUR_OF_DAY)*60+calendar.get(Calendar.MINUTE)*60+calendar.get(Calendar.SECOND));

        mTextView = (TextView) findViewById(R.id.setTime);
        mp = MediaPlayer.create(this, R.raw.m);

        //倒數計時器 前面參數為總共豪秒數 後方為每1000毫秒執行一次
        new CountDownTimer(time*1000,1000){
            @Override
            //完成後進入此
            public void onFinish() {
                //播放提示音
                mp.start();
                //計算可獲得的碎片數量
                star = time/600;
                new AlertDialog.Builder(page3_count.this)
                        .setTitle("!!")
                        .setMessage("恭喜你獲得"+star+"個碎片!")
                        .setPositiveButton("確認", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                page5_universe.starCount(star);
                                Intent intent = new Intent();
                                intent.putExtra("star_number_data",star);
                                intent.putExtra("time_sec",time);
                                intent.setClass(page3_count.this, page4_data.class);
                                startActivity(intent);
                                mp.stop();
                            }
                        })
                        .show();
            }
            @Override
            public void onTick(long millisUntilFinished) {
                //將總時長分別計算成時分秒並顯示
                mTextView.setText(millisUntilFinished/1000/3600+":"+millisUntilFinished/1000%3600/60+":"+millisUntilFinished/1000%60);
            }
        }.start();

        //按放棄跳出提示框
        Button giveUp = (Button) findViewById(R.id.giveUp);
        giveUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(page3_count.this)
                        .setTitle("!!")
                        .setMessage("放棄就無法獲得碎片囉!")
                        .setPositiveButton("V", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                page5_universe.starCount(star);
                                Intent intent = new Intent();
                                intent.putExtra("star_number_data",star);
                                intent.putExtra("time_sec",time);
                                intent.setClass(page3_count.this, page4_data.class);
                                startActivity(intent);
                                mp.stop();
                            }
                        })
                        .setNegativeButton("X", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .show();
            }
        });
    }
}