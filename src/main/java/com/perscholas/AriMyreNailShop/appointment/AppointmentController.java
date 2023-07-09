package com.perscholas.AriMyreNailShop.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    //Show a list of all appointments on specific home page of premiumaccount holder

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
