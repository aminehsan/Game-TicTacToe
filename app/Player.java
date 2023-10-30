package app;

import java.util.Scanner;

// Represents a player in the Tic-Tac-Toe game
public class Player {
    private String name;
    private final Seed seed; // Player's seed (X or O)

    // Constructor to create a player with a specific seed and provide a Scanner
    public Player(Seed seed) {
        this.seed = seed;
    }

    // Set the player's name
    public void setName(Scanner scanner) {
        System.out.print("Enter your name: ");
        this.name = scanner.nextLine();
    }

    // Get the player's name
    public String getName() {
        return name;
    }

    // Get the player's seed (X or O)
    public Seed getSeed() {
        return seed;
    }
}
