package com.example.dongyu.myapplicationtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dongyu.myapplicationtest.entity.QXuser;

import cn.bmob.v3.listener.SaveListener;


/**
 * Created by dongyu on 2/29/16.
 */



public class RegActivity extends Activity{

    private AutoCompleteTextView mEmailView;
    private AutoCompleteTextView mUserName;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        mUserName = (AutoCompleteTextView) findViewById(R.id.username);
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        // populateAutoComplete();

        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptReg();
                    return true;
                }
                return false;
            }
        });


        Button mEmailSignupButton = (Button) findViewById(R.id.email_sign_up_button);
        mEmailSignupButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptReg();
            }
        });
        mLoginFormView = findViewById(R.id.reg_form);
        mProgressView = findViewById(R.id.reg_progress);
    }




    private void attemptReg(){
        QXuser user = new QXuser();

        String userName = mUserName.getText().toString();
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();
        // Store values at the time of the login attempt.

        user.setUsername(userName);
        user.setEmail(email);
        user.setPassword(password);

        user.signUp(this, new SaveListener() {
            @Override
            public void onSuccess() {
                Toast.makeText(RegActivity.this, "注册成功", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(int i, String s) {
                Toast.makeText(RegActivity.this, "注册失败" + s, Toast.LENGTH_LONG).show();

            }
        });
    }



}
