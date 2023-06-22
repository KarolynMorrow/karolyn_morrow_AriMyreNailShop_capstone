package com.perscholas.AriMyreNailShop.premium;

import com.perscholas.AriMyreNailShop.account.Account;
import com.perscholas.AriMyreNailShop.appointment.Appointment;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Premium")
public class PremiumAccount extends Account implements UserDetails {

    private String dateOfBirth;

    @NotEmpty
    private String username;

    @NotEmpty
    @Size(min = 8, max = 15)
    private String password;

    @OneToOne
    private Appointment appointments;
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

    // For the simplicity of the app, we give ADMIN role to all
    // newly signed-up users.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"));

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
