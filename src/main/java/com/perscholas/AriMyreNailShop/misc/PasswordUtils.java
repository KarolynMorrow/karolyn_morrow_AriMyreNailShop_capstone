package com.perscholas.AriMyreNailShop.misc;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordUtils {

    public static String hashPassword(String plainTextPassword) {
        String salt = BCrypt.gensalt();
        return BCrypt.hashpw(plainTextPassword, salt);
    }

    public static boolean checkPassword(String enteredPassword, String hashPassword){
        return BCrypt.checkpw(enteredPassword, hashPassword);
    }



}
