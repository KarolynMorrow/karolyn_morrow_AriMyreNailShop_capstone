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

    /*METHODS*/

    /*If premiumAccount add to accounts, if guestAccount add straight to appointments */

    public void addClient(Account account) {
        if (account.isPremium()) {
            accounts.put(userId, account);
            userId++;
        } else {
            appointments.put(userId, account);
            userId++;
        }
    }

    /*WORK ON*/
//    public void updateClient(Client client) {
//        if (!client.isPremium()) {
//
//        }
//
//    }

    /*WORK ON*/
    public Account getClient(Account account) {
        if (userId != null) {
            System.out.println("Client: " + account.getFirstName() + " " + accounts.get(userId));
        }

        return null;
    }

    public void getAllClients() {
        for (Map.Entry<Integer, Account> account : accounts.entrySet()) {
            System.out.println("Client id: " + account.getKey() + " Client info: " + account.getValue());

        }
    }

    public void deleteClient(Account account) {
        if (userId != null) {
            for (int id : accounts.keySet()) {
                accounts.remove(userId);
            }
        }
        System.out.println(account + " has been removed.");

    }

    public void addAppointment(Account account) {
        appointments.put(userId, account);
    }


    public void updateAppointment(Account account) {
        if (userId != null) {
            appointments.replace(userId, account);

        }

    }

    public void getAppointment() {
        if (userId != null) {
            appointments.get(userId);
        }

    }

    public void getAllAppointments() {
        for (int id : appointments.keySet()) {
            System.out.println("Client id: " + id + " Appointments: " + appointments.get(id));
        }

    }

    public void deleteAppointment(Integer userId) {
        if (userId != null) {
            for (int id : appointments.keySet()) {
                appointments.remove(id);
            }
        }

    }


}
