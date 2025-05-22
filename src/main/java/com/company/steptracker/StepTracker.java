package com.company.steptracker;

import java.util.Scanner;

public class StepTracker {
    private final Scanner scanner;

    private final Converter converter;

    private final MonthData[] monthToData;

    private int goalByStepsPerDay;



    StepTracker(Scanner scanner) {
        this.scanner = scanner;
        this.converter = new Converter();

        this.monthToData = new MonthData[12];

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }

        this.goalByStepsPerDay = 10_000;
    }

    void addNewNumberStepsPerDay(int monthNumber, int dayNumber, int steps) {

        if (monthNumber < 1 || monthNumber > 12) {
            System.out.println("Некорректный номер месяца");
            return;
        }

        if (dayNumber < 1 || dayNumber > 30) {
            System.out.println("Некорректный номер дня");
            return;
        }

        if (steps < 1) {
            System.out.println("Некорректное количество шагов");
            return;
        }

        monthToData[monthNumber - 1].saveSteps(dayNumber, steps);

        System.out.println("Шаги сохранены");
    }

    void changeStepGoal(int newGoalByStepsPerDay) {

        if (newGoalByStepsPerDay <= 0) {
            System.out.println("Новая цель не может быть отрицательным числом или равна нулю");
            return;
        }

        this.goalByStepsPerDay = newGoalByStepsPerDay;

        System.out.println("Новая цель: " + newGoalByStepsPerDay + " шагов");
    }

    void printStatistic(int monthNumber) {
        if (monthNumber < 1 || monthNumber > 12) {
            System.out.println("Некорректный номер месяца");
            return;
        }

        MonthData monthData = monthToData[monthNumber - 1];

        System.out.println("Статистика за " + monthNumber + " месяц:");
        monthData.printDaysAndStepsFromMonth();

        int totalSteps = monthData.sumStepsFromMonth();

        System.out.println("Общее количество шагов за месяц: " + totalSteps);
        System.out.println("Максимальное пройденное количество шагов в месяце: " + monthData.maxSteps());
        System.out.println("Среднее количество шагов: " + (totalSteps / 30));
        System.out.println("Пройденная дистанция: " + converter.convertToKm(totalSteps) + " км");
        System.out.println("Количество сожжённых килокалорий: " + converter.convertStepsToKilocalories(totalSteps));
        System.out.println("Лучшая серия: " + monthData.bestSeries(goalByStepsPerDay) + " дней");
    }
}
