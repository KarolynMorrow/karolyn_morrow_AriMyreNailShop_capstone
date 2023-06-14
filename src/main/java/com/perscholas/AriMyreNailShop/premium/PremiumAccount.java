package com.perscholas.AriMyreNailShop.premium;

import com.perscholas.AriMyreNailShop.account.Account;
import com.perscholas.AriMyreNailShop.appointment.Appointment;
import com.perscholas.AriMyreNailShop.offered_svc.OfferedService;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

@Entity
@Getter
@Setter
@Table(name = "Premium")
public class PremiumAccount extends Account {

    private String dateOfBirth;

    @NotEmpty
    private String username;

    @NotEmpty
    @Size(min = 8 , max = 15)
    private String password;

   @OneToMany
    private List<Appointment> appointments;
    private int points;


    /*CONSTRUCTORS*/
    public PremiumAccount() {
        super();
    }

    public PremiumAccount(String firstName, String lastName, String email, String username) {
        super(firstName, lastName, email);
        this.username = username;
    }

    public PremiumAccount(String firstName, String lastName, String dateOfBirth, String email, String username, String password) {
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
                ", email='" + getEmail() + '\'' +
                ", userName='" + username + '\'';
    }


}
