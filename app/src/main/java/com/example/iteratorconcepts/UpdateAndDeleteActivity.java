package com.example.iteratorconcepts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.List;
import java.util.ListIterator;

public class UpdateAndDeleteActivity extends AppCompatActivity {
    EditText changeName,changeNumber;
    Button update,delete;
    String _cname,_cnumber;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_and_delete);



                changeName = findViewById(R.id.editname);
                changeNumber = findViewById(R.id.edit_number);
                update = (Button)findViewById(R.id.btn_edit);
                delete = (Button)findViewById(R.id.button_cancel);
                Intent intent = getIntent();
                _cname = intent.getStringExtra("contactname");
                _cnumber = intent.getStringExtra("contactnumber");
                position = intent.getIntExtra("position",0);
                changeName.setText(_cname);
                changeNumber.setText(_cnumber);
        ListIterator< Contacts > listIterator = MainActivity.contactsList.listIterator(position);
                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        _cname = changeName.getText().toString();
                        _cnumber = changeNumber.getText().toString();
                        updateContact(_cname,_cnumber,position,listIterator);
                        finish();
                    }
                });
                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listIterator.next();
                        listIterator.remove();
                        //MainActivity.contactsList.remove(position);
                        finish();
                    }
                });
            }
            void updateContact(String contactname, String contactnumber, int position, ListIterator<Contacts> listIterator)
        {
             Contacts contacts = new Contacts(contactname,contactnumber);


            listIterator.next();
            listIterator.set(contacts);
    }

                //Contacts contacts = new Contacts(contactname,contactnumber);
               // MainActivity.contactsList.set(position,contact
}
