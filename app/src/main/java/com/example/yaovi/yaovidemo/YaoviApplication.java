package com.example.yaovi.yaovidemo;

import android.app.Application;

import com.example.yaovi.yaovidemo.util.UtilLog;

/**
 * Created by Yaovi on 2/6/17.
 */

public class YaoviApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        UtilLog.setDebug(true);
    }
}
