package com.example.android.demofancymonk.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by harshit009 on 6/5/2017.
 */

public class MenuDemo {
    private static final String demo[]={"Demo1","Demo2","Demo3","Demo4","Demo5","Demo6"};

    public static List<MenuItem> getMenuData(){
        List<MenuItem> menuList=new ArrayList<>();

        for(int x=0;x<demo.length;x++){
            MenuItem mItem=new MenuItem();
            mItem.setDemoItem(demo[x]);
            menuList.add(mItem);
        }
        return menuList;
    }
}
