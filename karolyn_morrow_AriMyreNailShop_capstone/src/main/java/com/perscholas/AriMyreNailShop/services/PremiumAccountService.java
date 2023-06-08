package com.perscholas.AriMyreNailShop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perscholas.AriMyreNailShop.models.PremiumAccount;

import java.util.List;
import java.util.Optional;

public interface PremiumAccountService {
    public List<PremiumAccount> getAllPremiumAccounts();

    void savePremiumAccount(PremiumAccount premiumAccount);

    PremiumAccount getPremiumAccountById(long id);

    void deletePremiumAccount(long id);
}