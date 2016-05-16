package com.axalta.mcc.Application;

import android.app.Application;

/**
 * Created by danqi on 2016/5/6.
 */
public class MyApplication extends Application {

    private static MyApplication mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        if(mContext==null) {
            mContext = this;
        }

    }
    public static MyApplication getMyApplication(){
        return mContext;
    }

}
