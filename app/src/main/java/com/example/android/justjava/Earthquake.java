package com.example.android.justjava;

public class Earthquake {
    private Double mMagnitude;
    private String mLocation;
    private Long mTimeInMilliseconds;
    private String mUrl;

    public Earthquake (Double magnitude, String location, Long date, String url) {
        mMagnitude=magnitude;
        mLocation=location;
        mTimeInMilliseconds= date;
        mUrl =url;
    }

    public Double getMagnitude() {
        return mMagnitude;
    }
    public String getLocation() {
        return mLocation;
    }
    public Long getDate() {
        return mTimeInMilliseconds;
    }
    public String getUrl() {
        return mUrl;
    }
}