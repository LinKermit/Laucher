package com.kermit.lin.newlearn.activity.settings;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.kermit.lin.newlearn.R;
import com.kermit.lin.newlearn.base.RxBaseActivity;

import butterknife.BindView;

public class SettingActivity extends RxBaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {

        getFragmentManager().beginTransaction().replace(R.id.frameLayout,new SettingFragment()).commit();
    }

    @Override
    public void initToolBar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("设置");
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
