package jdk.hw5;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        int guests = 5; // 5 философов

        List<Philosopher> philosophers = new ArrayList<>();

        for (int i = 1; i <= guests; i++) {
            philosophers.add(new Philosopher("Philosopher-" + i));
        }

        Dining diningPhilosophers = new Dining(philosophers);

        diningPhilosophers.setThreads();
    }
}