package com.perscholas.AriMyreNailShop.offered_svc;

import com.perscholas.AriMyreNailShop.appointment.Appointment;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Treatment {

    @Id
    private int serviceId;
    private String serviceName;
    private int servicePrice;
    private String description;


    //One treatment belongs to one appointment
    @ManyToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;




    public Treatment() {
    }

    public Treatment(int serviceId, String serviceName, int servicePrice) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
    }

}
