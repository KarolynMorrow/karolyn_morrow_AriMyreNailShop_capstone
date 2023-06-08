package com.perscholas.AriMyreNailShop.controllers;


import com.perscholas.AriMyreNailShop.models.PremiumAccount;
import com.perscholas.AriMyreNailShop.services.AppointmentService;
import com.perscholas.AriMyreNailShop.services.PremiumAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/registration")
    public String displayRegisterForm(Model model){
        PremiumAccount premiumAccount = new PremiumAccount();
        model.addAttribute("premiumAccount", premiumAccount);
        return "premiumAccount/register";
    }

    @PostMapping("/save")
    public String addAccount(@ModelAttribute("premiumAccount") @Valid PremiumAccount p,BindingResult result, Model model){
        if (result.hasErrors()) {
            return "register";
        }
        //save account to DB
        premiumService.savePremiumAccount(p);
        return "redirect: /premiumAccount/premiumHome";
    }

    @GetMapping("/premiumHome/{id}")
    public String showPremiumAccountHome(@PathVariable int id, Model model){
        model.addAttribute("premiumAccount", premiumService.getPremiumAccountById(id));
        return "premiumAccount/premiumHome";
    }

    @GetMapping("/edit/{id}")
    public String updatePremiumForm(@PathVariable int id, Model model){
        PremiumAccount account = premiumService.getPremiumAccountById(id);
        model.addAttribute("account", account);
       return "premiumAccount/update";
    }

//    @GetMapping("/{idx}")
//    public String showPremiumAccountPage(@PathVariable("idx") int id){
//
//        return ("This is the premium page of: " + id);
//    }


//@GetMapping("/appointments")
//    public ModelAndView getAppointments() {
//        List<Appointment> appointmentList = appointmentService.getAllAppointments();
//        return new ModelAndView("appointmentList", "appointment", appointmentList);
//}
//
//    @PostMapping("/my_appointments")
//    public String addAppointments(@ModelAttribute PremiumAccount p){
//        premiumService.savePremiumAccount(p);
//        return "redirect:/appointments";
//    }

}
