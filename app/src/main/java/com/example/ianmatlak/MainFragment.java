package com.example.ianmatlak;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class MainFragment extends Fragment {
    private static final String TAG = "MainFragment";

    public MainFragment() {
    }

    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        Log.d(TAG, "onCreateView: ");
        View fragmentRootView = inflater.inflate(R.layout.fragment_main, parent,false);
        return fragmentRootView;
        }

    @Override
    public void onViewCreated(View view, Bundle saveInstanceState){
        // Setup any handles to view objects here
        Log.d(TAG, "onViewCreated: ");
        ImageButton btnBank = (ImageButton) view.findViewById(R.id.btnBank);
        ImageButton btnInfo = (ImageButton) view.findViewById(R.id.btnInfo);

        //transition to activity
        btnBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),AccountListActivity.class));
            }
        });
        //transition to activity
        btnInfo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity((new Intent(getActivity(),AppInfoActivity.class)));
            }
        });
    }
}
