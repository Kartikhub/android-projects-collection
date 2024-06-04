package com.example.lenovo.myapplication;

import android.app.Fragment;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        PreferenceManager.setDefaultValues(this,R.xml.pref_detail, false);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();
    }

    public static class SettingsFragment extends PreferenceFragment{
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.pref_detail);

            for (int i=0; i<getPreferenceScreen().getPreferenceCount();i++){
                pickPreferenceObject(getPreferenceScreen().getPreference(i));
            }
        }

        private void pickPreferenceObject(Preference preference) {
            if(preference instanceof PreferenceCategory){
                PreferenceCategory category = (PreferenceCategory) preference;
                for (int i=0; i<category.getPreferenceCount();i++){
                    pickPreferenceObject(category.getPreference(i));
                }
            }else{
                initSummary(preference);
            }
        }

        private void initSummary(Preference preference) {
            if(preference instanceof EditTextPreference){
                EditTextPreference edittextpref= (EditTextPreference) preference;
                preference.setSummary(edittextpref.getText()+ " is added");
            }else if(preference instanceof ListPreference){
                ListPreference listpref= (ListPreference) preference;
                preference.setSummary(listpref.getEntry());
            }
        }
    }



}
