package com.perscholas.AriMyreNailShop.appointment;

import com.perscholas.AriMyreNailShop.offered_svc.Treatment;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentId;
    private LocalDate appointmentDate;

    @OneToMany
    private List<Treatment> treatments; //creates LIST of offeredSvcs per Appointment


    public Appointment() {
    }

    public Appointment(int appointmentId, LocalDate appointmentDate) {
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
    }

}
