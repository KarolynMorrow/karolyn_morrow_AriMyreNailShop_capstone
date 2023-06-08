package com.perscholas.AriMyreNailShop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perscholas.AriMyreNailShop.models.Appointment;
import com.perscholas.AriMyreNailShop.repositories.AppointmentRepository;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public void save(Appointment a){
        appointmentRepository.save(a);
    }

    public List<Appointment> getAllAppointments(){
        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(long id){
        return appointmentRepository.findById(id).get();
    }

    public void deleteById(long id){
        appointmentRepository.deleteById(id);
    }

}