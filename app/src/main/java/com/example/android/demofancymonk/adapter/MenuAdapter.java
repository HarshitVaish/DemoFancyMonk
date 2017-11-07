package com.example.android.demofancymonk.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.example.android.demofancymonk.ConfirmActivity;
import com.example.android.demofancymonk.MenuActivity;
import com.example.android.demofancymonk.R;
import com.example.android.demofancymonk.model.MenuItem;

import java.util.List;

import static android.R.id.list;
import static android.media.CamcorderProfile.get;
import static android.os.Build.VERSION_CODES.M;

/**
 * Created by harshit009 on 6/5/2017.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuHolder> {
    private List<MenuItem> menuData;
    private LayoutInflater inflator;
    private Context context;
    public MenuAdapter(List<MenuItem> menuData, Context c) {
        this.inflator = LayoutInflater.from(c);
        this.menuData =menuData;
        context=c;

    }

    @Override
    public MenuHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflator.inflate(R.layout.menu_item,parent,false);
        return new MenuHolder(view);

    }

    @Override
    public void onBindViewHolder(MenuHolder holder, int position) {
      MenuItem menuItem=menuData.get(position);
        holder.setFood(menuItem,position);

    }

    @Override
    public int getItemCount() {
        return menuData.size();
    }

    public class MenuHolder extends RecyclerView.ViewHolder {
        private CheckBox selectedfood;
        int position;
        Button buttonConfirm,buttonBack;

        MenuItem currentMenuItem;
        public MenuHolder(View itemView) {
            super(itemView);
            selectedfood=(CheckBox) itemView.findViewById(R.id.select_item);

            selectedfood.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });



        }
        public void setFood(MenuItem currentMenuItem,int position){
            this.position=position;
            this.currentMenuItem=currentMenuItem;
            selectedfood.setText(currentMenuItem.getDemoItem());

        }
    }


}
