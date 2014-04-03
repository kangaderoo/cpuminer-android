package com.mdelling.cpuminer;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class DevicePreferences extends PreferenceFragment implements OnSharedPreferenceChangeListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	final Context context = this.getActivity().getApplicationContext();
    	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.device_preferences);
        loadPreferences(prefs);
    }

	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
		loadPreferences(sharedPreferences);
	}

	@Override
	public void onResume() {
	    super.onResume();
	    getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);

	}

	@Override
	public void onPause() {
	    getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
	    super.onPause();
	}

	public void loadPreferences(SharedPreferences prefs) {
		// Nothing to do at the moment
	}
}