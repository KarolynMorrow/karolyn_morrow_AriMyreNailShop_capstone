package com.perscholas.AriMyreNailShop.premium;

import com.perscholas.AriMyreNailShop.security.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PremiumAccountServiceImpl implements PremiumAccountService {

    private PremiumAccountRepository premiumRepository;
    private PasswordEncoder passwordEncoder;

    public PremiumAccountServiceImpl() {
        passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Autowired
    public PremiumAccountServiceImpl(PremiumAccountRepository premiumRepository) {
        this();
        this.premiumRepository = premiumRepository;
    }

    @Override
    public List<PremiumAccount> getAllPremiumAccounts() {
        return premiumRepository.findAll();
    }


    @Override
    public void savePremiumAccount(PremiumAccount premiumAccount) {
        premiumAccount.setPassword(passwordEncoder.encode(premiumAccount.getPassword()));
        //if password starts with "{bcrypt}" remove before saving to db
//        if(premiumAccount.getPassword().startsWith("{bcrypt}")){
//            String passwordWithoutPrefix = premiumAccount.getPassword().substring("{bcrypt}".length());
//            premiumAccount.setPassword(passwordWithoutPrefix);
//        } else{
//            premiumAccount.getPassword();
//            }
        premiumRepository.save(premiumAccount);
    }


    @Override
    public PremiumAccount getPremiumAccountById(long id) throws AccountNotFoundException {
        Optional<PremiumAccount> optionalPremiumAccount = premiumRepository.findById(id);
        if (optionalPremiumAccount.isPresent()) {
            PremiumAccount premiumAccount = optionalPremiumAccount.get();
            return premiumAccount;
        }
        return null;
    }

    @Override
    public PremiumAccount getPremiumAccountByUsername(String username) throws AccountNotFoundException {
        PremiumAccount byUsername = premiumRepository.findByUsername(username);
        if(byUsername != null){
            return byUsername;
        }
        throw new UserNotFoundException("");
    }

    @Override
    public PremiumAccount getAccount(String username) {
        return premiumRepository.findByUsername(username);
    }

    @Override
    public void deletePremiumAccount(long id) {
        premiumRepository.deleteById(id);
    }

    @Override
    public Boolean validateAccount(String username, String password) {
        PremiumAccount existingAccount = premiumRepository.findByUsername(username);

        if (existingAccount == null) {
            throw new UserNotFoundException(
                    "User does not exist with Username: " + username);
        }

        boolean isValid =
                (username.equals(existingAccount.getUsername()) &&
                        password.equals(existingAccount.getPassword()));

        return isValid;
    }

    @Override
    public PremiumAccount updateAccount(PremiumAccount premiumAccount) {
        PremiumAccount existingAccount = premiumRepository.findByUsername(premiumAccount.getUsername());

        if (existingAccount == null) {
            throw new UserNotFoundException("Account does not exist with username: " +
                    premiumAccount.getUsername());
        }

        existingAccount.setPassword(passwordEncoder.encode(premiumAccount.getPassword()));
        return premiumRepository.save(premiumAccount);
    }


}