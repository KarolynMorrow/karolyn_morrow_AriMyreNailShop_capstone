package com.perscholas.AriMyreNailShop.security;

import com.perscholas.AriMyreNailShop.premium.PremiumAccount;
import com.perscholas.AriMyreNailShop.premium.PremiumAccountRepository;
import com.perscholas.AriMyreNailShop.premium.PremiumAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.security.auth.login.AccountNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.file.attribute.UserPrincipal;

@Controller
public class LoginController {

    @Autowired
    private PremiumAccountRepository premiumAccountRepository;

    private PremiumAccount premiumAccount;
    private PremiumAccountService service;


    @GetMapping("/login")
    public String showLogin() {
        return "html/login";
    }

    //default mapping and use user principal to get premiumAccount.id and route to premiumAccount/{id}
    @GetMapping("/userProfile")
    public String userProfilePage(Authentication authentication) throws AccountNotFoundException {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        PremiumAccount premiumAccountId = service.getPremiumAccountById(premiumAccount.getId());
        return "redirect:/premiumAccount/" + premiumAccountId;
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/home";
    }

}
