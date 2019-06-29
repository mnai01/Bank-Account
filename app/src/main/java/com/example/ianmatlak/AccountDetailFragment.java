package com.example.ianmatlak;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;

public class AccountDetailFragment extends Fragment {
    private ArrayList<BankAccount> bankAccounts;// = new ArrayList<>();
    private EditText etaccnam;
    private EditText etaccbal;

    public AccountDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_accountdetail, container, false);
    }

    //used to set data in new activity account detail
    @Override
    public void onViewCreated(View view, Bundle saveInstanceState) {
        etaccnam = view.findViewById(R.id.etaddaccnam); //get control in oncreatsview
        etaccbal = view.findViewById(R.id.etaccbal);

        Intent intent = getActivity().getIntent();
        int position = intent.getIntExtra("position",0); //gets the index postion that is clicked on
        ArrayList<BankAccount> bankAccountArrayList = DataSingleton.getInstance().getM_BankAccount();
        //int position = getArguments().getInt("position"); //gets position from bundle CAUSES CRASH

        BankAccount bankAccount = bankAccountArrayList.get(position); //sets which detail will be viewed.


        etaccnam.setText(bankAccount.getM_Name());
        //etaccbal.setText(Double.toString(bankAccount.getM_Balance()));
        etaccbal.setText(String.format("%.2f",bankAccount.getM_Balance()));

    }

    //used to set data to detail fragement when in horizontal view
    void ShowData(BankAccount data){
        //nameEditText = getView().findViewById(R.id.accountNameEditText);
        //balanceEditText = getView().findViewById(R.id.balanceEditText);
        etaccnam.setText(data.getM_Name());
        //etaccbal.setText(Double.toString(data.getM_Balance()));
        etaccbal.setText(String.format("%.2f",data.getM_Balance()));

    }

}
