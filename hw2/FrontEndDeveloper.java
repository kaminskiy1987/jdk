package jdk.hw2;

public class FrontEndDeveloper extends Developer {

    @Override
    void drinkCoffee() {
        System.out.println("drinkCoffee");
    }

    @Override
    void drinkTee() {
        System.out.println("drinkTee");
    }


    public void developGUI() {
        System.out.println("create GUI");
    }
}