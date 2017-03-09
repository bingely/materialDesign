package com.bingley.materialdesign.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.JavascriptInterface;
import android.widget.LinearLayout;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.activity.KnowlegeListActivity;
import com.bingley.materialdesign.base.BaseActivity;
import com.bingley.materialdesign.fragment.MainFragment;
import com.bingley.materialdesign.mvp.osc.OscMainActivity;
import com.bingley.materialdesign.view.IosProgress;

import butterknife.Bind;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Fragment mainFragment;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 初始化一些fragment页面的逻辑
        if (savedInstanceState != null) {
            mainFragment = (MainFragment)getSupportFragmentManager().getFragment(savedInstanceState, "MainFragment");
        } else {
            mainFragment = MainFragment.newInstance();
        }

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (!mainFragment.isAdded()) {
            fragmentTransaction.add(R.id.layout_fragment, mainFragment,"MainFragment").commit();
        }
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }



    /**
     * 这个是侧滑条目的item点击事件触发的事件
     *
     * @param item
     * @return
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id) {
            case R.id.project_osc:
                //startActivity(new Intent(this, XsqMainActivity.class));
                startActivity(new Intent(this, OscMainActivity.class));
                break;
            case R.id.item_leanningbasic:
                startActivity(new Intent(this, KnowlegeListActivity.class));
                break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
