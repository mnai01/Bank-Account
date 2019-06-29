package com.example.ianmatlak;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class AppInfoActivity extends AppCompatActivity {

    private static final String TAG = "AppInfoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_appinfo);
        FragmentAppInfo();
    }

    //used to attach fragment to container
    public void FragmentAppInfo(){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            //ui_container is Framelayout.
            fragmentTransaction.add(R.id.ui_container, new AppInfoFragment());
            fragmentTransaction.commit();
        }
}
