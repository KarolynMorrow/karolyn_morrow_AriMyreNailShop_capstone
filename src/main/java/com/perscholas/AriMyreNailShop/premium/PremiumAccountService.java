package com.perscholas.AriMyreNailShop.premium;

import java.util.List;

public interface PremiumAccountService {
    //Get all
    public List<PremiumAccount> getAllPremiumAccounts();

    //Post
    void savePremiumAccount(PremiumAccount premiumAccount);

    //Get one
    PremiumAccount getPremiumAccountById(long id);

    PremiumAccount getAccount(String username);

    //delete
    void deletePremiumAccount(long id);

    //Post
    public Boolean validateAccount(String username, String password);

    //Put
    public PremiumAccount updateAccount(PremiumAccount premiumAccount);
}