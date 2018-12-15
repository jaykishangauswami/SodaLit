package com.riv.sodalit.Activity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.riv.sodalit.R;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
//        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        String status=getIntent().getExtras().getString("status");
        if(status!=null&&status.equals("1")){
            shownotificationpopup();
        }
    }

    private void shownotificationpopup() {
        AlertDialog.Builder builder=new AlertDialog.Builder(NotificationActivity.this);
        View view=LayoutInflater.from(NotificationActivity.this).inflate(R.layout.raw_alert_call,null,false);
        builder.setView(view);
        AlertDialog alert=builder.create();
        alert.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alert.show();
    }
}
