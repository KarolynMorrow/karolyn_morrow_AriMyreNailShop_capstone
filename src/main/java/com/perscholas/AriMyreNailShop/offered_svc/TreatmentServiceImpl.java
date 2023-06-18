package com.perscholas.AriMyreNailShop.offered_svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class TreatmentServiceImpl implements TreatmentService{
    @Autowired
    private TreatmentRepository treatmentRepository;


    @Override
    public void save(Treatment treatment) {
        treatmentRepository.save(treatment);
    }

    @Override
    public List<Treatment> getAllTreatments() {
        return treatmentRepository.findAll();
    }

    @Override
    public Treatment getTreatmentById(int id) {
        return treatmentRepository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        treatmentRepository.deleteById(id);
    }
}
