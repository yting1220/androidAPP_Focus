package com.example.user.focus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.animation.Animation;
import android.view.animation.AlphaAnimation;

import java.util.Random;

public class page5_universe extends AppCompatActivity implements BottomSheetDialog.BottomSheetListener {

    private TextView number;
    private ImageView p1, p2, p3, p4, p5, p6;
    static int starNumber = 100;
    static int choose[] = {0, 0, 0, 0, 0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universe);

        //顯示目前碎片數
        number = (TextView) findViewById(R.id.number);
        number.setText("" + starNumber);
        BottomSheetDialog.getStarCount(starNumber);

        p1 = (ImageView) findViewById(R.id.p1);
        p2 = (ImageView) findViewById(R.id.p2);
        p3 = (ImageView) findViewById(R.id.p3);
        p4 = (ImageView) findViewById(R.id.p4);
        p5 = (ImageView) findViewById(R.id.p5);
        p6 = (ImageView) findViewById(R.id.p6);

        //從儲存button編號的陣列判斷需顯示的星球
        if(choose[0] != 0){
            p1.setImageResource(R.drawable.p1);
            flicker(p1,2000);
        }if(choose[1] != 0){
            p2.setImageResource(R.drawable.p2);
            flicker(p2,1500);
        }if(choose[2] != 0){
            p3.setImageResource(R.drawable.p3);
            flicker(p3,500);
        }if(choose[3] != 0){
            p4.setImageResource(R.drawable.p4);
            flicker(p4,700);
        }if(choose[4] != 0){
            p5.setImageResource(R.drawable.p5);
            flicker(p5,1000);
        }if(choose[5] != 0){
            p6.setImageResource(R.drawable.p6);
            flicker(p6,1200);
        }

        Button toPageHome = (Button) findViewById(R.id.home);
        toPageHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(page5_universe.this, page1_home.class);
                startActivity(intent);
            }
        });

        Button buttonOpenBottomSheet = findViewById(R.id.button);
        buttonOpenBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheet = new BottomSheetDialog();
                bottomSheet.show(getSupportFragmentManager(), "exampleBottomSheet");
            }
        });

    }

    public void onButtonClicked(String text) {

    }

    //設定閃爍動畫
    private void flicker(ImageView p, int speedTime){
        Animation am = new AlphaAnimation(5.0f, 0.0f);
        //設定動畫開始到結束的執行時間
        am.setDuration(speedTime);
        //設定重複次數為無限次
        am.setRepeatCount(-1);
        //將動畫參數設定到圖片並開始執行
        p.startAnimation(am);
    }

    //累加完成時間後獲得的碎片數量-從p3_count取值
    public static void starCount(int star_p3) {
        starNumber = star_p3 + starNumber;
    }

    //取回購買星球後的剩餘碎片數量-從bottomSheetDialog取值
    public static void starSub(int star_e) {
        starNumber = star_e;
    }

    //從BottomSheetDialog取得點選的button編號存入陣列
    public static void getChoose(int buttonNumber) {
            choose[buttonNumber-1] = buttonNumber;
    }
}
