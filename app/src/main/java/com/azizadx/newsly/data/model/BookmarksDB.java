package com.azizadx.newsly.data.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BookmarksDB extends SQLiteOpenHelper {

    private Context context;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "SavedArticles";
    private static final String TABLE_NAME = "artcles";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_IMAGE = "img";
    private static final String KEY_URL = "url";
    private static final String KEY_CAT = "cat";



    public BookmarksDB(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context=context;
    }

    public void onCreate(SQLiteDatabase db){
        String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+KEY_ID+
                " INTEGER PRIMARY KEY AUTOINCREMENT, "+KEY_NAME+" VARCHAR(500), "+KEY_IMAGE+" VARCHAR(500), "+KEY_URL+" VARCHAR(500), "+KEY_CAT+" VARCHAR(500))";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }


    public void insertToDb(String title, String img, String url, String cat){
        SQLiteDatabase db = this.getWritableDatabase();

        //handle duplicates
        Cursor c=db.rawQuery("SELECT * FROM artcles WHERE name = ?", new String[] {title});
        if(c.moveToFirst())
        {
            Toast.makeText(context.getApplicationContext(), "Already Bookmarked!", Toast.LENGTH_LONG).show();
        }
        else
        {
            // Inserting record
            ContentValues values = new ContentValues();
            values.put(KEY_NAME,title);
            values.put(KEY_IMAGE,img);
            values.put(KEY_URL,url);
            values.put(KEY_CAT,cat);
            db.insert(TABLE_NAME,KEY_ID,values);
            db.close();
        }
        c.close();

    }


    public Cursor getAll()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns={KEY_NAME,KEY_IMAGE,KEY_URL,KEY_CAT};
        return db.query(TABLE_NAME,columns,null,null,null,null,null);
    }


    public long Delete(String nm)
    {SQLiteDatabase db = this.getWritableDatabase();
        try
        {

            return db.delete(TABLE_NAME,KEY_NAME+" =?",new String[]{String.valueOf(nm)});

        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        return 0;
    }



}
