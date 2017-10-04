package com.bunnypro.dev.contactlist;

import java.io.Serializable;

/**
 * Created by iqbalung on 3/27/16.
 */
public class Contact implements Serializable {
    private String name;
    private String number;
    private String email;
    private String address;

    public Contact(String name, String number, String email, String address) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
