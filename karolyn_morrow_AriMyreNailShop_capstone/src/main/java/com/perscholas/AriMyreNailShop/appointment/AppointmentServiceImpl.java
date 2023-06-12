package com.perscholas.AriMyreNailShop.appointment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
     public void save(Appointment a){
        appointmentRepository.save(a);
    }

    @Override
     public List<Appointment> getAllAppointments(){
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getAppointmentById(long id){
        return appointmentRepository.findById(id).get();
    }

    @Override
     public void deleteById(long id){
        appointmentRepository.deleteById(id);
    }
    
}
