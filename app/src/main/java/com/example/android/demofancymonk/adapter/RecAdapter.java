package com.example.android.demofancymonk.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.demofancymonk.FoodMenuActivity;
import com.example.android.demofancymonk.MainActivity;
import com.example.android.demofancymonk.MenuActivity;
import com.example.android.demofancymonk.R;
import com.example.android.demofancymonk.model.ListItem;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by harshit009 on 6/4/2017.
 */

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.recHolder> {
   private Context context;
   private List<ListItem> mList;
   private LayoutInflater inflater;



    class recHolder extends RecyclerView.ViewHolder  {
        private TextView title,subTitle;
        private ImageView icon;
        RelativeLayout Rel;
        ListItem currentListItem;
        int position;

        private recHolder(View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.ibl_item_text);
            subTitle=(TextView)itemView.findViewById(R.id.ibl_list_itm_loctn);
            icon=(ImageView)itemView.findViewById(R.id.img_list_item);
            Rel=(RelativeLayout)itemView.findViewById(R.id.cont_item_branch);

            Rel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,FoodMenuActivity.class);
                    context.startActivity(intent);
                }
            });

        }
        public void setData(ListItem currentListItem,int position){
            this.position=position;
            this.currentListItem=currentListItem;
            title.setText(currentListItem.getTitle());
            subTitle.setText(currentListItem.getSubTitle());
            icon.setImageResource(currentListItem.getImagResId());
        }

        }


    public RecAdapter(List<ListItem> listData, Context c) {
    mList=listData;
    context=c;
    inflater= LayoutInflater.from(context);
    }

    @Override
    public RecAdapter.recHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.list_item,parent,false);
        return new recHolder(view);
    }

    @Override
    public void onBindViewHolder(RecAdapter.recHolder holder, final int position) {
   ListItem listItem=mList.get(position);
        holder.setData(listItem,position);
    }

    @Override
    public int getItemCount() {
    return mList.size();}
}
