package com.example.android.demofancymonk;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmActivity extends AppCompatActivity {
ProgressBar progessBar;
TextView progressText;
    int progressStatus=0;
    Handler handler=new Handler();
    String progress="Dispatched";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        Toast.makeText(ConfirmActivity.this,"Food will Be Delivered in 40 minutes",Toast.LENGTH_SHORT).show();
        progessBar=(ProgressBar)findViewById(R.id.progressbar);
        progressText=(TextView)findViewById(R.id.progress_textview);
        progressText.setText(progress);

      new Thread(new Runnable() {
          @Override
          public void run() {
              while(progressStatus<=100){
                 progressStatus+=1;
                  handler.post(new Runnable() {
                      @Override
                      public void run() {
                          progessBar.setProgress(progressStatus);
                          if(progressStatus==50)
                              progressText.setText("Confirmed");

                          if(progressStatus==100)
                              progressText.setText("Delivered");


                      }
                  });
                try{
                    Thread.sleep(100);
                }
                catch ( InterruptedException e) {
                    e.printStackTrace();
                }
              }
          }
      }).start();

    progressText.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(progressText.getText().toString().equals("Dispatched")||progressText.getText().toString().equals("Confirmed")){
               Toast.makeText(ConfirmActivity.this,"Cant Move further untill order is delivered",Toast.LENGTH_SHORT).show();
            }
            else{
                Intent intent=new Intent(ConfirmActivity.this,DeliverActivity.class);
                startActivity(intent);
            }
        }
    });

    }}





