package com.perscholas.AriMyreNailShop.security;

import com.perscholas.AriMyreNailShop.premium.PremiumAccount;
import com.perscholas.AriMyreNailShop.premium.PremiumAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class SignUpController {
    private PremiumAccountService premiumService;

    @Autowired
    public SignUpController(PremiumAccountService premiumService) {
        this.premiumService = premiumService;
    }

    @GetMapping("/registration")
    public String displayRegisterForm(Model model){
        model.addAttribute("premiumAccount", new PremiumAccount());
        return "html/signUp";
    }

    @PostMapping("/save")
    public String addAccount(@ModelAttribute("premiumAccount") @Valid PremiumAccount p, BindingResult result, Model model){
        //PremiumAccount existingAccount = premiumService.getAccount(p.getUsername());

        if (result.hasErrors() /*&& existingAccount != null*/) {
            model.addAttribute("error", "Username already exists. Please choose another username.");
            return "html/signUp";
        }
        //save account to DB
        premiumService.savePremiumAccount(p);
        return "redirect:/login";
    }

}
