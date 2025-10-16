package com.example.prsystem.config;



import com.example.prsystem.association.*;
import com.example.prsystem.contact.*;
import com.example.prsystem.event.*;
import com.example.prsystem.task.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    @Transactional
    CommandLineRunner loadData(
            ContactRepository contactRepo,
            AssociationRepository associationRepo,
            EventRepository eventRepo,
            ConferenceRepository conferenceRepo,
            GuestRepository guestRepo,
            SpeakerRepository speakerRepo,
            TaskRepository taskRepo
    ) {
        return args -> {


            Name n1 = new Name("Mr.", "John", "A.", "Doe");
            Contact c1 = new Contact(null, "Acme PR", "Account Manager", n1);
            contactRepo.save(c1);

            Name n2 = new Name("Dr.", "Alicia", null, "Fisher");
            Contact c2 = new Contact(null, "Global Media", "Director", n2);
            contactRepo.save(c2);


            Association assoc = new Association();
            assoc.setName("Nurse Association of Spain");

            List<Division> divisions = new ArrayList<>();
            for (int i = 1; i <= 7; i++) {
                Division div = new Division();
                div.setName("Division " + i);
                div.setDistrict("District-" + ((i % 3) + 1));
                div.setAssociation(assoc); // important: set back-reference


                Member pres = new Member();
                pres.setName("President " + i);
                pres.setStatus(MemberStatus.ACTIVE);
                pres.setRenewalDate(LocalDate.now().plusMonths(i));
                pres.setDivision(div); // back-reference


                Member m = new Member();
                m.setName("Member " + i + "-A");
                m.setStatus(i % 2 == 0 ? MemberStatus.LAPSED : MemberStatus.ACTIVE);
                m.setRenewalDate(LocalDate.now().plusYears(1));
                m.setDivision(div); // back-reference


                div.setPresident(pres);
                div.setMembers(List.of(pres, m));

                divisions.add(div);
            }

            assoc.setDivisions(divisions);


            associationRepo.save(assoc);


            Guest g1 = new Guest(null, "Tom Hardy", GuestStatus.ATTENDING);
            Guest g2 = new Guest(null, "Isla Fisher", GuestStatus.NO_RESPONSE);
            Guest g3 = new Guest(null, "Liam Neeson", GuestStatus.NOT_ATTENDING);
            guestRepo.saveAll(List.of(g1, g2, g3));


            Speaker s1 = new Speaker(null, "Dr. Alice Green", 45);
            Speaker s2 = new Speaker(null, "Prof. Ben Carter", 30);
            speakerRepo.saveAll(List.of(s1, s2));


            Conference conf = new Conference();
            conf.setTitle("Healthcare & Nursing Conference 2025");
            conf.setDate(LocalDate.now().plusMonths(1));
            conf.setDuration(2);
            conf.setLocation("Madrid");
            conf.setGuests(List.of(g1, g2));
            conf.setSpeakers(List.of(s1, s2));


            g1.setEvent(conf);
            g2.setEvent(conf);
            guestRepo.saveAll(List.of(g1, g2));

            conferenceRepo.save(conf);


            Exhibition ex = new Exhibition();
            ex.setTitle("Medical Expo 2025");
            ex.setDate(LocalDate.now().plusMonths(2));
            ex.setDuration(1);
            ex.setLocation("Barcelona");
            ex.setGuests(List.of(g3));

            g3.setEvent(ex);
            guestRepo.save(g3);

            eventRepo.save(ex);


            BillableTask t1 = new BillableTask();
            t1.setTitle("Client PR Analysis");
            t1.setDueDate(LocalDate.now().plusDays(7));
            t1.setCompleted(false);
            t1.setHourlyRate(new BigDecimal("75.00"));

            BillableTask t2 = new BillableTask();
            t2.setTitle("Press Release Draft");
            t2.setDueDate(LocalDate.now().plusDays(3));
            t2.setCompleted(false);
            t2.setHourlyRate(new BigDecimal("65.00"));

            InternalTask it1 = new InternalTask();
            it1.setTitle("Team Meeting");
            it1.setDueDate(LocalDate.now().plusDays(1));
            it1.setCompleted(false);

            taskRepo.save(t1);
            taskRepo.save(t2);
            taskRepo.save(it1);
        };
    }
}
