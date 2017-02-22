package com.deqode.android.geoquiz;

/**
 * Created by dmLabs on 2/21/17.
 * this my commentsx
 */

public class Questions {

    private int mTextResId;
    private boolean mAnswer;

    public Questions(int textResId, boolean answer) {
        mTextResId = textResId;
        mAnswer = answer;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public void setAnswer(boolean answer) {
        mAnswer = answer;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public boolean isAnswer() {
        return mAnswer;
    }
}
