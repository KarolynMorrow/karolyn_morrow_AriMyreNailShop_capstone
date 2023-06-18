package com.perscholas.AriMyreNailShop.offered_svc;

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




    public Treatment() {
    }

    public Treatment(int serviceId, String serviceName, int servicePrice) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
    }

}
