package com.codedecode.yashpwr;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactsActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private List<Contact> contacts = new ArrayList<>();
    private ContactsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        // binding the view
        ButterKnife.bind(this);

        mAdapter = new ContactsAdapter(contacts);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareContacts();
    }

    private void prepareContacts() {
        String[] names = new String[]{"Keith Castro", "Emily Black", "Robert Hill",
                "Jack Ellis", "Christian Fowler", "Deborah Palmer", "Denise Fernandez",
                "Ashley Fisher", "Christopher Mills", "Jesse Vargas", "Albert Patel"};

        String[] mobiles = new String[]{"(164) 341 3502", "(340) 207 5511", "(114) 110 1910",
                "(323) 941 2554", "(976) 613 1516", "(218) 243 1078", "(168) 521 1663",
                "(424) 162 6385", "(538) 779 4107", "(639) 698 6701", "(782) 651 2715"};

        for (int i = 0; i < names.length; i++) {
            Contact contact = new Contact(names[i], mobiles[i]);
            contacts.add(contact);
        }

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
