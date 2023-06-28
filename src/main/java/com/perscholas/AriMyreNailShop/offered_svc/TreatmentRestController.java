package com.perscholas.AriMyreNailShop.offered_svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TreatmentRestController {

    private TreatmentService treatmentService;

    public TreatmentRestController() {
    }

    @Autowired
    public TreatmentRestController(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }


    @GetMapping("/chooseService/{service}")
    public Treatment getAllTreatments(@PathVariable String service) {

        return null;
    }

}
