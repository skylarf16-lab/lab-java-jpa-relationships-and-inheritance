package com.example.prsystem.event;

import jakarta.persistence.*;

@Entity
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer presentationDuration;

    public Speaker() {}

    public Speaker(Long id, String name, Integer presentationDuration) {
        this.id = id;
        this.name = name;
        this.presentationDuration = presentationDuration;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getPresentationDuration() { return presentationDuration; }
    public void setPresentationDuration(Integer presentationDuration) { this.presentationDuration = presentationDuration; }

}
