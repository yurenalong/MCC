package com.axalta.mcc.Activity;

import android.os.Bundle;
import android.view.View;

import com.axalta.mcc.R;
import com.axalta.mcc.Utils.CheckNetUtils;

/**
 * 闪屏进入页面
 */
public class HelloActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        if (CheckNetUtils.checkNet()) {
            updateVersion();//
        } else {
            go(LoginActivity.class);
            finish();
        }

    }

    private void updateVersion() {
        go(LoginActivity.class);
        finish();

    }


    @Override
    public void onClick(View v) {

    }
}
