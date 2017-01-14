package com.gdut.LeShuhua.global;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import static android.content.ContentValues.TAG;

/**
 * Created by lchua on 2017/1/14.
 * <p>
 * 描述：
 */

public class UserConstant {

    private SharedPreferences mPreferences;
    private Gson mGson;
    private static UserConstant mUserConstant;

    public static UserConstant getInstance(Context context) {
        if (mUserConstant == null)
            mUserConstant = new UserConstant(context);
        return mUserConstant;
    }

    private UserConstant(Context context) {
        mPreferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        mGson = new Gson();
    }

}
