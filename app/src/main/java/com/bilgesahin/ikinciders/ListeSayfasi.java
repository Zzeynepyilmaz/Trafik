package com.bilgesahin.ikinciders;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListeSayfasi extends AppCompatActivity {
    ListView listemiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DataBaseHelper db = new DataBaseHelper(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_sayfasi);
        listemiz= (ListView) findViewById(R.id.listemiz);


    }


}