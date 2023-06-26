package com.perscholas.AriMyreNailShop.appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perscholas.AriMyreNailShop.appointment.Appointment;

import java.time.LocalDate;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Appointment findByAppointmentDate(LocalDate appointmentDate);

}