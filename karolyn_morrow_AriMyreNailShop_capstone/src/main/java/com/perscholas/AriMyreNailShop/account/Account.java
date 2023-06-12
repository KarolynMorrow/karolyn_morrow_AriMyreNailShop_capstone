package com.perscholas.AriMyreNailShop.account;

import com.sun.istack.NotNull;

import javax.persistence.*;

@MappedSuperclass
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Client_Id")
    private long id;
    @NotNull
    @Column(name = "First")
    private String firstName;
    @NotNull
    @Column(name = "Last")
    private String lastName;

    @NotNull
    private String email;
    private boolean isPremium = false;


    /*CONSTRUCTOR*/
    public Account() {

    }

    public Account(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    /*METHODS*/


    /*Getters and Setters*/

    public boolean getIsPremium(){
        return isPremium;
    }

    public void setIsPremium(){
        this.isPremium = isPremium;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
