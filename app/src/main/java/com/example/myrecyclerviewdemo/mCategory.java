package com.example.myrecyclerviewdemo;

import java.util.ArrayList;

public class mCategory {

    private String title;
    private ArrayList<mCategoryData> data;

    public mCategory() {
    }

    public mCategory(String title, ArrayList<mCategoryData> data) {
        this.title = title;
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<mCategoryData> getData() {
        return data;
    }

    public void setData(ArrayList<mCategoryData> data) {
        this.data = data;
    }
}
