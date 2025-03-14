package com.example.agrofarms;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        TextView t1=(TextView) findViewById(R.id.t1);

        EditText ed1=(EditText)findViewById(R.id.ed1);
        EditText ed2=(EditText)findViewById(R.id.ed2);
        EditText ed3=(EditText)findViewById(R.id.ed3);
        EditText ed4=(EditText)findViewById(R.id.ed4);
        EditText ed5=(EditText)findViewById(R.id.ed5);
        EditText ed6=(EditText)findViewById(R.id.ed6);

        Intent otp=getIntent();
        String co= otp.getStringExtra("mobile");
        String mess1= "";
        String mess2= "";
        String mess3= "";
        for (int i = 0; i < co.length(); i++) {
            if(i==0||i==1) {
                mess1 += co.charAt(i);
            }
            if(i==8||i==9) {
                mess2 += co.charAt(i);
            }
            }
        mess3=mess1+"********"+mess2;
        t1.setText(mess3);

        ed1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().isEmpty()){
                    ed2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        ed2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().isEmpty()){
                    ed3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        ed3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().isEmpty()){
                    ed4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        ed4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().isEmpty()){
                    ed5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        ed5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().isEmpty()){
                    ed6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

//        Random random=new Random();
//        int otp_number = random.nextInt(99999);
//        SmsManager mgr=SmsManager.getDefault();
//        mgr.sendTextMessage(co,null, String.valueOf(otp_number),null,null);

    }
    public <co> void sendotp(String co){


    }
}