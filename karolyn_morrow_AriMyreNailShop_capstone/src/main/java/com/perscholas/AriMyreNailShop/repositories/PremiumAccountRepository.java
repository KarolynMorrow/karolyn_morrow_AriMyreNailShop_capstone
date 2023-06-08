package com.perscholas.AriMyreNailShop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perscholas.AriMyreNailShop.models.PremiumAccount;

@Repository
public interface PremiumAccountRepository extends JpaRepository<PremiumAccount, Long> {

}