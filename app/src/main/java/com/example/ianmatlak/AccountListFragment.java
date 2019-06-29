package com.example.ianmatlak;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import java.util.ArrayList;

public class AccountListFragment extends Fragment{

    private ArrayList<BankAccount> bankAccounts = new ArrayList<>();
    private RecyclerView recyclerView;
    private BankAccountAdapter mAdapter;
    private Button btnaddacc;
    private SendDataCallback callBack;

    interface SendDataCallback {
        void sendData(BankAccount data);
    }

    public AccountListFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callBack = (SendDataCallback) context;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_accountlist, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle saveInstanceState) {
        btnaddacc = view.findViewById(R.id.btnaddacc);
        btnaddacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),AddAccountActivity.class));
            }
        });

        bankAccounts = DataSingleton.getInstance().getM_BankAccount();
        mAdapter = new BankAccountAdapter(bankAccounts); //bankAccounts was in the parenthesis before
        mAdapter.setOnItemClickListener(new BankAccountAdapter.BankAccountAdapterListener() {
            @Override
            public void onItemClick(int position) {

                //Toast toast=Toast.makeText(getContext(),position,Toast.LENGTH_SHORT);
                //toast.show();
                int rotation = ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getRotation();//gets the rotational value
                //Intent intent=new Intent(getActivity().getApplicationContext(),AccountDetailActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               // AccountDetailFragment acdf = new AccountDetailFragment();
                //Bundle args = new Bundle();
                //args.putInt("position",position);
                //acdf.setArguments(args);
                //getFragmentManager().beginTransaction().add(R.id.uiAD_container, acdf).commit();


                if ((rotation == Surface.ROTATION_90) || (rotation == Surface.ROTATION_270)) {//THIS IS FOR HORIZONTAL VIEW ELSE WILL HAVE DIFFERENT INTENT
                    BankAccount data;
                    data = DataSingleton.getInstance().getM_BankAccount().get(position);
                    callBack.sendData(data);
                }else{
                   Intent intent1 = new Intent(getActivity(), AccountDetailActivity.class);
                   intent1.putExtra("position", position);
                   startActivity(intent1);


                   //BankAccount selectedName = bankAccounts.get(position);//DataSingleton.getInstance().toString().indexOf(position));
               }
            }
        });

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        }
        
//DOES NOT GO HERE
    public void onResume() {
        mAdapter.setData(DataSingleton.getInstance().getM_BankAccount());
        super.onResume();


    }
}

