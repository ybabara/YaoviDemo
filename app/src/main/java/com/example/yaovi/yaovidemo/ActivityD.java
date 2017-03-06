package com.example.yaovi.yaovidemo;

/**
 * Created by Yaovi on 3/1/17.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityD extends AppCompatActivity {
    private Button btda;
    private Button btdb;
    private Button btdc;
    private Button btdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);
        initialView();
        initialListener();

    }

    private void initialView(){
        btda = (Button) findViewById(R.id.act1);
        btdb = (Button) findViewById(R.id.act2);
        btdc = (Button) findViewById(R.id.act3);
        btdd = (Button) findViewById(R.id.act4);
    }

    private void initialListener(){
        btda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ActivityA.class);
                startActivity(intent);
            }
        });
        btdb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ActivityB.class);
                startActivity(intent);
            }
        });
        btdc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ActivityC.class);
                startActivity(intent);
            }
        });
        btdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ActivityD.class);
                startActivity(intent);
            }
        });

    }

}