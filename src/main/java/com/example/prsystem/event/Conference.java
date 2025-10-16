package com.example.prsystem.event;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Conference extends Event {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "conference_id")
    private List<Speaker> speakers;

    public Conference() {}

    // getters and setters

    public List<Speaker> getSpeakers() { return speakers; }
    public void setSpeakers(List<Speaker> speakers) { this.speakers = speakers; }
}