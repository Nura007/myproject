
package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class WorkoutPlan {
    // Геттеры и сеттеры
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int planId;
    private String title;
    private String description;
    private int duration;
    private String difficulty;

    @ManyToOne

    @JoinColumn(name = "user_id")
    private User user;

    public WorkoutPlan() {}

    public WorkoutPlan(String title, String description, int duration, String difficulty, User user) {
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.difficulty = difficulty;
        this.user = user;
    }

    public WorkoutPlan(int i, String title, String описание, int i1, String intermediate) {
    }

    // Переопределение toString()
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
