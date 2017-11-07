package com.example.android.demofancymonk.model;

/**
 * Created by harshit009 on 6/4/2017.
 */

public class ListItem {
    private String title;
    private String subTitle;

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    private boolean favourite=false;
    private int imagResId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImagResId() {
        return imagResId;
    }

    public void setImagResId(int imagResId) {
        this.imagResId = imagResId;
    }
}
