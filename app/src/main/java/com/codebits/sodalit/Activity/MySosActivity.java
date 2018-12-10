package com.codebits.sodalit.Activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.codebits.sodalit.R;
import com.codebits.sodalit.adapter.MySOSPagerAdapter;

public class MySosActivity extends AppCompatActivity {
    ViewPager vpMysos;
    TabLayout tabMysos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_sos);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        InIt();
    }

    private void InIt() {
        this.setTitle(getResources().getString(R.string.title_mysos));
        vpMysos=(ViewPager)findViewById(R.id.vpMysos);
        tabMysos=(TabLayout)findViewById(R.id.tab_mySos);
        vpMysos.setAdapter(new MySOSPagerAdapter(getSupportFragmentManager(),this));
        tabMysos.setupWithViewPager(vpMysos);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            case  R.id.action_add:
                //todo Add SOS Activity
//                Intent i=new Intent(MySosActivity.this)
        }
        return super.onOptionsItemSelected(item);
    }
}
