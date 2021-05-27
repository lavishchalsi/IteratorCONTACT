package com.example.iteratorconcepts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ListIterator;

public class AddActivity extends AppCompatActivity {
    Button addContact;
    EditText con_name,con_number;
    ListIterator< Contacts > listIterator = MainActivity.contactsList.listIterator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


                addContact = findViewById(R.id.add);
                con_name = findViewById(R.id.addname);
                con_number = findViewById(R.id.add_number);
                addContact.setOnClickListener(new View.OnClickListener() {
                    @Override public void onClick(View v) {
                        addNewContact(con_name.getText().toString(),con_number.getText().toString());
                        finish();
                    }
                });
            }
            void addNewContact(String contactname, String contactnumber)
            {
               // Contacts contacts = new Contacts(contactname,contactnumber);
                Contacts contacts = new Contacts(contactname,contactnumber);
                while ( listIterator.hasNext())
                {
                    listIterator.next();
                }
                listIterator.add(contacts);  //  MainActivity.contactsList.add(contacts);
    }
}