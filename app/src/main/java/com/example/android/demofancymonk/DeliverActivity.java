package com.example.android.demofancymonk;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.demofancymonk.ui.CanvasClass;

public class DeliverActivity extends AppCompatActivity {

    private CanvasClass canvasClass;
    Button submitButton, clearCanvas;
    EditText commentText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliver);
        canvasClass = (CanvasClass) findViewById(R.id.canvas_view);
        submitButton = (Button) findViewById(R.id.comment_submit);
        clearCanvas = (Button) findViewById(R.id.clear_canvas);
        commentText = (EditText) findViewById(R.id.comment_box);
        clearCanvas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canvasClass.clearCanvas();
                commentText.setText("");
                commentText.setHint("Comment your Experience Here");
            }
        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DeliverActivity.this,"Comment Submitted successfully",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(DeliverActivity.this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(DeliverActivity.this,"Thankyou for using our service",Toast.LENGTH_SHORT).show();

            }
        });
    }


}
