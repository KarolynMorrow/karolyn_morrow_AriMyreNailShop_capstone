package com.perscholas.AriMyreNailShop.appointment;


import com.perscholas.AriMyreNailShop.Treatment.Treatment;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    //one appointment can have many treatments
    @OneToMany(targetEntity = Treatment.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Treatment> treatments; //creates LIST of offeredSvcs per Appointment
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
