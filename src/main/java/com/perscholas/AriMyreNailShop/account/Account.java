package com.perscholas.AriMyreNailShop.account;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

@MappedSuperclass //means that this is a class used to map the entity classes
@Getter
@Setter
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Client_Id")
    private long id;
//    @NotEmpty(message = "User's name cannot be empty")
//    @Size(min = 5, max = 40)
    @Column(name = "First")
    private String firstName;
//    @NotEmpty(message = "User's name cannot be empty")
//    @Size(min = 2, max = 40)
    @Column(name = "Last")
    private String lastName;

//    @NotEmpty(message = "Email cannot be empty")
    private String email;

    private boolean isPremium;



    /*CONSTRUCTOR*/
    public Account() {

    }

    public Account(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    /*Getters and Setters*/


    public boolean isPremium() {
        return false;
    }

    /*METHODS*/

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id && isPremium == account.isPremium && Objects.equals(firstName, account.firstName) && Objects.equals(lastName, account.lastName) && Objects.equals(email, account.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, isPremium);
    }
}
