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
        //save account to DB
        premiumService.savePremiumAccount(p);
        return "redirect:/premiumAccount/login";
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
    public String updateAccount(@ModelAttribute("premiumAccount") @Valid PremiumAccount p, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "html/update";
        }
        PremiumAccount updated = premiumService.getPremiumAccountById(p.getId());
        updated.setFirstName(p.getFirstName());
        updated.setLastName(p.getLastName());
        updated.setEmail(p.getEmail());
        updated.setPassword(p.getPassword());
        return "redirect:/premiumAccount/{id}";
    }


    @GetMapping("/deleteAccount/{id}")
    public String deletePremiumAccount(@PathVariable(name = "id") long id){
        this.premiumService.deletePremiumAccount(id);
        return "redirect:/home";
    }

    @GetMapping("/login")
    public String login(){
        return "html/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/home";
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
