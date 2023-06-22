package com.perscholas.AriMyreNailShop.premium;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perscholas.AriMyreNailShop.premium.PremiumAccount;

@Repository
public interface PremiumAccountRepository extends JpaRepository<PremiumAccount, Long> {
    PremiumAccount findByUsername(String username);

}