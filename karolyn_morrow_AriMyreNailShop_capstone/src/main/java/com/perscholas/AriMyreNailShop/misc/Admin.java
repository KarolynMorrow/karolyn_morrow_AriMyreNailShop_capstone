package com.perscholas.AriMyreNailShop.misc;

import com.perscholas.AriMyreNailShop.models.PremiumAccount;

public class Admin extends PremiumAccount {
    final boolean isAdmin = true;

    public Admin(String firstName, String lastName, String email, String userName) {
        super();
    }

    //admin login with access to MySQL database. cashapp, Calendly API
}
