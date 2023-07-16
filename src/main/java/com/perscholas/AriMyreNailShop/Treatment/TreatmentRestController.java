package com.perscholas.AriMyreNailShop.Treatment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TreatmentRestController {

    @Autowired
    private TreatmentRepository treatmentRepository;

    @Autowired
    TreatmentService treatmentService;

    @GetMapping("/treatments")
    public List<Treatment> getAllTreatments(Model model){
        return treatmentService.getAllTreatments();
    }

    @GetMapping("/chooseService/{treatment}")
    public ResponseEntity<Treatment> getTreatmentByName(@PathVariable("treatment") String serviceName) {
        Optional<Treatment> treatmentOptional = treatmentRepository.findByServiceName(serviceName);
        if (treatmentOptional.isPresent()) {
            Treatment treatment = treatmentOptional.get();
            return new ResponseEntity<>(treatment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("treatments/{id}")
    public ResponseEntity<Treatment> updateTreatment(@PathVariable("id") int serviceId, @RequestBody Treatment newTreatment){
        Treatment treatment = treatmentRepository.getById(serviceId);
        if(treatment == null){
            //throws a 404 not found error
            return ResponseEntity.notFound().build();
        } else {

            //update the treatment repository
            treatment.setServicePrice(newTreatment.getServicePrice());
            treatment.setServiceName(newTreatment.getServiceName());
            treatment.setDescription(newTreatment.getDescription());

            //save to treatment repository
            treatmentRepository.save(treatment);
            return ResponseEntity.ok(treatment);


        }



    }




}
