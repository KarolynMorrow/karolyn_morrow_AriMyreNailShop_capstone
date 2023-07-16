package com.perscholas.AriMyreNailShop.appointment;

import com.perscholas.AriMyreNailShop.Treatment.Treatment;
import com.perscholas.AriMyreNailShop.premium.PremiumAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perscholas.AriMyreNailShop.appointment.Appointment;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Appointment findByAppointmentDate(LocalDate appointmentDate);
    List<Treatment> findAllTreatmentsByAppointmentId(long id);

}