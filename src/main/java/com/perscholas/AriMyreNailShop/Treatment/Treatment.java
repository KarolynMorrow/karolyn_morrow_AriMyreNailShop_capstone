package com.perscholas.AriMyreNailShop.Treatment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Treatment treatment = (Treatment) o;
        return serviceId == treatment.serviceId && servicePrice == treatment.servicePrice && Objects.equals(serviceName, treatment.serviceName) && Objects.equals(description, treatment.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceId, serviceName, servicePrice, description);
    }
}
