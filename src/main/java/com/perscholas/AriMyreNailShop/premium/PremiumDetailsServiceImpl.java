package com.perscholas.AriMyreNailShop.premium;

import org.springframework.beans.factory.annotation.Autowired;
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


    @Override
    public UserDetails loadUserByUsername(String username) throws
            UsernameNotFoundException {
        PremiumAccount p = premiumRepository.findByUsername(username);
        if (p == null){
            throw new UsernameNotFoundException("User not found");
        }
        return p;
    }
}
