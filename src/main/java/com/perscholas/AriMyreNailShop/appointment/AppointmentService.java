package com.perscholas.AriMyreNailShop.appointment;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppointmentService {
 

    public void save(Appointment a);

    public List<Appointment> getAllAppointments();

    public Appointment getAppointmentById(long id);
    

    public void deleteById(long id);

}