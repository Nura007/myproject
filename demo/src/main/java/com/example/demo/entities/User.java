package com.example.demo.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users") // Название таблицы
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private double weight;
    private double height;
    private String subscriptionType;
    private boolean isVip;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<WorkoutPlan> workoutPlans = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "coach_id")
    private Coach assignedCoach;

    public User(int id, String name, int age, double weight, double height, String subscriptionType, boolean isVip) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.subscriptionType = subscriptionType;
        this.isVip = isVip;
        this.workoutPlans = new ArrayList<>();
    }

    public User() {

    }

    public String getName() {
        return "";
    }

    public void assignCoach(Coach coach) {
    }

    public int getId() {
        return 0;
    }
}
