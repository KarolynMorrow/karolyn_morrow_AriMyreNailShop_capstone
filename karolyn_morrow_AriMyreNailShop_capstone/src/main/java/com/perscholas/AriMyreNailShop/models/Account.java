package com.perscholas.AriMyreNailShop.models;

import com.perscholas.AriMyreNailShop.INailShop;
import com.perscholas.AriMyreNailShop.NailShop;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@MappedSuperclass
public abstract class Account extends NailShop implements INailShop, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Client_Id")
    private int accountId;
    @Column(name = "First")
    private String firstName;
    @Column(name = "Last")
    private String lastName;
    @NotNull
    private String email;


    /*CONSTRUCTOR*/
    public Account() {

    }

    public Account(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    /*METHODS*/

    public abstract String greetClient();

    @Override
    public boolean isPremium() {
        return false;
    }

    /*Getters and Setters*/

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
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
