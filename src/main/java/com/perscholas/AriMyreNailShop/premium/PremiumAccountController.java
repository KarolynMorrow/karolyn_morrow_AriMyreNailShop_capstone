package com.perscholas.AriMyreNailShop.premium;


import com.perscholas.AriMyreNailShop.appointment.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/premiumAccount")
public class PremiumAccountController {


    private PremiumAccountService premiumService;
    private AppointmentService appointmentService;
    

    public PremiumAccountController() {
    }

    @Autowired
    public PremiumAccountController(PremiumAccountService premiumService){
        this.premiumService = premiumService;
    }


    @GetMapping("/{id}")
    public String showPremiumAccountHome(@PathVariable(value = "id") long id, Model model){
        model.addAttribute("premiumAccount", premiumService.getPremiumAccountById(id));
        return "html/premiumHome";
    }

    @GetMapping("/edit/{id}")
    public String updatePremiumForm(@PathVariable(value = "id") long id, Model model){
        PremiumAccount account = premiumService.getPremiumAccountById(id);
        model.addAttribute("premiumAccount", account);
       return "html/update";
    }

    @PostMapping("/saveUpdate/{id}")
    public String updateAccount(@PathVariable(value = "id") long id, @ModelAttribute("premiumAccount") @Valid PremiumAccount p, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "html/update";
        }
        PremiumAccount updated = premiumService.getPremiumAccountById(p.getId());
        updated.setFirstName(p.getFirstName());
        updated.setLastName(p.getLastName());
        updated.setEmail(p.getEmail());
        updated.setPassword(p.getPassword());
        premiumService.savePremiumAccount(updated);
        return "redirect:/premiumAccount/" + id; //pass the id in the redirect instead of {id} as the url will pick up and try to find a literal string of "{id}"
    }

    @GetMapping("/deleteAccount/{id}")
    public String deletePremiumAccount(@PathVariable(name = "id") long id){
        this.premiumService.deletePremiumAccount(id);
        return "redirect:/home";
    }





}
