package com.example.android.demofancymonk;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.android.demofancymonk.adapter.MenuAdapter;
import com.example.android.demofancymonk.adapter.RecAdapter;
import com.example.android.demofancymonk.model.DerpDemo;
import com.example.android.demofancymonk.model.MenuDemo;
import com.example.android.demofancymonk.model.MenuItem;

import java.util.ArrayList;

public class FoodMenuActivity extends AppCompatActivity {
  RecyclerView recView2;
   MenuAdapter adapter;
    FloatingActionButton buttonConfirm;
    private ArrayList<MenuItem> foodData=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);
        recView2 = (RecyclerView) findViewById(R.id.rec_menu);
        buttonConfirm=(FloatingActionButton)findViewById(R.id.fab_confirm);
        foodData.addAll(MenuDemo.getMenuData());
        MenuAdapter menuAdapter=new MenuAdapter(foodData,this);
        recView2.setAdapter(menuAdapter);
       buttonConfirm.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i=new Intent(FoodMenuActivity.this,ConfirmActivity.class);
               startActivity(i);
           }
       });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recView2.setLayoutManager(linearLayoutManager);

        // Items show default animation even if we do not set this
        recView2.setItemAnimator(new DefaultItemAnimator());
        //endregion



    }
}
