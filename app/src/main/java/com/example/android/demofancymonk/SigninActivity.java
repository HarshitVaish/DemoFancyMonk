package com.example.android.demofancymonk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.button;

public class SigninActivity extends AppCompatActivity {
    EditText editTextUserName, edittTextPassword, editTextEmail;
    Button buttonSignin, buttonSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        TextInputLayout textLayoutUsername = (TextInputLayout) findViewById(R.id.til_user_name1);
        TextInputLayout textLayoutPassword = (TextInputLayout) findViewById(R.id.til_password1);

        editTextUserName = (EditText) findViewById(R.id.edit_text_user_name);
        edittTextPassword = (EditText) findViewById(R.id.edit_text_password);
        buttonSignin = (Button) findViewById(R.id.sign_in_button);
        buttonSignup = (Button) findViewById(R.id.sign_up_button);
        textLayoutUsername.setError("Username  must be greater an 5 characters");

// If no error
        textLayoutUsername.setErrorEnabled(false);

        textLayoutPassword.setError("Password must be greater than 8 characters");

        textLayoutPassword.setErrorEnabled(false);

        buttonSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=editTextUserName.getText().toString();
                String password=edittTextPassword.getText().toString();
                if(user.equalsIgnoreCase("")||password.equalsIgnoreCase("")){
                    Toast.makeText(SigninActivity.this, "Either of the fields are empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    SharedPreferences sp1=getSharedPreferences("userinfo", Context.MODE_PRIVATE);
                   String savedemail=sp1.getString("email","");
                   String savedpass=sp1.getString("password","");
                   String savedphone=sp1.getString("phone","");
                    if(user.equals("abc")||user.equals(savedphone)){
                        if(password.equals("123")||password.equals(savedpass)){
                            Intent intent=new Intent(SigninActivity.this,MenuActivity.class);
                            startActivity(intent);
                        }
                    }
                    }

            }

        });
        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SigninActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
