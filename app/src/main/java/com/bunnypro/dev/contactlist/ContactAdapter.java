package com.bunnypro.dev.contactlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by iqbalung on 3/27/16.
 */
public class ContactAdapter extends ArrayAdapter<Contact> {
    private Context mContext;
    private ArrayList<Contact> mContacts;
    private int mResource;

    public ContactAdapter(Context context, int resource, ArrayList<Contact> contacts) {
        super(context, resource, contacts);

        mContext = context;
        mResource = resource;
        mContacts = contacts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(mResource, parent, false);
        }

        holder.txtName = (TextView) convertView.findViewById(R.id.txt_contact_name);
        holder.txtNumber = (TextView) convertView.findViewById(R.id.txt_contact_number);

        holder.txtName.setText(mContacts.get(position).getName());
        holder.txtNumber.setText(mContacts.get(position).getNumber());

        convertView.setTag(holder);

        return convertView;
    }

    protected class ViewHolder {
        TextView txtName;
        TextView txtNumber;
    }
}
