package com.example.applylistview.Pojo;

public class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int imageId = No_Image;
    private static final int No_Image = -1;
    private int audio_id;

    public Word(String mDefaultTranslation, String mMiwokTranslation, int imageId, int audio_id) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.imageId = imageId;
        this.audio_id = audio_id;
    }

    public Word(String mDefaultTranslation, String mMiwokTranslation, int audio_id) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.audio_id = audio_id;
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImageId() {
        return imageId;
    }

    public int getAudio_id() {
        return audio_id;
    }

    public boolean has_image() {
        return imageId != No_Image;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", imageId=" + imageId +
                ", audio_id=" + audio_id +
                '}';
    }
}
