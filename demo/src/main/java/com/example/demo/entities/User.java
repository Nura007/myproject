package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    // Геттеры и сеттеры
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Getter
    @Setter
    private String name;
    @Setter
    @Getter
    private int age;
    @Setter
    @Getter
    private double weight;
    @Setter
    @Getter
    private double height;
    @Setter
    @Getter
    private String subscriptionType;
    private boolean isVip;

    @Setter
    @Getter
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<WorkoutPlan> workoutPlans = new ArrayList<>();

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "coach_id")
    private Coach assignedCoach;

    // Конструктор с параметрами
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

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean isVip) {
        this.isVip = isVip;
    }

    // Метод для назначения тренера
    public void assignCoach(Coach coach) {
        this.assignedCoach = coach;
    }

    // Переопределение toString
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                ", subscriptionType='" + subscriptionType + '\'' +
                ", isVip=" + isVip +
                ", assignedCoach=" + (assignedCoach != null ? assignedCoach.getName() : "No coach") +
                '}';
    }
}
