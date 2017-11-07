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

public class SignUpActivity extends AppCompatActivity {
    EditText editTextUserName, edittTextPassword, editTextEmail,editTextPhoneNo;
    Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        TextInputLayout textLayoutUsername = (TextInputLayout) findViewById(R.id.til_user_name);
        TextInputLayout textLayoutPassword = (TextInputLayout) findViewById(R.id.til_password);
        TextInputLayout textLayoutemail = (TextInputLayout) findViewById(R.id.til_email);
        TextInputLayout textLayoutphone = (TextInputLayout) findViewById(R.id.til_phone_no);
        editTextUserName=(EditText)findViewById(R.id.edit_text_user_name);
        edittTextPassword=(EditText)findViewById(R.id.edit_text_password);
        editTextEmail=(EditText)findViewById(R.id.edit_text_email);
        editTextPhoneNo=(EditText)findViewById(R.id.edit_text_phone_no);
        buttonSubmit=(Button)findViewById(R.id.submit_button);
// If error
        textLayoutUsername.setError("Username  must be greater an 5 characters");

// If no error
        textLayoutUsername.setErrorEnabled(false);
        textLayoutPassword.setError("Phone number is too small");

        textLayoutPassword.setErrorEnabled(false);

        textLayoutPassword.setError("Password must be greater than 8 characters");

        textLayoutPassword.setErrorEnabled(false);

        textLayoutemail.setError("Email should be in correct format");

        textLayoutemail.setErrorEnabled(false);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName=editTextUserName.getText().toString();
                String password=edittTextPassword.getText().toString();
                String email=editTextEmail.getText().toString();
                String phone=editTextPhoneNo.getText().toString();
                if(userName.equalsIgnoreCase("")||password.equalsIgnoreCase("")||email.equalsIgnoreCase("")||phone.equalsIgnoreCase("")){
                    Toast.makeText(SignUpActivity.this,"Any one of the credientials is left Empty",Toast.LENGTH_SHORT).show();
                }
                    else {
                    SharedPreferences sp1=getSharedPreferences("userinfo", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit=sp1.edit();
                    edit.putString("username",userName);
                    edit.putString("phoneno",phone);
                    edit.putString("password",password);
                    edit.putString("email",email);
                    edit.apply();
                    Toast.makeText(SignUpActivity.this,"Saved Successfully",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(SignUpActivity.this,SigninActivity.class);
                    startActivity(intent);

                }
            }
        });
    }
}
