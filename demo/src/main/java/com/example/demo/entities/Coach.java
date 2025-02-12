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
    private List<String> schedule = new ArrayList<>();

    public Coach() {}

    public Coach(String name) {
        this.name = name;
    }

    public int getCoachId() { return coachId; }
    public String getName() { return name; }
    public List<String> getSchedule() { return schedule; }
    public void setName(String name) { this.name = name; }

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
