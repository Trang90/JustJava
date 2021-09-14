package com.example.android.justjava;

public class Word {
    private int mImageResourceId = NO_IMAGE;
    private String mDefautTranslation;
    private String mMiwokTranslation;

    private static final int NO_IMAGE= -1;

    public Word (String defautTranslation, String miwokTranslation){
        mDefautTranslation =defautTranslation;
        mMiwokTranslation=miwokTranslation;
    }

    public Word (int imageResourceId, String defautTranslation, String miwokTranslation){
        mImageResourceId = imageResourceId;
        mDefautTranslation =defautTranslation;
        mMiwokTranslation=miwokTranslation;
    }

    public int getImageResourceId(){return mImageResourceId;}

    public String getDefautTranslation(){
        return mDefautTranslation;
    }

    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    //DoPhrase Acitivity chỉ ko có image nên bị blan, để fix thì phải thêm hàm này

    public boolean hasImage (){
        return mImageResourceId !=NO_IMAGE;

    }

}
