package com.example.ianmatlak;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class AddAccountFragment extends Fragment {
    private EditText etaddaccnam;
    private EditText etaddaccbal;

    public AddAccountFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_addaccount, container, false);
            etaddaccnam = view.findViewById(R.id.etaddaccnam);
            etaddaccbal = view.findViewById(R.id.etaddaccbal);

            Button btnsave = (Button) view.findViewById(R.id.btnsave);
        //adds data to singleton that is inputed by user
        btnsave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String newName;
                    double newBalance;

                    newName = etaddaccnam.getText().toString();
                    newBalance = Double.parseDouble(etaddaccbal.getText().toString());

                    BankAccount newBankAccount = new BankAccount(newName, newBalance);
                    DataSingleton.getInstance().getBankAccountList().add(newBankAccount);
                    getActivity().finish();

                }
            });
        return view;
    }
}