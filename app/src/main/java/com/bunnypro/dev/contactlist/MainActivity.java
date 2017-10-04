package com.bunnypro.dev.contactlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    ListView lstContact;
    Button btnAdd;
    ArrayList<Contact> contacts;
    ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contacts = new ArrayList<>();
        contactAdapter = new ContactAdapter(this, R.layout.layout_contact_list, contacts);

        lstContact = (ListView) findViewById(R.id.lst_contact);
        btnAdd = (Button) findViewById(R.id.btn_add);

        lstContact.setAdapter(contactAdapter);
        lstContact.setOnItemClickListener(this);
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(this, DetailContactActivity.class);
        i.putExtra("CONTACT", contacts.get(position));
        startActivity(i);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                Intent i = new Intent(this, AddContactActivity.class);
                startActivityForResult(i, 555);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 555 && resultCode == RESULT_OK) {
            Contact c = (Contact) data.getSerializableExtra("CONTACT");
            contacts.add(c);
            contactAdapter.notifyDataSetChanged();
        }
    }
}
