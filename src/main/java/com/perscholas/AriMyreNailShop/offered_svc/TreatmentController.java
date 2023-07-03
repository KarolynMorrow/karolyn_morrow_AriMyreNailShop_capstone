package com.perscholas.AriMyreNailShop.offered_svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TreatmentController {
    private TreatmentService treatmentService;

    @Autowired
    private TreatmentRepository treatmentRepository;
    public TreatmentController(){

    }
    @Autowired
    public TreatmentController(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    @GetMapping("/chooseService")
    public String getOfferedServicesPage(Model model){
        List<Treatment> getTreatments = treatmentRepository.findAll();
        model.addAttribute("treatments", getTreatments);
        return "html/servicePrices";
    }

    @GetMapping("/extraServices")
    public String showExtraSvcsPage(){
        return "html/extraSvcs";
    }
}
