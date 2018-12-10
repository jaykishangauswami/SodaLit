package com.codebits.sodalit.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.Switch;

import com.codebits.sodalit.R;

public class NotidficationSettingActivity extends AppCompatActivity {
    FrameLayout frameenable;
    Switch aSwitch,e_intercomswithch,dailyhelpswitch,yourguestswitch,deliveryswitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notidfication_setting);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        this.setTitle(getResources().getString(R.string.notification_setting_title));
        aSwitch = (Switch) findViewById(R.id.mutenotification);
        e_intercomswithch = (Switch) findViewById(R.id.e_intercomswithch);
        dailyhelpswitch = (Switch) findViewById(R.id.dailyhelpswitch);
        yourguestswitch = (Switch) findViewById(R.id.yourguestswitch);
        deliveryswitch = (Switch) findViewById(R.id.deliveryswitch);
        frameenable = (FrameLayout) findViewById(R.id.frameenable);
        if(!aSwitch.isChecked()){
            e_intercomswithch.setChecked(true);
            dailyhelpswitch.setChecked(true);
            yourguestswitch.setChecked(true);
            deliveryswitch.setChecked(true);
        }

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    frameenable.setVisibility(View.VISIBLE);
                    e_intercomswithch.setChecked(false);
                    dailyhelpswitch.setChecked(false);
                    yourguestswitch.setChecked(false);
                    deliveryswitch.setChecked(false);

                    e_intercomswithch.setEnabled(false);
                    dailyhelpswitch.setEnabled(false);
                    yourguestswitch.setEnabled(false);
                    deliveryswitch.setEnabled(false);
                } else {
                    frameenable.setVisibility(View.GONE);
                    e_intercomswithch.setChecked(true);
                    dailyhelpswitch.setChecked(true);
                    yourguestswitch.setChecked(true);
                    deliveryswitch.setChecked(true);

                    e_intercomswithch.setEnabled(true);
                    dailyhelpswitch.setEnabled(true);
                    yourguestswitch.setEnabled(true);
                    deliveryswitch.setEnabled(true);
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
