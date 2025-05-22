package com.company.steptracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var stepTracker = new StepTracker(scanner);

        while (true) {
            printMenu();

            var input = scanner.nextInt();

            switch (input) {

                case 1 -> {
                    System.out.println("Введите номер месяца (1-12), номер дня (1-30) и количество шагов:");
                    int month = scanner.nextInt();
                    int day = scanner.nextInt();
                    int steps = scanner.nextInt();
                    stepTracker.addNewNumberStepsPerDay(month, day, steps);
                }

                case 2 -> {
                    System.out.println("Введите новую цель по шагам:");
                    int newGoalByStepsPerDay = scanner.nextInt();
                    stepTracker.changeStepGoal(newGoalByStepsPerDay);
                }

                case 3 -> {
                    System.out.println("Введите номер месяца(1-12) для вывода статистики:");
                    int monthNumber = scanner.nextInt();
                    stepTracker.printStatistic(monthNumber);
                }

                case 4 -> {
                    System.out.println("Выход из приложения..");
                    scanner.close();
                    return;
                }

                default -> System.out.println("Неверная операция. Такой команды не существует");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nВыберите опцию из списка и введите ее порядковый номер: ");
        System.out.println("1. Ввести количество шагов за определенный день");
        System.out.println("2. Изменить цель по количеству шагов в день");
        System.out.println("3. Напечатать статистику за определенный месяц");
        System.out.println("4. Выйти из приложения");
    }
}
