package com.kermit.lin.newlearn.activity.settings;

import android.content.DialogInterface;
import android.icu.util.ValueIterator;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.webkit.WebView;

import com.kermit.lin.newlearn.R;
import com.kermit.lin.newlearn.utils.Settings;

/**
 * Created by Lin on 2017/6/15.
 */

public class SettingFragment extends PreferenceFragment implements Preference.OnPreferenceClickListener,
        Preference.OnPreferenceChangeListener{

    private Preference mLanguage;
    private Preference mSearch;
    private CheckBoxPreference mExit;
    private CheckBoxPreference mNight;
    private CheckBoxPreference mNoPicture;
    private CheckBoxPreference mRefresh;
    private Preference mCache;

    private Preference mUpdate;

    Settings settings = Settings.getInstance();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);

        mLanguage = findPreference("key_language");
        mSearch = findPreference("key_search");
        mExit = (CheckBoxPreference) findPreference("key_exit");
        mNight = (CheckBoxPreference) findPreference("key_night");
        mNoPicture = (CheckBoxPreference) findPreference("key_no_picture");
        mRefresh = (CheckBoxPreference) findPreference("key_refresh");
        mCache = findPreference("key_cache");
        mUpdate = findPreference("key_update");

        mSearch.setOnPreferenceClickListener(this);
        mExit.setOnPreferenceChangeListener(this);
        mNight.setOnPreferenceChangeListener(this);
        mNoPicture.setOnPreferenceChangeListener(this);
        mRefresh.setOnPreferenceChangeListener(this);
        mCache.setOnPreferenceClickListener(this);
        mUpdate.setOnPreferenceClickListener(this);

        mSearch.setSummary(getResources().getStringArray(R.array.search)[settings.getInt(Settings.KEY_SEARCH,0)]);
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        if (preference == mSearch){
            ShowSearchSettingDialog();
            return true;
        }else if (preference == mCache){
            clearCache();
            return true;
        }else if (preference == mUpdate){
            return true;
        }
        return false;
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        if (preference  == mNoPicture){//无图
            Settings.noPicMode =  Boolean.valueOf(newValue.toString());
            settings.putBoolen(Settings.KEY_NO_PIC, Settings.noPicMode);
            return true;
        }else if (preference == mExit){//两次退出
            Settings.doubleExit = Boolean.valueOf(newValue.toString());
            settings.putBoolen(Settings.KEY_EXIT,Settings.doubleExit);
            return true;
        }else if (preference == mNight){
            Settings.isNight = Boolean.valueOf(newValue.toString());
            settings.putBoolen(Settings.KEY_NIGHT,Settings.isNight);
            return true;
        }else if (preference == mRefresh){
            Settings.auto_refresh = Boolean.valueOf(newValue.toString());
            settings.putBoolen(Settings.KEY_REFRESH,Settings.auto_refresh);
            return true;
        }
        return false;
    }


    private void ShowSearchSettingDialog(){
        new AlertDialog.Builder(getActivity())
                .setTitle(getString(R.string.text_search))
                .setSingleChoiceItems(getResources().getStringArray(R.array.search),
                        Settings.searchID, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mSearch.setSummary(getResources().getStringArray(R.array.search)[which]);
                                Settings.searchID = which;
                                settings.putInt(Settings.KEY_SEARCH,Settings.searchID);
                                dialog.dismiss();
                            }
                        }
                ).show();
    }


    /**
     * 清除浏览器缓存
     */
    private void clearCache() {
        WebView webView = new WebView(getActivity());
        webView.clearCache(true);
    }

    /**
     * 检查更新
     */



}
