package com.perscholas.AriMyreNailShop.models;

public class GuestAccount extends Account {

    //obtain input from client constructor
    public GuestAccount(String firstName, String lastName, String email) {
        super(firstName, lastName, email);

    }

    public GuestAccount() {

    }

    @Override
    public String greetClient() {
        return ("Welcome: " + getFirstName());
    }

    @Override
    public String toString() {
        return "Guest Account: " + getFirstName() + " " + getLastName() + " " + getEmail();
    }
}
