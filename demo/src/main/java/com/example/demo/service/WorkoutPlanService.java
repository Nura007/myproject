package com.example.demo.service;

import com.example.demo.WorkoutPlan;
import com.example.demo.repository.WorkoutPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutPlanService {
    @Autowired
    private WorkoutPlanRepository workoutPlanRepository;

    // Сохраняем новый план тренировки
    public void addWorkoutPlan(WorkoutPlan workoutPlan) {
        workoutPlanRepository.save(workoutPlan);  // Сохраняем объект в базу данных
    }

    // Получаем все планы тренировок
    public List<WorkoutPlan> getAllWorkoutPlans() {
        return workoutPlanRepository.findAll();  // Получаем все планы тренировок
    }
}
