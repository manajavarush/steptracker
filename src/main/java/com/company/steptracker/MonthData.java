package com.company.steptracker;

public class MonthData {
    private final int[] days;

    MonthData() {
        this.days = new int[30];
    }

    void saveSteps(int dayNumber, int steps) {
        days[dayNumber - 1] = steps;
    }

    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + " день: " + days[i]);
        }
    }

    int sumStepsFromMonth() {
        int sumStepsFromMonth = 0;

        for (int steps : days) {
            sumStepsFromMonth += steps;
        }

        return sumStepsFromMonth;
    }

    int maxSteps() {
        int maxSteps = 0;

        for (int steps : days) {

            if (steps > maxSteps) {
                maxSteps = steps;
            }

        }

        return maxSteps;
    }

    int bestSeries(int goal) {
        int currentSeries = 0;
        int maxSeries = 0;

        for (int steps : days) {

            if (steps >= goal) {
                currentSeries++;

                if (maxSeries < currentSeries) {
                    maxSeries = currentSeries;
                }

            } else {
                currentSeries = 0;
            }

        }

        return maxSeries;
    }
}
