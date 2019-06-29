package com.example.ianmatlak;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class BankAccountAdapter extends RecyclerView.Adapter<BankAccountAdapter.ViewHolder> {

    private ArrayList<BankAccount> BankAccount;
    private BankAccountAdapterListener listener;

    interface BankAccountAdapterListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(BankAccountAdapterListener listener) {
        this.listener = listener;
    }

    public BankAccountAdapter(ArrayList<BankAccount> bankAccount) {
        this.BankAccount = bankAccount;
    }

    public class ViewHolder extends RecyclerView.ViewHolder { //hold the widgets in memory of each individual entry
        TextView tvAccounttype;
        ConstraintLayout clParent;

        public ViewHolder(View itemView) {
            super(itemView);
            tvAccounttype = itemView.findViewById(R.id.tvAccounttype);
            //clParent = itemView.findViewById(R.id.parent_layout);
            itemView.setOnClickListener(new View.OnClickListener() {
                //This gets the position of the item that is clicked on from the recycler view
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
    //it recycles the view holder by putting them in the position that they should be in
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem,viewGroup,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        BankAccount bankAccount = BankAccount.get(i);
        viewHolder.tvAccounttype.setText(bankAccount.getM_Name());


       /* viewHolder.clParent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //TODO Maybe conditional statement for when screen is turned start this intent to switch ativity or dont start?
               // Intent i = new Intent(view.getContext(),AccountDetailActivity.class);
                view.getContext().startActivity(i);
            }
        });*/
    }
    @Override
    public int getItemCount() {
        return BankAccount.size();
    }

    //used to send data to detail fragement when in horizontal view
    public void setData(ArrayList<BankAccount> bankAccount){
        this.BankAccount = BankAccount;
        notifyDataSetChanged();
    }

}


