package com.codedecode.yashpwr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.MyViewHolder> {

    private List<Contact> contacts;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name)
        TextView name;

        @BindView(R.id.mobile)
        TextView mobile;

        public MyViewHolder(View view) {
            super(view);

            // binding view
            ButterKnife.bind(this, view);

            // these lines are not necessary when using
            // butter knife
            // name = (TextView) view.findViewById(R.id.name);
            // mobile = (TextView) view.findViewById(R.id.mobile);
        }
    }


    public ContactsAdapter(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Contact contact = contacts.get(position);
        holder.name.setText(contact.getName());
        holder.mobile.setText(contact.getMobile());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
