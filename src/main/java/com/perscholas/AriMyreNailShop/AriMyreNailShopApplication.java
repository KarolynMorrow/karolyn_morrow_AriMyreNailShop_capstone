package com.perscholas.AriMyreNailShop;

import com.perscholas.AriMyreNailShop.account.Account;
import com.perscholas.AriMyreNailShop.misc.PasswordUtils;
import com.perscholas.AriMyreNailShop.premium.PremiumAccount;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class AriMyreNailShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AriMyreNailShopApplication.class, args);

//Passed but had to remove {bcrypt} from the hashedPassword for it to work...."{bcrypt}" is being saved with the db passwords
		String plainTextPassword = "password1";
		String hashedPassword = "$2a$10$sY6PB042irDUKMQRET2Nd.g6L6IgTp8k8P.6IABRg6wn1KhLa3jpm";


		System.out.println("Hashed Password: " + hashedPassword);

		boolean passwordsMatch = PasswordUtils.checkPassword(plainTextPassword, hashedPassword);

		if (passwordsMatch) {
			System.out.println("Password Matches");
		} else {
			System.out.println("Password does not match!");
		}
	}





}