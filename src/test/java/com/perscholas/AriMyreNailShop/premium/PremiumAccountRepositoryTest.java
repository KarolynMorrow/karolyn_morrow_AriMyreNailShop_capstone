package com.perscholas.AriMyreNailShop.premium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class PremiumAccountRepositoryTest {

   private final PremiumAccountRepository premiumAccountRepository;
   private final PremiumAccountService premiumAccountService;

    @Autowired
    public PremiumAccountRepositoryTest(PremiumAccountRepository premiumAccountRepository, PremiumAccountService premiumAccountService) {
        this.premiumAccountRepository = premiumAccountRepository;
        this.premiumAccountService = premiumAccountService;
    }

    @Test
    void findByUsernameShouldReturnCorrectPremiumAccount(){
        PremiumAccount expected = new PremiumAccount();
        expected.setUsername("username123");
        expected.setPassword("password1");
        expected.setEmail("k@email.com");
        expected.setFirstName("User");
        expected.setLastName("Name");

        premiumAccountService.savePremiumAccount(expected);

        PremiumAccount result = premiumAccountRepository.findByUsername(expected.getUsername());
        Assertions.assertEquals("username123", result.getUsername());

    }

    @Test
    void findByUsernameShouldReturnNullForNonExistentUsername() {
        // Call the findByUsername method for a non-existent username
        PremiumAccount foundAccount = premiumAccountRepository.findByUsername("nonexistent");

        // Assert that the returned account is null
        assertNull(foundAccount);
    }
}