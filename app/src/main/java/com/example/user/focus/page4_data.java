package com.example.user.focus;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class page4_data extends AppCompatActivity {

    private ListView listview;
    private db db = null;
    private Cursor cursor;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data);

        //bundle有取到值才執行
        bundle = this.getIntent().getExtras();
        if (bundle != null) {
            Button button2 = (Button) findViewById(R.id.button2);
            button2.setOnClickListener(listener);

            listview = (ListView) findViewById(R.id.listview);

            //呼叫dbd class 並開啟db
            db = new db(this);
            db.open();
            //取得db內all欄位的data存進cursor，並傳進UpdateAdapter method
            cursor = db.getAll_data();
            UpdateAdapter(cursor);
        }

        Button toPageHome = (Button) findViewById(R.id.home);
        toPageHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(page4_data.this, page1_home.class);
                startActivity(intent);
            }
        });
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //將取得的日期時間跟碎片數量存進字串
            Calendar mCalendar = new GregorianCalendar();
            String x = String.valueOf(mCalendar.get(Calendar.MONTH) + 1) + "/" + String.valueOf(mCalendar.get(Calendar.DAY_OF_MONTH))
                    + "                 "
                    + String.valueOf(bundle.getInt("time_sec")/60)
                    + "m                "
                    + String.valueOf(bundle.getInt("star_number_data"));
            //呼叫append method並新增字串進db，在取得db內的data並呼叫UpdateAdapter method
            if (db.append(x) > 0) {
                cursor = db.getAll_data();
                UpdateAdapter(cursor);
            }
        }
    };

    private void UpdateAdapter(Cursor cursor) {
        //判斷cursor有值
        if (cursor != null && cursor.getCount() > 0) {
            //使用內建simple_list_item_1的layout  將從DateTimeStar(名稱為all)欄位查詢出的cursor值放在layout中的text1
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_1, cursor, new String[]{
                    "DateTimeStar"}, new int[]{android.R.id.text1});
            //將adapter加進listView
            listview.setAdapter(adapter);
        }
    }

    //程式進到onDestroy時關閉db
    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
}