package com.codebits.sodalit.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.codebits.sodalit.R;
import com.codebits.sodalit.adapter.MainPagerAdapter;

public class Main_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    LinearLayout ll_home, ll_mysos, selector_home, selector_mysos;
    ViewPager vpMain;
    TabLayout tabMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Init();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Init_Nav(navigationView);
    }

    private void Init() {
        tabMain=(TabLayout)findViewById(R.id.tab_main);
        vpMain=(ViewPager)findViewById(R.id.vpMain);
        vpMain.setAdapter(new MainPagerAdapter(getSupportFragmentManager(),this));
        tabMain.setupWithViewPager(vpMain);
        this.setTitle(getResources().getString(R.string.home));
    }

    private void Init_Nav(NavigationView navigationView) {
        ll_home = (LinearLayout) navigationView.findViewById(R.id.ll_home);
        ll_mysos = (LinearLayout) navigationView.findViewById(R.id.ll_mysos);
        selector_home = (LinearLayout) navigationView.findViewById(R.id.selector_home);
        selector_mysos = (LinearLayout) navigationView.findViewById(R.id.selector_mysos);

        ll_home.setOnClickListener(this);
        ll_mysos.setOnClickListener(this);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_home:
                break;
            case R.id.ll_mysos:
                Intent i = new Intent(Main_Activity.this, MySosActivity.class);
                startActivity(i);
                break;
        }
    }

}

