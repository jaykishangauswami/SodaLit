package com.riv.sodalit.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import com.riv.sodalit.R;
import com.riv.sodalit.adapter.FlatExpandableAdapter;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout llNotificationSetting, llChangePassword, llTellFriend, llFeedback, llsupport, llHowitworks, llFlatVila;
    ExpandableListView list_flatsetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle(getResources().getString(R.string.settingTitle));
        Init();
    }

    private void Init() {
        llNotificationSetting = (LinearLayout) findViewById(R.id.llNotificationSetting);
        llChangePassword = (LinearLayout) findViewById(R.id.llChangePassword);
        llTellFriend = (LinearLayout) findViewById(R.id.llTellFriend);
        llFeedback = (LinearLayout) findViewById(R.id.llFeedback);
        llsupport = (LinearLayout) findViewById(R.id.llsupport);
        llHowitworks = (LinearLayout) findViewById(R.id.llHowitworks);
        llFlatVila = (LinearLayout) findViewById(R.id.llFlatVila);
        list_flatsetting = (ExpandableListView) findViewById(R.id.list_flatsetting);

        list_flatsetting.setAdapter(new FlatExpandableAdapter());
        list_flatsetting.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                setListViewHeight(parent, groupPosition);
                return false;
            }
        });

        llNotificationSetting.setOnClickListener(this);
        llChangePassword.setOnClickListener(this);
        llTellFriend.setOnClickListener(this);
        llFeedback.setOnClickListener(this);
        llsupport.setOnClickListener(this);
        llHowitworks.setOnClickListener(this);
        llFlatVila.setOnClickListener(this);


    }
    private void setListViewHeight(ExpandableListView listView,
                                  int group) {
        ExpandableListAdapter listAdapter = (ExpandableListAdapter) listView.getExpandableListAdapter();
        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(),
                View.MeasureSpec.EXACTLY);
        for (int i = 0; i < listAdapter.getGroupCount(); i++) {
            View groupItem = listAdapter.getGroupView(i, false, null, listView);
            groupItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);

            totalHeight += groupItem.getMeasuredHeight();

            if (((listView.isGroupExpanded(i)) && (i != group))
                    || ((!listView.isGroupExpanded(i)) && (i == group))) {
                for (int j = 0; j < listAdapter.getChildrenCount(i); j++) {
                    View listItem = listAdapter.getChildView(i, j, false, null,
                            listView);
                    listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);

                    totalHeight += listItem.getMeasuredHeight();

                }
            }
            ViewGroup.LayoutParams params = listView.getLayoutParams();
            int height = totalHeight
                    + (listView.getDividerHeight() * (listAdapter.getGroupCount() - 1));
            if (height < 10)
                height = 200;
            params.height = height;
            listView.setLayoutParams(params);
            listView.requestLayout();


        }
    }
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(SettingActivity.this,NotidficationSettingActivity.class);
        switch (v.getId()) {
            case R.id.llNotificationSetting:
                startActivity(intent);
                break;
            case R.id.llChangePassword:
                startActivity(intent);
                break;
            case R.id.llFeedback:
                startActivity(intent);
                break;
            case R.id.llFlatVila:
                startActivity(intent);
                break;
            case R.id.llHowitworks:
                startActivity(intent);
                break;
            case R.id.llsupport:
                startActivity(intent);
                break;
            case R.id.llTellFriend:
                startActivity(intent);
                break;
        }
    }

}
