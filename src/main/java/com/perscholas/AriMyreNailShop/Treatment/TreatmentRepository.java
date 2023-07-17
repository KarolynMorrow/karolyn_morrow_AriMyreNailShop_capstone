package com.perscholas.AriMyreNailShop.Treatment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Integer> {
    Optional<Treatment> findByServiceName(String serviceName);
    Optional<Treatment> findByServiceId(int serviceId);

}
