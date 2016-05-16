package com.axalta.mcc.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by danqi on 2016/5/9.
 */
public class SharedUtils {

    private static final String TAG = "ShareUtils";

    /**
     * 保存密码
     *
     * @param context
     * @param str
     */
    public static void savePassword(Context context, String str) {
        saveString(context, "password", str);
    }

    /**
     * 保存字符String
     * @param context
     * @param key
     * @param str
     */
    private static void saveString(Context context, String key, String str) {
        SharedPreferences.Editor editor = context.getSharedPreferences(TAG,
                Context.MODE_PRIVATE).edit();

        if (EmptyUtils.isEmpty(str)) {
            editor.putString(key, "");
        } else {
            editor.putString(key, str);
        }
        editor.commit();
    }

    /**
     * 获取密码
     *
     * @param context
     * @return
     */
    public static String getPassword(Context context) {
        return getString(context, "password");
    }

    public static String getString(Context context, String key) {
        SharedPreferences share = context.getSharedPreferences(TAG,
                Context.MODE_PRIVATE);
        return share.getString(key, "");
    }
}
