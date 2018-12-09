package com.codebits.sodalit.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codebits.sodalit.NotidficationSettingActivity;
import com.codebits.sodalit.R;

public class FlatExpandableAdapter extends BaseExpandableListAdapter {
    @Override
    public int getGroupCount() {
        return 1;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 2;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_layout_group_flatexpandable,parent,false);

        return v;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, final ViewGroup parent) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_layout_child_flatexpandable,parent,false);
        TextView tvChild=(TextView)v.findViewById(R.id.tvChild);
        ImageView ivChild=(ImageView)v.findViewById(R.id.imgChild);

        if(childPosition!=1){
            tvChild.setText(parent.getContext().getResources().getString(R.string.e_intercomesetup_adapter));
            ivChild.setImageResource(R.drawable.ic_vibration_black_24dp);
        }else {
            tvChild.setText("");
            ivChild.setImageResource(R.drawable.ic_delete_black_24dp);
        }
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(parent.getContext(),NotidficationSettingActivity.class);
                parent.getContext().startActivity(intent);
            }
        });
        return v;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
