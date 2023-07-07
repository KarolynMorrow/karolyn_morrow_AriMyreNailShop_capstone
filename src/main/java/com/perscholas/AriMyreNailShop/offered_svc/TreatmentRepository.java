package com.perscholas.AriMyreNailShop.offered_svc;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TreatmentRepository extends JpaRepository<Treatment, Integer> {
    Optional<Treatment> findByServiceName(String serviceName);
    Optional<Treatment> findByServiceId(int serviceId);

}
