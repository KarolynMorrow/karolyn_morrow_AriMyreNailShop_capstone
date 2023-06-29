package com.perscholas.AriMyreNailShop.offered_svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TreatmentRestController {

    @Autowired
    private TreatmentRepository treatmentRepository;

    @GetMapping("/chooseService/{service}")
    public ResponseEntity<Treatment> getTreatment(@PathVariable("service") String service) {
        Optional<Treatment> treatmentOptional = treatmentRepository.findByServiceName(service);
        if (treatmentOptional.isPresent()) {
            Treatment treatment = treatmentOptional.get();
            return new ResponseEntity<>(treatment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
