package com.example.android.demofancymonk.model;

import com.example.android.demofancymonk.R;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;

/**
 * Created by harshit009 on 6/4/2017.
 */

public class DerpDemo {
    private static final String[] titles = {"Hotel1","Hotel2","Hotel3","Hotel4","Hotel5","Hotel6"};
    private static final String[] subTitles = {"Location1","Location2","Location3","Location4","Location5","Location6"};
    private static int iconLocation= R.drawable.ic_place_white_24dp;

    public static ArrayList<ListItem> getListData(){
        ArrayList<ListItem> data=new ArrayList<>();

        for(int x=0;x<titles.length;x++){
            for(int i =0;i<titles.length;i++) {
                ListItem item = new ListItem();
                item.setTitle(titles[i]);
                item.setSubTitle(subTitles[i]);
                item.setImagResId(iconLocation);
          /*  item.setImagResId(iconLocation);
          */ data.add(item);
            }
        }
        return data;
    }

}
