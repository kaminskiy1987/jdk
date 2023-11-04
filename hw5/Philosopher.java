package jdk.hw5;

public class Philosopher {

    private final String name;

    Philosopher(String name) {
        this.name = name;
    }

    /**
     * Метод философ размышляет
     */
    public void thinking() {
        System.out.println(name + " размышляет");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод философ обедает
     */
    public void eating() {
        System.out.println(name + " обедает");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}