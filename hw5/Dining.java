package jdk.hw5;

import java.util.List;

public class Dining {
    private final List<Philosopher> philosophers;

    public Dining(List<Philosopher> philosophers) {
        this.philosophers = philosophers;
    }

    public void setThreads() {
        for (Philosopher philosopher : philosophers) {
            Runnable runnable = () -> {
                int countDining = 3; // Каждый философ должен поесть 3 раза
                while (countDining != 0) {
                    philosopher.eating();
                    philosopher.thinking();
                    countDining--;
                }
            };

            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}