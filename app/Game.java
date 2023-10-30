package app;

import java.util.Random;
import java.util.Scanner;

// Represents the game and game logic
public class Game {
    private final Scanner scanner = new Scanner(System.in); // Scanner for user input
    private final Random random = new Random(); // Random for To select a user
    private final Player[] players;
    private final Board board;
    private Player currentPlayer;

    // Constructor to initialize the game
    public Game(Player[] players) {
        this.players = players;
        board = new Board();
    }

    // Handle a player's move
    private void playerMove() {
        int row;
        int col;
        do {
            System.out.printf("\n%s (%s), Enter your move (row[1 3] col[1 3]): ", currentPlayer.getName(), currentPlayer.getSeed());
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
        } while (row >= 3 || row < 0 || col >= 3 || col < 0 || !board.isEmpty(row, col));
        board.fill(row, col, currentPlayer.getSeed());
    }

    // Start the game
    public void start() {
        System.out.print("\nWelcome to the Two player game of 'Tic-Tac-Toe'!\n");
        System.out.print("Let's begin.\n\n");

        // Set player names
        for (Player player : players) player.setName(scanner);

        // Print player information
        System.out.printf("\nPlayer one: %s (%s)\n", players[0].getName(), players[0].getSeed());
        System.out.printf("Player two: %s (%s)\n", players[1].getName(), players[1].getSeed());

        // Set Starting player
        currentPlayer = players[random.nextInt(players.length)];

        while (board.hasEmpty()) {
            board.print();
            playerMove();

            // Check the winner
            if (board.hasWinner(currentPlayer.getSeed())) {
                board.print();
                System.out.printf("\n*** %s (%s), won the game :) ***\n", currentPlayer.getName(), currentPlayer.getSeed());
                scanner.close();
                return;
            }

            // Switch to the other player
            currentPlayer = (currentPlayer == players[0]) ? players[1] : players[0];
        }

        // If there are no empty cells, the game is tied
        board.print();
        System.out.print("\n!!! The result of the game was tied :( !!!\n");
        scanner.close();
    }
}
