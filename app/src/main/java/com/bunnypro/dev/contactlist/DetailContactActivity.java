package com.bunnypro.dev.contactlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailContactActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtName;
    TextView txtNumber;
    TextView txtEmail;
    TextView txtAddress;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_contact);

        txtName = (TextView) findViewById(R.id.txt_name);
        txtNumber = (TextView) findViewById(R.id.txt_number);
        txtEmail = (TextView) findViewById(R.id.txt_email);
        txtAddress = (TextView) findViewById(R.id.txt_address);
        btnBack = (Button) findViewById(R.id.btn_back);

        Contact c = (Contact) getIntent().getSerializableExtra("CONTACT");

        txtName.setText(c.getName());
        txtNumber.setText(c.getNumber());
        txtEmail.setText(c.getEmail());
        txtAddress.setText(c.getAddress());

        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                finish();
                break;
        }
    }
}
