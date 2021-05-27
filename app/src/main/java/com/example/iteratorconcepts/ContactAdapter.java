package com.example.iteratorconcepts;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder>{
    private List<Contacts> contactsList;

    public ContactAdapter(List<Contacts> contactsList, Context context) {
        this.contactsList = contactsList;
        this.context = context;
    }

    private Context context;
    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_contact_layout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder holder, int position) {
        Contacts contacts = contactsList.get(position);
        holder.contactname.setText(contacts.getName());
        holder.contactnumber.setText(contacts.getNumber());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (holder.itemView.getContext(),UpdateAndDeleteActivity.class);
                intent.putExtra("contactname",contacts.getName());
                intent.putExtra("contactnumber",contacts.getNumber());
                intent.putExtra("position",position);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView contactname,contactnumber;
        public ViewHolder(@NonNull View view) {
            super(view);
            contactname = (TextView) view.findViewById(R.id.contact_name);
            contactnumber = (TextView) view.findViewById(R.id.contact_number);
        }
    }

    void updateList(List<Contacts> contactsList)
    {
        this.contactsList = contactsList;
        notifyDataSetChanged();
    }
}
