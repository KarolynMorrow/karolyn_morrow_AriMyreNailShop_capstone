package com.perscholas.AriMyreNailShop;

import com.perscholas.AriMyreNailShop.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.SQLOutput;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main extends NailShop {
    public static void main(String[] args) {
        SessionFactory factory = new
                Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        List<Account> accountList = new ArrayList<>();

        System.out.println("Please choose an option:\n1: Create an account\n2: Continue as a guest");
        Scanner choice = new Scanner(System.in);
        int num = choice.nextInt();
        if (num == 1) {
            Scanner info = new Scanner(System.in);
            while (info.hasNextLine()) {
                String firstName = info.nextLine();
                String lastName = info.nextLine();
                LocalDate dateOfBirth = LocalDate.ofEpochDay(info.nextInt());
                String email = info.nextLine();
                String userName = info.nextLine();
                String passWord = info.nextLine();

                PremiumAccount premiumAccount = new PremiumAccount(firstName, lastName, dateOfBirth, email, userName, passWord);
                accountList.add(premiumAccount);
                System.out.println("Thank you for registering with AriMyre Nails " + firstName + " " + lastName);
                session.save(premiumAccount);
            }
        } else if(num == 2) {
            System.out.println("Please input your name and email address:\n");
            Scanner guestInfo = new Scanner(System.in);
            String firstName = guestInfo.nextLine();
            String lastName = guestInfo.nextLine();
            String email = guestInfo.nextLine();
            GuestAccount guestAccount = new GuestAccount(firstName, lastName, email);
            accountList.add(guestAccount);
            System.out.println("Welcome to AriMyre Nails " + firstName + " " + lastName);
            session.save(guestAccount);

        }




        GuestAccount arykah = new GuestAccount();
        arykah.setFirstName("Arykah");
        arykah.setLastName("Jones");
        arykah.setEmail("ari@email.com");

        PremiumAccount ty = new PremiumAccount();
        ty.setFirstName("Tyhe");
        ty.setLastName("Morrison");
        ty.setUserName("ty_morr");
        ty.setPassWord("thankYou");
        ty.setDateOfBirth(LocalDate.of(1977, 7, 7));
        ty.setEmail("ty@email.com");

        //Add account objects to list
        accountList.add(arykah);
        accountList.add(ty);

        //and save
        session.save(arykah);
        session.save(ty);


        //Input PremiumAccounts into clientHashMap input guestAccounts into appointmentHashMap


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
        Appointment appointment = new Appointment();
        appointment.setServices(services);
        appointment.setAppointmentDate(LocalDate.of(2023, 12, 23));


        //Store Appointment
        session.save(appointment);
        t.commit();
    }

}

