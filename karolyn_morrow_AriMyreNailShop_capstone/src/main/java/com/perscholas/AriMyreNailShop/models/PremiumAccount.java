package com.perscholas.AriMyreNailShop.models;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;
import java.util.TreeMap;

@Entity
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


    @Override
    public String greetClient() {
        return ("Welcome Back: " + getFirstName());
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
    /*GETTERS AND SETTERS*/

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public TreeMap<Date, Service> getPreviousService() {
        return previousService;
    }

    public void setPreviousService(TreeMap<Date, Service> previousService) {
        this.previousService = previousService;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;


    }

}
