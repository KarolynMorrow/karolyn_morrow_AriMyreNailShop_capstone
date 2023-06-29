package com.perscholas.AriMyreNailShop.premium;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PremiumDetailsServiceImpl implements UserDetailsService {
    private PremiumAccountRepository premiumRepository;
    @Autowired
    public PremiumDetailsServiceImpl(PremiumAccountRepository premiumRepository) {
        this.premiumRepository = premiumRepository;
    }


    //This code takes in the username passed by the client finds the account (if there is one) and returns the object based on the information in the user object
    @Override
    public UserDetails loadUserByUsername(String username) throws
            UsernameNotFoundException {
        PremiumAccount p = premiumRepository.findByUsername(username);

        if (p == null){
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(
                p.getUsername(),
                p.getPassword(),
                true,
                true,
                true,
                true,
                AuthorityUtils.createAuthorityList("ROLE_PREMIUM") //how to create a custom role
        );
    }
}
