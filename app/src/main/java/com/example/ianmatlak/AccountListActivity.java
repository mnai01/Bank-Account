package com.example.ianmatlak;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Surface;

import java.util.ArrayList;

public class AccountListActivity extends AppCompatActivity implements AccountListFragment.SendDataCallback {

    public AccountDetailFragment AccountDetailFragmentx = new AccountDetailFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountlist);
        FragmentAccountList();
        FragmentAccountDetail();
    }

    public void FragmentAccountList() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //ui_container is Framelayout.
        fragmentTransaction.add(R.id.uiAL_container, new AccountListFragment());
        fragmentTransaction.commit();
    }


    public void FragmentAccountDetail() {
        int rotation = getWindowManager().getDefaultDisplay().getRotation();//gets the rotational value
        if ((rotation == Surface.ROTATION_90) || (rotation == Surface.ROTATION_270)) { //conditional statement for adding fragment only when the screen is tilted
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            //ui_container is Framelayout.
            fragmentTransaction.add(R.id.uiAD_container, AccountDetailFragmentx);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void sendData(BankAccount data) {
        AccountDetailFragmentx.ShowData(data);
    }
}
