package com.perscholas.AriMyreNailShop.models;

import javax.persistence.*;

@Entity
public class Service {
    @Id
    private int serviceId;
    private String serviceName;
    private int servicePrice;
    @ManyToOne
    private Appointment appointment;

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

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
}
