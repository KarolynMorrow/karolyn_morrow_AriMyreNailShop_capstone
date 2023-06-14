package com.perscholas.AriMyreNailShop.appointment;

import com.perscholas.AriMyreNailShop.offered_svc.OfferedService;
import com.perscholas.AriMyreNailShop.premium.PremiumAccount;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentId;
    private LocalDate appointmentDate;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<OfferedService> offeredServices;

    @ManyToOne
    private PremiumAccount account;

    public Appointment() {
    }

    public Appointment(int appointmentId, LocalDate appointmentDate) {
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
    }

    public int getAppointmentId() {
        return appointmentId;
    }


    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    /*public List<OfferedService> getServices() {
        return offeredServices;
    }

    public void setServices(List<OfferedService> offeredServices) {
        this.offeredServices = offeredServices;
    }*/


}
