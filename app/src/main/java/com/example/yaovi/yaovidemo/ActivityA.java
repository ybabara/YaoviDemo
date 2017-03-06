package com.example.yaovi.yaovidemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Yaovi on 3/1/17.
 */

public class ActivityA extends BaseActivity {
    private Button btaa;
    private Button btab;
    private Button btac;
    private Button btad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        initialView();
        initialListener();
    }

    private void initialView(){
        btaa = (Button) findViewById(R.id.act1);
        btab = (Button) findViewById(R.id.act2);
        btac = (Button) findViewById(R.id.act3);
        btad = (Button) findViewById(R.id.act4);
    }

    private void initialListener(){
        btaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ActivityA.class);
                startActivity(intent);
            }
        });
        btab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ActivityB.class);
                startActivity(intent);
            }
        });
        btac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ActivityC.class);
                startActivity(intent);
            }
        });
        btad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ActivityD.class);
                startActivity(intent);
            }
        });

    }


}
