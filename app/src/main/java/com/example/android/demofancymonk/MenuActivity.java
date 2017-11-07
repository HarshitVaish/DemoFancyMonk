package com.example.android.demofancymonk;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.android.demofancymonk.adapter.RecAdapter;
import com.example.android.demofancymonk.model.DerpDemo;
import com.example.android.demofancymonk.model.ListItem;

import java.util.ArrayList;

import static com.example.android.demofancymonk.model.DerpDemo.getListData;

public class MenuActivity extends AppCompatActivity {

    RecyclerView recView;
    FloatingActionButton buttonFilter;
    private ArrayList<ListItem> listData = new ArrayList<>();


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        recView = (RecyclerView) findViewById(R.id.recycler_view);
        buttonFilter=(FloatingActionButton)findViewById(R.id.fab_filter);
        listData.addAll(DerpDemo.getListData());
        RecAdapter recAdapter = new RecAdapter(listData, this);
        recView.setAdapter(recAdapter);
        buttonFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuActivity.this,"Will Filter Your Options",Toast.LENGTH_SHORT).show();
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recView.setLayoutManager(linearLayoutManager);

        // Items show default animation even if we do not set this
        recView.setItemAnimator(new DefaultItemAnimator());
        //endregion



    }


}
