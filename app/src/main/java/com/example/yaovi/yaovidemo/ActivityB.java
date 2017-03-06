package com.example.yaovi.yaovidemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.yaovi.yaovidemo.ActivityA;
import com.example.yaovi.yaovidemo.R;

public class ActivityB extends AppCompatActivity {
    private Button btba;
    private Button btbb;
    private Button btbc;
    private Button btbd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        initialView();
        initialListener();

    }

    private void initialView(){
        btba = (Button) findViewById(R.id.act1);
        btbb = (Button) findViewById(R.id.act2);
        btbc = (Button) findViewById(R.id.act3);
        btbd = (Button) findViewById(R.id.act4);
    }

    private void initialListener(){
        btba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ActivityA.class);
                startActivity(intent);
            }
        });
        btbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ActivityB.class);
                startActivity(intent);
            }
        });
        btbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ActivityC.class);
                startActivity(intent);
            }
        });
        btbd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ActivityD.class);
                startActivity(intent);
            }
        });

    }

}