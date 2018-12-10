package com.codebits.sodalit;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.codebits.sodalit.adapter.ListEmergancyAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListEmergancyFragment extends Fragment {


    private RecyclerView rvListemergancy;

    public ListEmergancyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_list_emergancy, container, false);
        rvListemergancy=(RecyclerView)v.findViewById(R.id.rvListEmergancy);
        rvListemergancy.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayout.VERTICAL,false));
        rvListemergancy.setAdapter(new ListEmergancyAdapter(getContext()));
        return v;
    }

}
