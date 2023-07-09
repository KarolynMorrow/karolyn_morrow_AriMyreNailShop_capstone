package com.perscholas.AriMyreNailShop.security;

import com.perscholas.AriMyreNailShop.premium.PremiumAccount;
import com.perscholas.AriMyreNailShop.premium.PremiumAccountRepository;
import com.perscholas.AriMyreNailShop.premium.PremiumAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.security.auth.login.AccountNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private PremiumAccountRepository premiumAccountRepository;

    private PremiumAccount premiumAccount;
    @Autowired
    private PremiumAccountService premiumService;


    @GetMapping("/login")
    public String showLogin() {
        return "html/login";
    }

    //default mapping and use user principal to get premiumAccount.id and route to premiumAccount/{id}
    @GetMapping("/userProfile")
    public String userProfilePage(Authentication authentication) throws AccountNotFoundException {
        if (authentication != null && authentication.isAuthenticated()) {
            PremiumAccount premiumAccount = getPremiumAccountFromAuthentication(authentication);

            if (premiumAccount != null) {
                return "redirect:/premiumAccount/" + premiumAccount.getId();
            } else {
                return "redirect:/home";
            }
        }
        return "redirect:/home";
    }

    private PremiumAccount getPremiumAccountFromAuthentication(Authentication authentication) throws AccountNotFoundException {
        //retrieves PremiumAccount based on the authenticated user
        UserDetails userPrincipal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userPrincipal.getUsername();
        return premiumService.getPremiumAccountByUsername(username);

    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/home";
    }

}
