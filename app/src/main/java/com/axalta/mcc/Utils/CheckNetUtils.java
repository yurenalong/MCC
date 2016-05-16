package com.axalta.mcc.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.axalta.mcc.Application.MyApplication;

/**
 * Created by danqi on 2016/5/6.
 */
public class CheckNetUtils {

    public static boolean checkNet(){
        ConnectivityManager manager = (ConnectivityManager) MyApplication
                .getMyApplication().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mobile = manager
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        NetworkInfo wifi = manager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (mobile.isConnected() || wifi.isConnected()) {
            return true;
        } else {
            return false;
        }

    }
}
