package org.example;

import java.util.Random;

        public class MontyHallSimulation {
            public static void main(String[] args) {
                int simulations = 1000;
                int switchWins = 0;
                int stayWins = 0;

                for (int i = 0; i < simulations; i++) {
                    if (runSimulation(true)) {
                        switchWins++;
                    }
                    if (runSimulation(false)) {
                        stayWins++;
                    }
                }

                System.out.println("Switch wins: " + switchWins);
                System.out.println("Stay wins: " + stayWins);
            }

            private static boolean runSimulation(boolean switchDoor) {
                Random random = new Random();
                int winningDoor = random.nextInt(3);
                int chosenDoor = random.nextInt(3);

                int openDoor;
                do {
                    openDoor = random.nextInt(3);
                } while (openDoor == chosenDoor || openDoor == winningDoor);

                // Если игрок решает сменить дверь
                if (switchDoor) {
                    // Игрок переключается на другую закрытую дверь
                    for (int i = 0; i < 3; i++) {
                        if (i != chosenDoor && i != openDoor) {
                            chosenDoor = i;
                            break;
                        }
                    }
                }

                // Проверяем, выиграл ли игрок
                return chosenDoor == winningDoor;
            }
        }

