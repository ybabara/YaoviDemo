package com.example.yaovi.yaovidemo;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yaovi.yaovidemo.util.UtilDensity;

/**
 * Created by Yaovi on 2/22/17.
 */

public class Alphabet extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activities);
    }

    @Override
    public void toActivity(Class name) {
        super.toActivity(name);
    }

    @Override
    public void toastLong(String content) {
        super.toastLong(content);
    }

    @Override
    public void toastShort(String content) {
        super.toastShort(content);
    }
}