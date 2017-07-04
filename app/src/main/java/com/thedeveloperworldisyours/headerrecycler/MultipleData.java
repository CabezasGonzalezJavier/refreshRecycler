package com.thedeveloperworldisyours.headerrecycler;

/**
 * Created by javiergonzalezcabezas on 4/7/17.
 */

public class MultipleData {

    private String mTitle;
    private boolean mBoolean;
    private boolean mSection;


    public MultipleData(String title, boolean mBoolean) {
        this.mTitle = title;
        this.mBoolean = mBoolean;
        this.mSection = false;
    }

    public MultipleData(String mTitle, boolean mBoolean, boolean mSection) {
        this.mTitle = mTitle;
        this.mBoolean = mBoolean;
        this.mSection = mSection;
    }

    public boolean ismSection() {
        return mSection;
    }

    public void setmSection(boolean mSection) {
        this.mSection = mSection;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public boolean isBoolean() {
        return mBoolean;
    }

    public void setBoolean(boolean mBoolean) {
        this.mBoolean = mBoolean;
    }

}
