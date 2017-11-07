package com.example.android.demofancymonk;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button signInButton,signUpButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signInButton=(Button)findViewById(R.id.sign_in);
        signUpButton=(Button)findViewById(R.id.sign_up);

    signInButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent1=new Intent(MainActivity.this,SigninActivity.class);

            startActivity(intent1);
        }
    });
    signUpButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(MainActivity.this,SignUpActivity.class);
            startActivity(intent);
        }
    });
    }
}
