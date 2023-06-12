package com.perscholas.AriMyreNailShop.premium;

import com.perscholas.AriMyreNailShop.account.Account;
import com.perscholas.AriMyreNailShop.offered_svc.OfferedService;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;
import java.util.TreeMap;

@Entity
@Getter
@Setter
@Table(name = "Premium")
public class PremiumAccount extends Account {

    private LocalDate dateOfBirth;
    @NotNull
    private String email;
    @NotNull
    private String username;
    @NotNull
    private String password;

    private TreeMap<Date, OfferedService> previousService;
    private int points;


    /*CONSTRUCTORS*/
    public PremiumAccount() {

    }

    public PremiumAccount(String firstName, String lastName, String email, String username) {
        super(firstName, lastName, email);
        this.username = username;
    }

    public PremiumAccount(String firstName, String lastName, LocalDate dateOfBirth, String email, String username, String password) {
        super(firstName, lastName, email);
        this.dateOfBirth = dateOfBirth;
        this.username = username;
        this.password = password;
    }



    /*METHODS*/
    public boolean isPremium() {
        return true;
    }

    @Override
    public String toString() {
        return "PremiumAccount: " +
                getFirstName() + " " + getLastName() +
                ", email='" + email + '\'' +
                ", userName='" + username + '\'';
    }


}
