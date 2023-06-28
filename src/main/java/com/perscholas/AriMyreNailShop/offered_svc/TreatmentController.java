package com.perscholas.AriMyreNailShop.offered_svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TreatmentController {
    private TreatmentService treatmentService;
    public TreatmentController(){

    }
    @Autowired
    public TreatmentController(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    @GetMapping("/chooseService")
    public String getOfferedServicesPage(){
        return "html/servicePrices";
    }

    @GetMapping("/extraServices")
    public String showExtraSvcsPage(){
        return "html/extraSvcs";
    }
}
