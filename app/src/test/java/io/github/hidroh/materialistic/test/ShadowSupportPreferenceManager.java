package io.github.hidroh.materialistic.test;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroupAdapter;
import android.support.v7.preference.PreferenceManager;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

@Implements(PreferenceManager.class)
public class ShadowSupportPreferenceManager {

    @Implementation
    public static SharedPreferences getDefaultSharedPreferences(Context context) {
        return android.preference.PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static int getPreferencePosition(PreferenceGroupAdapter adapter,
                                            Class<? extends Preference> clazz) {
        for (int i = 0; i < adapter.getItemCount(); i++) {
            if (clazz.isInstance(adapter.getItem(i))) {
                return i;
            }
        }
        throw new Resources.NotFoundException();
    }
}
