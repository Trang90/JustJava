package com.example.android.justjava;

public class ReportCard {

    private String mName;
    private String mEnglish;
    private String mMath;

    public ReportCard (String name, String english, String math){
        mName = name;
        mEnglish = english;
        mMath =math;
    }
    public String getmName() {
        return mName;
    }
    public String getmEnglish() {
        return mEnglish;
    }

    public String getmMath() {
        return mMath;
    }
}
