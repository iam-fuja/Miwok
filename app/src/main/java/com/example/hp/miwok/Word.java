package com.example.hp.miwok;

public class Word {

    /**
     * Default(English) translation for the word
     */
    private String mDefaultTranslation;

    /**
     * Miwok translation for the word
     */
    private String mMiwokTranslation;

    /**
     * Default(English) translation for the word
     */
    private int mAudioResourceId;

    /**
     * Image Resource per word
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    //*create a new word oblect/
    //    @param  defaultTanslation is word in English
    //    @param  miwokTranslation is word in Miwok
    //    @param  Image Resource
    //   CONSTRUCTOR / /

    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }

    //*create a new word oblect/
    //    @param  defaultTanslation is word in English
    //    @param  miwokTranslation is word in Miwok
    //    @param  Image Resource
    //   CONSTRUCTOR / /

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    /*Get Default Translation*/
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /*Get Miwok Translation*/
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /*Get Image Resourxe ID*/
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * Return the audio resource ID of the word.
     */
    public int getAudioResourceId() {
        return mAudioResourceId;
    }
}

