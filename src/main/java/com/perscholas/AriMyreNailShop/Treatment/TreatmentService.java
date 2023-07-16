package com.perscholas.AriMyreNailShop.Treatment;

import java.util.List;
import java.util.Optional;


public interface TreatmentService {
    void save(Treatment treatment);

    List<Treatment> getAllTreatments();
    Optional<Treatment> getTreatmentByName(String serviceName);
    void deleteById(int id);

    Treatment getTreatmentById(int serviceId);

}
