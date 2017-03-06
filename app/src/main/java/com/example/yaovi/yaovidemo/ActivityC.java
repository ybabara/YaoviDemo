package com.example.yaovi.yaovidemo;

/**
 * Created by Yaovi on 3/1/17.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityC extends AppCompatActivity {
    private Button btca;
    private Button btcb;
    private Button btcc;
    private Button btcd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        initialView();
        initialListener();

    }

    private void initialView(){
        btca = (Button) findViewById(R.id.act1);
        btcb = (Button) findViewById(R.id.act2);
        btcc = (Button) findViewById(R.id.act3);
        btcd = (Button) findViewById(R.id.act4);
    }

    private void initialListener(){
        btca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ActivityA.class);
                startActivity(intent);
            }
        });
        btcb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ActivityB.class);
                startActivity(intent);
            }
        });
        btcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ActivityC.class);
                startActivity(intent);
            }
        });
        btcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ActivityD.class);
                startActivity(intent);
            }
        });

    }

}