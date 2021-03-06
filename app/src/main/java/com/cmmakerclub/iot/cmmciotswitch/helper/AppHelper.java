package com.cmmakerclub.iot.cmmciotswitch.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.CompoundButton;

import com.cmmakerclub.iot.cmmciotswitch.Constants;

import butterknife.ButterKnife;

/**
 * Created by nat on 12/1/15 AD.
 */
public class AppHelper {
    public static final String TAG = AppHelper.class.getSimpleName();
    public static final ButterKnife.Setter<CompoundButton, Boolean> SET_COMPOUND_VIEW_CHECK =
            new ButterKnife.Setter<CompoundButton, Boolean>() {
        @Override
        public void set(CompoundButton view, Boolean value, int index) {
            Log.d(TAG, " (line 16): " + index);
            view.setChecked(value);
        }
    };


    public static final ButterKnife.Setter<CompoundButton, Character> UPDATE_TOGGLE_STATE =
            new ButterKnife.Setter<CompoundButton, Character>() {
                @Override
                public void set(CompoundButton view, Character value, int index) {
                    int result = value.charValue() & (1 << index);
                    view.setChecked(result!=0);
                }
            };


    public static SharedPreferences getSharedPreference(Context context) {
        SharedPreferences mSharedPref = context.getSharedPreferences(Constants.APP_PREF,
                Context.MODE_PRIVATE);
        return mSharedPref;
    }

    public static String getString(Context context, String key, String fallback) {
        SharedPreferences mSharedPref = context.getSharedPreferences(Constants.APP_PREF,
                Context.MODE_PRIVATE);


        return mSharedPref.getString(key, fallback);
    }



    public static boolean setString(Context context, String key, String value) {
        SharedPreferences mSharedPref = context.getSharedPreferences(Constants.APP_PREF,
                Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = mSharedPref.edit();

        editor.putString(key, value);
        return editor.commit();
    }
}
