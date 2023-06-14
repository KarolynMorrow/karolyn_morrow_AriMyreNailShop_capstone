package com.perscholas.AriMyreNailShop;

import com.perscholas.AriMyreNailShop.account.Account;
import com.perscholas.AriMyreNailShop.premium.PremiumAccount;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class AriMyreNailShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AriMyreNailShopApplication.class, args);
		PremiumAccount karolyn = new PremiumAccount("karolyn", "morrow", "1994-06-23" ,"km@email.com", "Kmorrow", "password123");
		System.out.println(karolyn);
		System.out.println(karolyn.getPassword());
	}





}