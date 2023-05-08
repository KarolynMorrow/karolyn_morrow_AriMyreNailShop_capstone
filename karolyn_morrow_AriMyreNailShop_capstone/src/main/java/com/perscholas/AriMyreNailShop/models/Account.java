package com.perscholas.AriMyreNailShop.models;

import com.perscholas.AriMyreNailShop.NailShop;

public abstract class Account extends NailShop implements INailShop {

    private String firstName;
    private String lastName;
    private String email;


    /*CONSTRUCTOR*/
    public Account(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    public Account() {

    }


    /*METHODS*/

    public abstract String greetClient();

    @Override
    public boolean isPremium() {
        return false;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
