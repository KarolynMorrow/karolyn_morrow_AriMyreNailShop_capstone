package com.perscholas.AriMyreNailShop.models;

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
    private String userName;
    @NotNull
    private String passWord;

    private TreeMap<Date, Service> previousService;
    private int points;


    /*CONSTRUCTORS*/
    public PremiumAccount() {

    }

    public PremiumAccount(String firstName, String lastName, String email, String userName) {
        super(firstName, lastName, email);
        this.userName = userName;
    }

    public PremiumAccount(String firstName, String lastName, LocalDate dateOfBirth, String email, String userName, String passWord) {
        super(firstName, lastName, email);
        this.dateOfBirth = dateOfBirth;
        this.userName = userName;
        this.passWord = passWord;
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
                ", userName='" + userName + '\'';
    }


}
