package com.perscholas.AriMyreNailShop.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;
    private AppointmentService appointmentService;

    public AppointmentController() {
    }


    //Show the list of all appointments on specific home page of premiumaccount holder


    //edit appointment should go back to /chooseService for update specific to appointment id. Make sure final price is updated also
    @GetMapping("/editAppointment/{id}")
    public String editAppointment(@PathVariable(value = "id") long id, Model model) throws AppointmentNotFoundException {
        Appointment appointment = appointmentService.getAppointmentById(id);
        model.addAttribute("appointment", appointment);

        return "html/chooseService";

    }



    //delete appointment is only accessible to AriMyre (SuperAdmin)

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
