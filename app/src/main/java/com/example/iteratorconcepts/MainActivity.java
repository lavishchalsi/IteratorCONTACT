package com.example.iteratorconcepts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    static List<Contacts> contactsList = new ArrayList<>();
        RecyclerView recyclerView;
        RecyclerView.LayoutManager layoutManager;
        ContactAdapter contactAdapter;
        FloatingActionButton fab;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            recyclerView =  findViewById(R.id.recyclerView_id);
            fab =  findViewById(R.id.floatingActionButton_add);
            prepareContacts();
            layoutManager = new LinearLayoutManager(this);
            contactAdapter = new ContactAdapter(contactsList,getApplicationContext());
            recyclerView.setAdapter(contactAdapter);
            recyclerView.setLayoutManager(layoutManager);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),AddActivity.class);
                    startActivity(intent);
                }
            });

        }
        void prepareContacts()
        {
            Contacts contacts = new Contacts("name1","phonenumber1");
            contactsList.add(contacts);
            contacts = new Contacts("name2","phonenumber2");
            contactsList.add(contacts);
            contacts = new Contacts("name3","phonenumber3");
            contactsList.add(contacts);
            contacts = new Contacts("name4","phonenmber4");
            contactsList.add(contacts);
            contacts = new Contacts("name5","phonenumber5");
            contactsList.add(contacts);
            contacts = new Contacts("name6","phone number6");
            contactsList.add(contacts);
            contacts = new Contacts("name7","phonenuber7");
            contactsList.add(contacts);
        }
        @Override
        protected void onResume() {
            super.onResume();
            contactAdapter.updateList(MainActivity.contactsList);
        }
    }