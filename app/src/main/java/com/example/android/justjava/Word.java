package com.example.android.justjava;

public class Word {

    private String mDefautTranslation;
    private String mMiwokTranslation;

    public Word (String defautTranslation, String miwokTranslation){
        mDefautTranslation =defautTranslation;
        mMiwokTranslation=miwokTranslation;
    }

    public String getDefautTranslation(){
        return mDefautTranslation;
    }

    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

}
