package com.kermit.lin.newlearn.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.jaeger.library.StatusBarUtil;
import com.kermit.lin.newlearn.R;
import com.kermit.lin.newlearn.activity.settings.SettingActivity;
import com.kermit.lin.newlearn.base.RxBaseActivity;
import com.kermit.lin.newlearn.module.fragment.BangumiFragment;
import com.kermit.lin.newlearn.module.fragment.HomeFragment;
import com.kermit.lin.newlearn.module.fragment.LearnFragment;
import com.kermit.lin.newlearn.module.fragment.UserFragment;
import com.kermit.lin.newlearn.utils.Settings;

import butterknife.BindView;

public class MainActivity extends RxBaseActivity implements
        NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.iv_menu)
    ImageView iv_menu;

    @BindView(R.id.tab)
    TabLayout tabLayout;

    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    private Fragment[] fragments;
    private String[] fragmentNames;
    Settings settings = Settings.getInstance();
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        iv_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
//        StatusBarUtil.setColorForDrawerLayout(this, mDrawerLayout, Color.argb(0,63,81,181));
        initFragment();
        mViewPager.setOffscreenPageLimit(3);//决定缓存Fragment的状态个数，不设置，隔一个fragment跳转崩溃
        mViewPager.setAdapter(new MyHomeAdapter(getSupportFragmentManager(),fragments,fragmentNames));
        mViewPager.setCurrentItem(0);
        tabLayout.setupWithViewPager(mViewPager);
        navigationView.setNavigationItemSelectedListener(this);

        initSettings();
    }

    @Override
    public void initToolBar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("");
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(false);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_home:
                mDrawerLayout.closeDrawers();
                break;
            case R.id.item_vip:
                mDrawerLayout.closeDrawers();
                break;
            case R.id.item_download:

                mDrawerLayout.closeDrawers();
                break;
            case R.id.item_favourite:
                mDrawerLayout.closeDrawers();
                break;
            case R.id.item_history:
                mDrawerLayout.closeDrawers();
                break;
            case R.id.item_group:
                mDrawerLayout.closeDrawers();
                break;
            case R.id.item_tracker:
                mDrawerLayout.closeDrawers();
                break;
            case R.id.item_theme:

                mDrawerLayout.closeDrawers();
                break;
            case R.id.item_app:

                mDrawerLayout.closeDrawers();
                break;
            case R.id.item_settings:
                Intent sIntent = new Intent(this, SettingActivity.class);
                startActivity(sIntent);
                mDrawerLayout.closeDrawers();
                break;
            default:
                break;
        }
        return true;
    }

    /**
     * 初始化主页Fragment
     */
    private void initFragment() {
        HomeFragment homeFragment = HomeFragment.newInstance();
        BangumiFragment bangumiFragment = BangumiFragment.newInstance();
        LearnFragment learnFragment = LearnFragment.newInstance();
        UserFragment userFragment = UserFragment.newInstance();

        fragments = new Fragment[] {
                homeFragment,
                bangumiFragment,
                learnFragment,
                userFragment};
        fragmentNames = new String[]{"主页", "视频", "学习", "个人"};
    }

    /**
     * 主页适配器
     */
    private class MyHomeAdapter extends FragmentPagerAdapter {
        Fragment[] fragments;
        String[] fragmentNames;
        public MyHomeAdapter(FragmentManager fm, Fragment[] fragments, String[] fragmentNames) {
            super(fm);
            this.fragments = fragments;
            this.fragmentNames = fragmentNames;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments[position];
        }

        @Override
        public int getCount() {
            return fragments.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentNames[position];
        }
    }

    /**
     * 菜单选择
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_top,menu);
//        MenuItem item = menu.findItem(R.id.main_top_search);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.main_top_game:
                break;
            case R.id.main_top_down:
                break;
            case R.id.main_top_search:
                Toast.makeText(this,"search",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initSettings() {
        settings.getBoolen(Settings.KEY_NO_PIC,Settings.noPicMode);
        settings.getBoolen(Settings.KEY_EXIT,Settings.doubleExit);//设置默认两次退出
        settings.getBoolen(Settings.KEY_NIGHT,Settings.isNight);//设置默认两次退出
        settings.getBoolen(Settings.KEY_REFRESH,Settings.auto_refresh);//设置默认两次退出
        settings.getInt(Settings.KEY_SEARCH,0);
    }
}
