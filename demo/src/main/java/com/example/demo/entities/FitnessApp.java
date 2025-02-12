import java.util.*;

public class FitnessApp {
    private List<User> users;
    private List<WorkoutPlan> workoutPlans;
    private List<Coach> coaches;

    public FitnessApp() {
        this.users = new ArrayList<>();
        this.workoutPlans = new ArrayList<>();
        this.coaches = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addWorkoutPlan(WorkoutPlan plan) {
        workoutPlans.add(plan);
    }

    public void addCoach(Coach coach) {
        coaches.add(coach);
    }

    public void assignCoachToUser(int userId, int coachId) {
        User user = users.stream().filter(u -> u.getId() == userId).findFirst().orElse(null);
        Coach coach = coaches.stream().filter(c -> c.getCoachId() == coachId).findFirst().orElse(null);
        if (user != null && coach != null) {
            user.assignCoach(coach);
            System.out.println("✅ Тренер " + coach.getName() + " назначен пользователю " + user.getName());
        } else {
            System.out.println("❌ Ошибка: Неверный ID пользователя или тренера.");
        }
    }

    public void printUsers() {
        users.forEach(System.out::println);
    }

    public void printWorkoutPlans() {
        workoutPlans.forEach(System.out::println);
    }

    public void printCoaches() {
        coaches.forEach(System.out::println);
    }
}
