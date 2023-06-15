package com.perscholas.AriMyreNailShop.account;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Client_Id")
    private long id;
    @NotEmpty(message = "User's name cannot be empty")
    @Size(min = 5, max = 40)
    @Column(name = "First")
    private String firstName;
    @NotEmpty(message = "User's name cannot be empty")
    @Size(min = 2, max = 40)
    @Column(name = "Last")
    private String lastName;

    @NotEmpty(message = "Email cannot be empty")
    private String email;



    /*CONSTRUCTOR*/
    public Account() {

    }

    public Account(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    /*Getters and Setters*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    /*METHODS*/
    public boolean isPremium(){
        return false;
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
