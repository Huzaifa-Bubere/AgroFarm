package com.example.agrofarms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class signup_form extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_form);
        DatabaseHelper databaseHelper=new DatabaseHelper(this);
        Button signup_button=(Button) findViewById(R.id.signup_button);

        TextView already_account= (TextView) findViewById(R.id.already_account);
        already_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent12=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent12);
            }
        });

        EditText email1=(EditText)findViewById(R.id.email_editext);
        EditText username1=(EditText)findViewById(R.id.username_editext);
        EditText contact1=(EditText)findViewById(R.id.contact_editext);
        EditText password1=(EditText)findViewById(R.id.password_editext);


//        int contact =Integer.parseInt(contact12);

        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=email1.getText().toString();
                String username=username1.getText().toString();
                String password=password1.getText().toString();
                String contact12=contact1.getText().toString();
                if(email.isEmpty() || username.isEmpty() || password.isEmpty() || contact12.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Fill All The Fields",Toast.LENGTH_LONG).show();
                }
//                else{
//                    Boolean checkemail=databaseHelper.checkemail(email);
//                    if (checkemail == false){
//                        Toast.makeText(getApplicationContext(),"User Already Exists.",Toast.LENGTH_LONG).show();
//                    }
//                }
                else{
                    Boolean checkemail = databaseHelper.checkemail(email);
                    if (!checkemail) {
                        Boolean insert = databaseHelper.insertdata(email, username, password, contact12);
                        if (insert) {
                            Toast.makeText(getApplicationContext(), "Sign up Successful.", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(signup_form.this, homepage.class);
                            intent.putExtra("mobile",contact12);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "Sign Up Failed.", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "User Already Exists.", Toast.LENGTH_LONG).show();
                    }
                }


            }
        });
    }
}