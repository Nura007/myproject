package com.example.demo.repository;

import com.example.demo.entities.WorkoutPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan, Integer> {
    // Здесь можно добавлять кастомные методы для запросов в базу данных
}
