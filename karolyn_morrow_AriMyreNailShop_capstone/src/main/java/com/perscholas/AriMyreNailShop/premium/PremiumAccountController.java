package com.perscholas.AriMyreNailShop.premium;


import com.perscholas.AriMyreNailShop.appointment.AppointmentService;
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
        return "html/signUp";
    }

    @PostMapping("/save")
    public String addAccount(@ModelAttribute("premiumAccount") @Valid PremiumAccount p, BindingResult result){
        if (result.hasErrors()) {
            return "html/signUp";

        }
        System.out.println("This is creating an account");
        //save account to DB
        premiumService.savePremiumAccount(p);
        return "redirect: html/premiumHome";
    }

    @GetMapping("/{id}")
    public String showPremiumAccountHome(@PathVariable(value = "id") long id, Model model){
        System.out.println(premiumService.getPremiumAccountById(id));
        model.addAttribute("premiumAccount", premiumService.getPremiumAccountById(id));
        return "html/premiumHome";
    }

    @GetMapping("/edit/{id}")
    public String updatePremiumForm(@PathVariable(value = "id") long id, Model model){
        PremiumAccount account = premiumService.getPremiumAccountById(id);
        model.addAttribute("account", account);
       return "html/update";
    }

    //Show a list of past appointments

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
