package com.bilgesahin.ikinciders;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    DataBaseHelper dataBaseHelper;
    Context context = this;
    private Object v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataBaseHelper= new DataBaseHelper(context);
        try {
            dataBaseHelper.createDataBase();
            dataBaseHelper.openDatabase();

        }
        catch (IOException e){
            e.printStackTrace();
        }
        Button buton;
        buton = (Button) findViewById(R.id.GirisButonID);

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ListeSayfasi.class);
                startActivity(i);

            }


        });

    }

}