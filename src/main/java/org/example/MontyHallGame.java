package org.example;

import lombok.Data;
import java.util.HashMap;
import java.util.Random;

@Data
public class MontyHallGame {
    private final Random random = new Random();
    private HashMap<Integer, Boolean> results = new HashMap<>();

    public void simulate(int rounds, boolean switchDoor) {
        int wins = 0;

        for (int i = 0; i < rounds; i++) {
            boolean win = playRound(switchDoor);
            results.put(i + 1, win);
            if (win) {
                wins++;
            }
        }

        System.out.println("Total rounds: " + rounds);
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + (rounds - wins));
    }

    private boolean playRound(boolean switchDoor) {
        int winningDoor = random.nextInt(3);
        int chosenDoor = random.nextInt(3);

        int revealedDoor;
        do {
            revealedDoor = random.nextInt(3);
        } while (revealedDoor == winningDoor || revealedDoor == chosenDoor);

        if (switchDoor) {
            chosenDoor = 3 - chosenDoor - revealedDoor;
        }

        return chosenDoor == winningDoor;
    }

    public void printResults() {
        results.forEach((round, result) -> {
            String outcome = result ? "Win" : "Lose";
            System.out.println("Round " + round + ": " + outcome);
        });
    }

    public static void main(String[] args) {
        MontyHallGame game = new MontyHallGame();
        game.simulate(1000, true); // true - если меняем выбор двери, false - если нет
        game.printResults();
    }
}

