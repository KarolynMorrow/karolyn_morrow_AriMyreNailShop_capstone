package com.perscholas.AriMyreNailShop.offered_svc;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface TreatmentService {
    public void save(Treatment treatment);

    public List<Treatment> getAllTreatments();
    public Optional<Treatment> getTreatmentByName(String serviceName);
    public void deleteById(int id);

}
