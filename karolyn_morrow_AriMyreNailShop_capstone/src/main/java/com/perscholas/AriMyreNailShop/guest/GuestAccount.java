package com.perscholas.AriMyreNailShop.guest;

import com.perscholas.AriMyreNailShop.account.Account;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Guest")
public class GuestAccount extends Account {

    //obtain input from client constructor
    public GuestAccount(String firstName, String lastName, String email) {
        super(firstName, lastName, email);

    }

    public GuestAccount() {

    }

   
}
