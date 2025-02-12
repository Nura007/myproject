package com.example.demo.controller;

import com.example.demo.entities.Coach;
import com.example.demo.entities.User;
import com.example.demo.WorkoutPlan;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WorkoutPlanController {

    private final List<User> users = new ArrayList<>();
    private final List<WorkoutPlan> workoutPlans = new ArrayList<>();
    private final List<Coach> coaches = new ArrayList<>();

    @PostMapping("/users")
    public String addUser(@RequestBody User user) {
        users.add(user);
        return "User added successfully!";
    }

    @PostMapping("/workoutPlans")
    public String addWorkoutPlan(@RequestBody WorkoutPlan plan) {
        workoutPlans.add(plan);
        return "Workout Plan added successfully!";
    }

    @PostMapping("/coaches")
    public String addCoach(@RequestBody Coach coach) {
        coaches.add(coach);
        return "Coach added successfully!";
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return users;
    }

    @GetMapping("/workoutPlans")
    public List<WorkoutPlan> getWorkoutPlans() {
        return workoutPlans;
    }

    @GetMapping("/coaches")
    public List<Coach> getCoaches() {
        return coaches;
    }

    @PostMapping("/assignCoach")
    public String assignCoachToUser(@RequestParam int userId, @RequestParam int coachId) {
        User user = users.stream().filter(u -> u.getId() == userId).findFirst().orElse(null);
        Coach coach = coaches.stream().filter(c -> c.getCoachId() == coachId).findFirst().orElse(null);
        if (user != null && coach != null) {
            user.assignCoach(coach);
            return "Coach assigned successfully!";
        }
        return "Error: Invalid user or coach ID.";
    }
}
