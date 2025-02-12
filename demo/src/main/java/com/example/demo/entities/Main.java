package com.example.demo.entities;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FitnessApp app = new FitnessApp();

        System.out.println("🏋️‍♂️ Добро пожаловать в Fitness Tracker!");

        while (true) {
            System.out.println("\n=== Главное меню ===");
            System.out.println("1️⃣ Добавить пользователя");
            System.out.println("2️⃣ Добавить тренировку");
            System.out.println("3️⃣ Добавить тренера");
            System.out.println("4️⃣ Назначить тренера пользователю");
            System.out.println("5️⃣ Показать пользователей");
            System.out.println("6️⃣ Показать тренировки");
            System.out.println("7️⃣ Показать тренеров");
            System.out.println("8️⃣ Выйти");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите имя: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите возраст: ");
                    int age = scanner.nextInt();
                    System.out.print("Введите ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Введите тип подписки (Месяц / Полгода / Год / VIP): ");
                    String subType = scanner.nextLine();

                    boolean isVip = subType.equalsIgnoreCase("VIP");
                    User user = new User(id, name, age, 70, 175, subType, isVip);
                    app.addUser(user);
                    System.out.println("✅ Пользователь добавлен!");
                    break;

                case 2:
                    System.out.print("Введите название тренировки: ");
                    String title = scanner.nextLine();
                    app.addWorkoutPlan(new WorkoutPlan(1, title, "Описание", 60, "Intermediate"));
                    System.out.println("✅ Тренировка добавлена!");
                    break;

                case 3:
                    System.out.print("Введите имя тренера: ");
                    String coachName = scanner.nextLine();
                    app.addCoach(new Coach(1, coachName));
                    System.out.println("✅ Тренер добавлен!");
                    break;

                case 4:
                    System.out.print("Введите ID пользователя: ");
                    int userId = scanner.nextInt();
                    System.out.print("Введите ID тренера: ");
                    int coachId = scanner.nextInt();
                    app.assignCoachToUser(userId, coachId);
                    break;

                case 5:
                    app.printUsers();
                    break;

                case 6:
                    app.printWorkoutPlans();
                    break;

                case 7:
                    app.printCoaches();
                    break;

                case 8:
                    System.out.println("🚀 Выход.");
                    return;
            }
        }
    }
}
