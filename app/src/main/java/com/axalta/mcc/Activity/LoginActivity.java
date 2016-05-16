package com.axalta.mcc.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.axalta.mcc.R;

/**
 * 注册页面
 */
public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        EditText mLogin = (EditText) findViewById(R.id.editText);
        EditText mPassword = (EditText) findViewById(R.id.editText2);
//        findViewById(R.id.button).setOnClickListener(this);
//        findViewById(R.id.textview1).setOnClickListener(this);
//        findViewById(R.id.textview2).setOnClickListener(this);
        Button button = (Button) findViewById(R.id.button);
        TextView textview1 = (TextView) findViewById(R.id.textview1);
        TextView textview2 = (TextView) findViewById(R.id.textview2);
        button.setOnClickListener(this);
        textview1.setOnClickListener(this);
        textview2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                login();
                break;


            case R.id.textview1:
                go(RegisterAct.class);
                break;

            case R.id.textview2:
                go(ForgetPswAct.class);
                break;

        }

    }

    private void login() {
    }
}
