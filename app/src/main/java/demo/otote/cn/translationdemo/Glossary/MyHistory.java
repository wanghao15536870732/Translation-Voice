package demo.otote.cn.translationdemo.Glossary;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MyHistory extends SQLiteOpenHelper {


    public MyHistory(Context context) {
        super(context, "history.db", null,4);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table info(_id integer primary key autoincrement,word varchar(200),result varchar(200))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("alter table info add result varchar(200)");
    }
}
