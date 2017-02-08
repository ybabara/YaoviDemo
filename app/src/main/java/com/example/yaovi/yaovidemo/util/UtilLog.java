package com.example.yaovi.yaovidemo.util;

import android.util.Log;

/**
 * Created by Yaovi on 2/6/17.
 */

public class UtilLog {
    private static boolean Debug = false;

        public static void setDebug(boolean b){
            Debug = b;
        }

    public static void logD(String key, String value){
        if(Debug){
            Log.d(key, value);
        }
    }

    public static void logE(String key, String value){
        if(Debug){
            Log.e(key, value);
        }
    }
    public static void logW(String key, String value){
        if(Debug){
            Log.w(key, value);
        }
    }
    public static void logI(String key, String value){
        if(Debug){
            Log.i(key, value);
        }
    }

}
