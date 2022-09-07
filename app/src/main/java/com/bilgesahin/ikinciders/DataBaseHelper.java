package com.bilgesahin.ikinciders;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper  extends SQLiteOpenHelper {
    private static final String DB_PATH="data/data/com.bilgesahin.ikinciders/databases/";
    private static final String DB_NAME =" Trafik.db";
    SQLiteDatabase sqLiteDatabase;
    private static final int VERSION=1;
    Context context;

    public DataBaseHelper(Context mContext) {

        super(mContext, DB_NAME , null, VERSION);
        mContext = context ;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void createDataBase() throws IOException {
        boolean dbExist=checkDataBase();
        if(dbExist){

        }
        else{
            getReadableDatabase();
            copyDataBase();
        }
    }
    public boolean checkDataBase(){
        SQLiteDatabase checkDataBase= null;
        try {
            String myPath =DB_PATH+DB_NAME;
            checkDataBase= SQLiteDatabase.openDatabase(myPath,null,SQLiteDatabase.OPEN_READONLY);
        }
        catch (SQLiteException e){

        }
        if(checkDataBase != null){
            checkDataBase.close();
        }
        return checkDataBase != null ? true: false;

    }
    public void copyDataBase() throws IOException {
        try{
            InputStream myInput = context.getAssets().open(DB_NAME);
            String outFileName =DB_PATH + DB_NAME;
            OutputStream myOutput = new FileOutputStream(outFileName);
            byte[] buffer = new byte [1024];
            int length;
            while ((length = myInput.read(buffer)) > 0){
                myOutput.write(buffer,0,length);
            }
            myOutput.flush();
            myOutput.close();
            myInput.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void openDatabase() throws IOException{
        String myPath = DB_PATH + DB_NAME;
        sqLiteDatabase = SQLiteDatabase.openDatabase(myPath,null,SQLiteDatabase.OPEN_READONLY);
    }

    @Override
    public synchronized void close() {
        if(sqLiteDatabase != null)
            sqLiteDatabase.close();
        super.close();
    }
    public SQLiteDatabase getDatabase(){
        return sqLiteDatabase;
    }
}






