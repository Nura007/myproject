package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
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

    public User() {}

    public User(String name, int age, double weight, double height, String subscriptionType, boolean isVip) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.subscriptionType = subscriptionType;
        this.isVip = isVip;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getWeight() { return weight; }
    public double getHeight() { return height; }
    public String getSubscriptionType() { return subscriptionType; }
    public boolean isVip() { return isVip; }
    public Coach getAssignedCoach() { return assignedCoach; }

    public void setName(String name) { this.name = name; }
    public void setWeight(double weight) { this.weight = weight; }
    public void setHeight(double height) { this.height = height; }
    public void setSubscriptionType(String subscriptionType) { this.subscriptionType = subscriptionType; }

    public void assignCoach(Coach coach) {
        this.assignedCoach = coach;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + id +
                ", Name='" + name + '\'' +
                ", Age=" + age +
                ", VIP=" + isVip +
                ", Subscription='" + subscriptionType + '\'' +
                ", Coach=" + (assignedCoach != null ? assignedCoach.getName() : "None") +
                '}';
    }
}
