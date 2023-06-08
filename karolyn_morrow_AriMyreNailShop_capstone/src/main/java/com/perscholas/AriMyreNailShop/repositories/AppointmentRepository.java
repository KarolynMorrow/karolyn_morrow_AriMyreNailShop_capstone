package com.perscholas.AriMyreNailShop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perscholas.AriMyreNailShop.models.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}