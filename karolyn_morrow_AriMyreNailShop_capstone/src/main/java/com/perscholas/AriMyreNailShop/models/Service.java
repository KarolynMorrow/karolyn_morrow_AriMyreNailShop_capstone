package com.perscholas.AriMyreNailShop.models;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Entity
@Table
public class Service {
    @Id
    private int serviceId;
    private String serviceName;
    private int servicePrice;
    @ManyToOne(targetEntity = Appointment.class)
    private Appointment appointments;

    public Service() {
    }

    public Service(int serviceId, String serviceName, int servicePrice) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(int servicePrice) {
        this.servicePrice = servicePrice;
    }

    public Appointment getAppointments() {
        return appointments;
    }

    public void setAppointments(Appointment appointments) {
        this.appointments = appointments;
    }
}
