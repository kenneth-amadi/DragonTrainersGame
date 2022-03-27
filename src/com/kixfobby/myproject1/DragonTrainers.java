package com.kixfobby.myproject1;

/**
 * YOUR DESCRIPTION OF THIS PROGRAM HERE
 *
 * @author YOUR NAME HERE
 * @version DATE HERE
 */

import java.util.Random;
import java.util.Scanner;

public class DragonTrainers {
    public static void main(String[] args) {
        // Random object
        Random rn = new Random();
        // Scanner object
        Scanner sc = new Scanner(System.in);
        int seed, matches;

        System.out.print("Enter a random seed: ");
        seed = sc.nextInt();

        String userInput;

        // types of dragon chosen
        int userDragon, computerDragon;

        // counter of results
        int ties = 0;
        int userWins = 0;
        int computerWins = 0;

        int count = 0;
        while (count < 1) {
            System.out.print("How many matches will we play? ");
            matches = sc.nextInt();
            sc.nextLine(); // to consume the newline character

            if (String.valueOf(matches).isBlank() || matches <= 0) {
                System.out.println("ERROR - number of matches must be positive!");
            } else {
                count = 1;
                // Game loop
                while (matches > 0) {
                    computerDragon = rn.nextInt(2); // random dragon for computer

                    // user chosen dragon
                    System.out.print("Please select one of your dragons [Fire/Plant/Water]: ");
                    userInput = sc.nextLine();
                    if (userInput.isBlank()) System.out.println("ERROR - Dragon prompt cannot be empty.");
                    else {
                        // printing user's dragon
                        if (userInput.charAt(0) == 'p' || userInput.charAt(0) == 'P') {
                            userDragon = 0;
                            System.out.println("You chose: Plant dragon.");
                        } else if (userInput.charAt(0) == 'f' || userInput.charAt(0) == 'F') {
                            userDragon = 2;
                            System.out.println("You chose: Fire dragon.");
                        } else if (userInput.charAt(0) == 'w' || userInput.charAt(0) == 'W') {
                            userDragon = 1;
                            System.out.println("You chose: Water dragon.");
                        } else {
                            userDragon = 3;
                            System.out.println("You don't have a " + userInput + " dragon, so you chose no dragons.");
                        }

                        // printing computer's dragon
                        if (computerDragon == 0)
                            System.out.println("I chose: Plant dragon.");

                        else if (computerDragon == 1) {
                            System.out.println("I chose: Water dragon. ");
                        } else
                            System.out.println("I chose: Fire dragon. ");

                        // printing the result
                        if (userDragon == computerDragon) {
                            System.out.println("A Tie!");
                            ties++;
                        } else if (userDragon == 3) {
                            System.out.println("I win by default!");
                            computerWins++;
                        } else if (userDragon == 1 && computerDragon == 2) {
                            System.out.println("Water defeats Fire - you win!");
                            computerWins++;
                        } else if (userDragon == 1 && computerDragon == 0) {
                            System.out.println("Plant defeats Water - you lose!");
                            computerWins++;
                        } else if (userDragon == 2 && computerDragon == 1) {
                            System.out.println("Water defeats Fire - you lose!");
                            computerWins++;
                        } else if (userDragon == 2 && computerDragon == 0) {
                            System.out.println("Fire defeats Plant - you win!");
                            userWins++;
                        } else if (userDragon == 0 && computerDragon == 1) {
                            System.out.println("Plant defeats Water - you win!");
                            userWins++;
                        } else {
                            System.out.println("Fire defeats Plant - you lose!");
                            userWins++;
                        }

                        // printing newline
                        System.out.println();
                        matches--;

                    }

                }

                // printing stats
                System.out.println("The tournament is over!");
                System.out.println("We tied " + ties + " matches.");
                System.out.println("I won " + computerWins + " matches.");
                System.out.println("You won " + userWins + " matches.");

                // deciding final winner
                if (userWins > computerWins) {
                    System.out.println("You are the winner!");
                } else if (computerWins > userWins) {
                    System.out.println("I am the winner!");
                } else {
                    System.out.println("Neither of us can claim victory here!");
                }
            }
        }

    }
}

