package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "coaches")
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int coachId;
    private String name;


    @ElementCollection
    @CollectionTable(name = "coach_schedule", joinColumns = @JoinColumn(name = "coach_id"))
    @Column(name = "schedule_entry")
    private List<String> schedule = new ArrayList<>();


    public Coach(int coachId, String name) {
        this.coachId = coachId;
        this.name = name;
        this.schedule = new ArrayList<>();
    }

    public Coach() {

    }

    public int getCoachId() { return coachId; }
    public String getName() { return name; }
    public List<String> getSchedule() { return schedule; }

    public void addSchedule(String time) {
        schedule.add(time);
    }

    @Override
    public String toString() {
        return "Coach{" +
                "ID=" + coachId +
                ", Name='" + name + '\'' +
                ", Schedule=" + schedule +
                '}';
    }
}
