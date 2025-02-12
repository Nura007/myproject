package com.example.demo;

import com.example.demo.entities.User;
import jakarta.persistence.*;

@Entity
public class WorkoutPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int planId;

    private String title;
    private String description;
    private int duration;
    private String difficulty;

    @ManyToOne
    @JoinColumn(name = "user_id") // Внешний ключ на пользователя
    private User user;

    // 🟢 Конструктор по умолчанию (обязателен для Hibernate)
    public WorkoutPlan() {}

    // 🟢 Конструктор с параметрами
    public WorkoutPlan(String title, String description, int duration, String difficulty, User user) {
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.difficulty = difficulty;
        this.user = user; // Устанавливаем связь с пользователем
    }

    public int getPlanId() { return planId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public int getDuration() { return duration; }
    public String getDifficulty() { return difficulty; }
    public User getUser() { return user; }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "WorkoutPlan{" +
                "ID=" + planId +
                ", Title='" + title + '\'' +
                ", Difficulty='" + difficulty + '\'' +
                ", User=" + (user != null ? user.getName() : "None") +
                '}';
    }
}
