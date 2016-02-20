package com.bridgelabz.com.appscreen.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.AvoidXfermode;

/**
 * Created by bridgelabz3 on 16/2/16.
 */
public class Model extends SQLiteOpenHelper
{
    private static Model model;
    public static final String DATABASE_NAME="open_data";
    public static final int DATABASE_VERSION=3;

    public Model(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }

    public static synchronized Model getInstance (Context context)
    {
        if (model == null)
        {
            model = new Model(context.getApplicationContext());
        }
        return model;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
