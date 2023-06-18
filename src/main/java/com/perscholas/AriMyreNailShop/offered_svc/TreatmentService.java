package com.perscholas.AriMyreNailShop.offered_svc;

import org.springframework.stereotype.Service;

import java.util.List;


public interface TreatmentService {
    public void save(Treatment treatment);

    public List<Treatment> getAllTreatments();
    public Treatment getTreatmentById(int id);
    public void deleteById(int id);

}
