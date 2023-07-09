package com.perscholas.AriMyreNailShop.appointment;

import com.perscholas.AriMyreNailShop.offered_svc.Treatment;
import com.perscholas.AriMyreNailShop.premium.PremiumAccount;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.swing.plaf.basic.BasicTreeUI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentId;
    private LocalDate appointmentDate;

    //one appointment belongs to one account, but one account can have many appointments
    @ManyToOne
    @JoinColumn(name = "premium_account_id")
    private PremiumAccount premiumAccount;


    //one appointment can have many treatments
    @OneToMany(mappedBy = "appointment")
    private List<Treatment> treatments = new ArrayList<>(); //creates LIST of offeredSvcs per Appointment
    //when saving an appointment, have to save treatment FIRST since not using cascade all


    public Appointment() {
    }

    public Appointment(int appointmentId){
        this.appointmentId = appointmentId;
    }

    public Appointment(int appointmentId, LocalDate appointmentDate) {
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
    }

    public void addTreatment(Treatment treatment){
        treatments.add(treatment);
    }

    public void removeTreatment(Treatment treatment){
        treatments.remove(treatment);
    }

}
