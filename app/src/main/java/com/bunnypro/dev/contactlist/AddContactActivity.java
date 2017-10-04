package com.bunnypro.dev.contactlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddContactActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtName;
    EditText edtNumber;
    EditText edtEmail;
    EditText edtAddress;
    Button btnCancel;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        edtName = (EditText) findViewById(R.id.edt_name);
        edtNumber = (EditText) findViewById(R.id.edt_number);
        edtEmail = (EditText) findViewById(R.id.edt_email);
        edtAddress = (EditText) findViewById(R.id.edt_address);
        btnCancel = (Button) findViewById(R.id.btn_cancel);
        btnSave = (Button) findViewById(R.id.btn_save);

        btnCancel.setOnClickListener(this);
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cancel:
                setResult(RESULT_CANCELED);
                finish();
                break;
            case R.id.btn_save:
                Intent i = new Intent();
                Contact c = new Contact(
                        edtName.getText().toString(),
                        edtNumber.getText().toString(),
                        edtEmail.getText().toString(),
                        edtAddress.getText().toString()
                );
                i.putExtra("CONTACT", c);
                setResult(RESULT_OK, i);
                finish();
                break;
        }
    }
}
