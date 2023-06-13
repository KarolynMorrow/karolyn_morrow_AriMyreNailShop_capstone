package com.perscholas.AriMyreNailShop.premium;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class PremiumAccountServiceImpl implements PremiumAccountService {

    private PremiumAccountRepository premiumRepository;
    private PremiumAccount premiumAccount;

    @Autowired
    public PremiumAccountServiceImpl(PremiumAccountRepository premiumRepository){
        this.premiumRepository = premiumRepository;
    }

    @Override
    public List<PremiumAccount> getAllPremiumAccounts() {
        return premiumRepository.findAll();
    }



    @Override
    public void savePremiumAccount(PremiumAccount premiumAccount) {
        premiumRepository.save(premiumAccount);
        System.out.println("Looking at these peeps");
        System.out.println(premiumRepository.findAll());
    }


    @Override
    public PremiumAccount getPremiumAccountById(long id) {
        Optional<PremiumAccount> optionalPremiumAccount = premiumRepository.findById(id);
        if (optionalPremiumAccount.isPresent()) {
            PremiumAccount premiumAccount = optionalPremiumAccount.get();
            return premiumAccount;
        }
        //throw new AccountNotFoundException();
        return null;
    }

    @Override
    public void deletePremiumAccount(long id) {
        premiumRepository.deleteById(id);
    }




}