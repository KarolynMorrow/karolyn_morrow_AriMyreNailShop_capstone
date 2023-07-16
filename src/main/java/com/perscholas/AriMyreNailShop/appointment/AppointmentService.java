package com.perscholas.AriMyreNailShop.appointment;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppointmentService {

    void save(Appointment a);
    List<Appointment> getAllAppointments();
    Appointment getAppointmentById(long id);
    void deleteById(long id);
    void addTreatmentToAppointmentById(Appointment appointment, int serviceId);

}