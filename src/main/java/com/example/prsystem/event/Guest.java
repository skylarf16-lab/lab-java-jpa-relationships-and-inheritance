package com.example.prsystem.event;

import jakarta.persistence.*;

@Entity
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private GuestStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private Event event;

    public Guest() {}

    public Guest(Long id, String name, GuestStatus status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public GuestStatus getStatus() { return status; }
    public void setStatus(GuestStatus  status) { this.status = status; }

    public Event getEvent() { return event; }
    public void setEvent(Event event) { this.event = event; }
}
