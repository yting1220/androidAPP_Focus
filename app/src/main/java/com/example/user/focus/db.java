package com.example.user.focus;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class db extends Activity {

    public SQLiteDatabase db = null;
    private final static String DATABASE_NAME = "record";
    private final static String TABLE_NAME = "table01";
    private final static String _ID = "_id";
    private final static String all = "DateTimeStar";

    private final static String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME
            + " (" + _ID + " INTEGER PRIMARY KEY," + all + " TEXT)";

    private Context mCtx = null;

    public db(Context ctx) {
        this.mCtx = ctx;
    }

    public void open() throws SQLException {
        //打開並執行db
        db = mCtx.openOrCreateDatabase(DATABASE_NAME, 0, null);
        try {
            db.execSQL(CREATE_TABLE);
        } catch (Exception e) {
        }
    }

    public void close() throws SQLException {
        db.close();
    }

    public Cursor getAll_data() {
        //查詢db裡面的all的data 放進cursor
        Cursor mCursor = db.query(TABLE_NAME, new String[] { _ID, all}, null,
                        null, null, null, null);
        return mCursor;
    }

    public long append(String a) {
        //p4將欲增加至db中all的值傳進此method  並執行insert
        ContentValues args = new ContentValues();
        args.put(all, a);
        return db.insert(TABLE_NAME, null, args);
    }
}


