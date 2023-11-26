package hw6.hometask6;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Класс описывает механизм парадокса Монти Холла
 */
public class MontyHall {
    private int quantityDoors;
    private int maxIteration;
    private int wins;
    private int loses;
    private Map<Integer, Boolean> resultGame;

    public MontyHall(int quantityDoors, int maxIteration) {
        this.quantityDoors = quantityDoors;
        this.maxIteration = maxIteration;
        this.wins = 0;
        this.loses = 0;
        this.resultGame = new HashMap<>();
    }

    /**
     * Метод получения парадокса Монти Холла
     * @return возвращает коллекцию результатов выпавших комбинаций
     */
    public Map<Integer, Boolean> startGame() {
        int counter = 0;
        while (counter < maxIteration) {
            // правильная дверь
            int winDoor = new Random().nextInt(quantityDoors);

            // выбранная игроком дверь
            int chosenDoor = new Random().nextInt(quantityDoors);

            // ведущий выбирает дверь, которая не является правильной, либо дверью игрока
            int dealerChoose = new Random().nextInt(quantityDoors);
            while(dealerChoose == chosenDoor || dealerChoose == winDoor) {
                dealerChoose = new Random().nextInt(quantityDoors);
            }

            // игрок меняет свой выбор
            int newChosenDoor = quantityDoors - dealerChoose - chosenDoor;
            resultGame.put(counter + 1, checkResult(winDoor, newChosenDoor));
            counter++;
        }
        return resultGame;
    }

    /**
     * Метод проверки результата раунда
     * @param winDoor Правильный ответ
     * @param chosenDoor Выбранный ответ
     * @return true если выбранный ответ оказался правильным
     */
    private boolean checkResult(int winDoor, int chosenDoor) {
        return winDoor == chosenDoor;
    }

    /**
     * Метод получения и вывода на дисплей информации о результате игры
     */
    public void getResult() {
        for (int i = 0; i < resultGame.size(); i++) {
            if (resultGame.get(i + 1)) {
                wins++;
            } else {
                loses++;
            }
        }
        System.out.println("Угадано комбинаций: " + wins + " из " + maxIteration + " или " + (wins * 100) / maxIteration +"%");
        System.out.println("Не угадано комбинаций: " + loses + " из " + maxIteration + " или " + (loses * 100) / maxIteration +"%");
    }
}