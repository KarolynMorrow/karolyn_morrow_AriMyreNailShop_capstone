package com.perscholas.AriMyreNailShop.premium;

import com.perscholas.AriMyreNailShop.account.Account;
import com.perscholas.AriMyreNailShop.appointment.Appointment;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "user")
public class PremiumAccount extends Account implements UserDetails {

    private String dateOfBirth;

    @NotEmpty
    private String username;

    //    @NotEmpty
//    @Size(min = 8)
    private String password;


    //One account can have many appointments
    @OneToMany
    @JoinColumn(name = "premium_account_id")
    private List<Appointment> appointments;

    private int points;


    /*CONSTRUCTORS*/
    public PremiumAccount() {
        super();
    }

    public PremiumAccount(String firstName, String lastName, String email, String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public PremiumAccount(String firstName, String lastName, String dateOfBirth, String email, String username, String password) {
        super();
        this.dateOfBirth = dateOfBirth;
        this.username = username;
        this.password = password;
    }

    /*METHODS*/

    //Change isPremium to true
    @Override
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

    //Implemented methods from UserDetails

    // For the simplicity of the app, we give PREMIUM role to all
    // newly signed-up users.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_PREMIUM"));

    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
