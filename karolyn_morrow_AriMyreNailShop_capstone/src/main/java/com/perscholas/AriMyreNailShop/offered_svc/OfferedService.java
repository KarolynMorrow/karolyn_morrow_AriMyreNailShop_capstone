package com.perscholas.AriMyreNailShop.offered_svc;

import com.perscholas.AriMyreNailShop.appointment.Appointment;

import javax.persistence.*;

@Entity
@Table(name = "Service_for_appointment")
public class OfferedService {
    @Id
    private int serviceId;
    private String serviceName;
    private int servicePrice;
   /* @ManyToOne
    private Appointment appointment;*/

    public OfferedService() {
    }

    public OfferedService(int serviceId, String serviceName, int servicePrice) {
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

    /*public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }*/
}
