package com.example.ianmatlak;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class AddAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addaccount);
        FragmentAddAccount();
    }

    //used to attach fragment to container
    public void FragmentAddAccount(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //ui_container is Framelayout.
        fragmentTransaction.add(R.id.uiAD_container, new AddAccountFragment());
        fragmentTransaction.commit();
    }
}
