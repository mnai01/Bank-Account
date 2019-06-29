package com.example.ianmatlak;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public class AccountDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountdetail);
        FragmentAccountDetails();

       // Intent intent = getIntent();
      //  String position = String.valueOf(intent.getIntExtra("positon",0));

       // Toast toast=Toast.makeText(getApplicationContext(),position,Toast.LENGTH_SHORT);
        //toast.show();
    }

    public void FragmentAccountDetails(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //ui_container is Framelayout.
        fragmentTransaction.add(R.id.uiAD_container, new AccountDetailFragment());
        fragmentTransaction.commit();
    }
}
