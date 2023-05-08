package com.perscholas.AriMyreNailShop;

import com.perscholas.AriMyreNailShop.models.Appointment;
import com.perscholas.AriMyreNailShop.models.Service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main extends NailShop {
    public static void main(String[] args) {
//        Client arykah = new GuestAccount("Arykah", "Jones", "ajones@email.com");
//        Client ty = new PremiumAccount("Ty", "Thompson", "tyThomas@email.com", "tyJones");
//
//        System.out.println(arykah.greetClient());
//        System.out.println(ty.greetClient());
//
//        NailShop AriNailShop = new NailShop();
//        AriNailShop.addClient(arykah);
//        AriNailShop.addClient(ty);
//
//        // AriNailShop.getAllClients();
//        AriNailShop.getClient(arykah);
//        AriNailShop.updateClient(ty);
        //AriNailShop.deleteClient(arykah);

        //AriNailShop.updateClient(arykah);
        //Input Premiumaccounts into clientHashMap input guestAccounts into appointmentHashMap


//        arykah.returnName();
//        System.out.println(arykah.returnClientInfo());
//        System.out.println(ty.returnClientInfo());
//
//        ty.setLastName("Morrison");
//
//        System.out.println(ty.returnClientInfo());
        SessionFactory factory = new
                Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        Service basicMani = new Service();
        basicMani.setServicePrice(30);
        basicMani.setServiceName("Basic Manicure");
        basicMani.setServiceId(1);

        Service basicPedi = new Service();
        basicPedi.setServiceId(2);
        basicPedi.setServiceName("Basic Pedicure");
        basicPedi.setServicePrice(40);

        Service boujeeMani = new Service(3, "Boujee Manicure", 40);
        Service boujeePedi = new Service(4, "Boujee Pedicure", 50);

        //Add Service entity object to list
        List<Service> services = new ArrayList<>();
        services.add(basicMani);
        services.add(basicPedi);
        services.add(boujeeMani);
        services.add(boujeePedi);

        session.save(basicMani);
        session.save(basicPedi);
        session.save(boujeeMani);
        session.save(boujeePedi);


        //Create Appointment
        Appointment ty = new Appointment();
        ty.setServices(services);
        ty.setAppointmentDate(LocalDate.of(2023, 12, 23));

        //Store Appointment
        session.save(ty);
        t.commit();
    }

    }

