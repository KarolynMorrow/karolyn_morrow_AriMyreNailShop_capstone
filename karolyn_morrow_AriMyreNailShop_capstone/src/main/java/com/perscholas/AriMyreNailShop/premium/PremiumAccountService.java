package com.perscholas.AriMyreNailShop.premium;

import java.util.List;

public interface PremiumAccountService {
    public List<PremiumAccount> getAllPremiumAccounts();

    void savePremiumAccount(PremiumAccount premiumAccount);

    PremiumAccount getPremiumAccountById(long id);

    void deletePremiumAccount(long id);
}