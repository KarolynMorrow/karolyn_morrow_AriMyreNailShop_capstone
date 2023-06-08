package com.perscholas.AriMyreNailShop;

import com.perscholas.AriMyreNailShop.models.Account;

import java.util.HashMap;
import java.util.Map;

public class NailShop {

    public static Integer userId = 1;

    Map<Integer, Account> accounts = new HashMap<>();
    //key is userID, Value is premiumClient class
    Map<Integer, Account> appointments = new HashMap<>();
    //key is userId value is guestAccount class (connect with appointment class)

    public NailShop() {
    }

    




}
