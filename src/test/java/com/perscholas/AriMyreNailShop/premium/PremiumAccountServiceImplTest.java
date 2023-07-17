package com.perscholas.AriMyreNailShop.premium;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class PremiumAccountServiceImplTest {

    PremiumAccountService premiumAccountService;
    PremiumAccountRepository premiumAccountRepository;

    @Autowired
    public PremiumAccountServiceImplTest(PremiumAccountService premiumAccountService, PremiumAccountRepository premiumAccountRepository) {
        this.premiumAccountService = premiumAccountService;
        this.premiumAccountRepository = premiumAccountRepository;
    }

//    @Test
//    void deleteAccountByIdMethodShouldDeletePremiumAccount() throws UserNotFoundException {
//        PremiumAccount account = new PremiumAccount();
//        account.setFirstName("Coraline");
//        account.setLastName("Jones");
//        account.setUsername("BoringBlueBoy");
//        account.setEmail("otherMother@email.com");
//        account.setPassword("buttons4Eyes");
//
//        premiumAccountService.savePremiumAccount(account);
//        Long accountId = account.getId();
//
//        premiumAccountService.deletePremiumAccount(accountId);
//        assertThrows(UserNotFoundException.class, () -> premiumAccountRepository.findById(accountId));
//    }

}