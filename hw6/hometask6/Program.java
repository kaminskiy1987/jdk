package hw6.hometask6;

public class Program {

    public static void main(String[] args) {
        int doors = 3;
        int maxIteration = 1000;

        MontyHall game = new MontyHall(doors, maxIteration);
        game.startGame();
        game.getResult();
    }
}