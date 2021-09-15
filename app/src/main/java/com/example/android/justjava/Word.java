package com.example.android.justjava;

public class Word {

    private String mDefautTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId = NO_IMAGE;
    private static final int NO_IMAGE= -1;

    private int mMediaPlayerId;


    public Word (String defautTranslation, String miwokTranslation, int mediaPlayeriD){
        mDefautTranslation =defautTranslation;
        mMiwokTranslation=miwokTranslation;
        mMediaPlayerId = mediaPlayeriD;
    }

    public Word (int imageResourceId, String defautTranslation, String miwokTranslation, int mediaPlayeriD){
        mImageResourceId = imageResourceId;
        mDefautTranslation =defautTranslation;
        mMiwokTranslation=miwokTranslation;
        mMediaPlayerId = mediaPlayeriD;
    }

    public int getImageResourceId(){return mImageResourceId;}

    public String getDefautTranslation(){
        return mDefautTranslation;
    }

    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    public int getMediaPlayerId() {
        return mMediaPlayerId;
    }

    //DoPhrase Acitivity chỉ ko có image nên bị blan, để fix thì phải thêm hàm này

    public boolean hasImage (){
        return mImageResourceId !=NO_IMAGE;

    }

    //nhấn alt+insert, chọn hàm toString
    //Sau đó, bất cứ khi nào bạn có đối tượng Word, chẳng hạn như trong
    //onItemClick () của OnItemClickListener, bạn có thể in đối tượng Word ra Log.v.
    @Override
    public String toString() {
        return "Word{" +
                "mDefautTranslation='" + mDefautTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mMediaPlayerId=" + mMediaPlayerId +
                '}';
    }
}
