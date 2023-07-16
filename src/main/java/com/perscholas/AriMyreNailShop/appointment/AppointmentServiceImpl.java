package com.perscholas.AriMyreNailShop.appointment;

import java.util.List;


import com.perscholas.AriMyreNailShop.Treatment.Treatment;
import com.perscholas.AriMyreNailShop.Treatment.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;

public class AppointmentServiceImpl implements AppointmentService {

    private TreatmentService treatmentService;
    private AppointmentRepository appointmentRepository;


    @Autowired
    public AppointmentServiceImpl(TreatmentService treatmentService, AppointmentRepository appointmentRepository) {
        this.treatmentService = treatmentService;
        this.appointmentRepository = appointmentRepository;
    }

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
       Appointment appointment = appointmentRepository.getById(id);
       if(appointment == null){
           throw new AppointmentNotFoundException();
       }
       return appointment;
    }

    @Override
     public void deleteById(long id){
        appointmentRepository.deleteById(id);
    }

    @Override
    public void addTreatmentToAppointmentById(Appointment appointment, int serviceId) {
        Treatment treatment = treatmentService.getTreatmentById(serviceId);
        Appointment appointment1 = getAppointmentById(appointment.getAppointmentId());
        appointment1.addTreatment(treatment);
    }

}
