package app;

import java.util.Arrays;

// Represents the game board
public class Board {
    Seed[][] cells = new Seed[3][3]; // A 2D array to hold the game board state

    // Constructor to initialize the board with empty cells
    public Board() {
        for (Seed[] cell : cells) {
            Arrays.fill(cell, Seed.EMPTY);
        }
    }

    // Fill a cell with the specified seed (X or O)
    public void fill(int row, int col, Seed seed) {
        cells[row][col] = seed;
    }

    // Check if a cell is empty
    public boolean isEmpty(int row, int col) {
        return cells[row][col] == Seed.EMPTY;
    }

    // Check if there are empty cells on the board
    public boolean hasEmpty() {
        for (Seed[] row : cells) {
            for (Seed col : row) {
                if (col == Seed.EMPTY) {
                    return true;
                }
            }
        }
        return false;
    }

    // Check if the specified seed has won the game
    public boolean hasWinner(Seed seed) {
        for (int i = 0; i < 3; i++) {
            // Check rows and columns for a win
            if ((cells[i][0] == seed && cells[i][1] == seed && cells[i][2] == seed) || (cells[0][i] == seed && cells[1][i] == seed && cells[2][i] == seed)) {
                return true;
            }
        }
        // Check diagonals for a win
        return (cells[0][0] == seed && cells[1][1] == seed && cells[2][2] == seed) || (cells[0][2] == seed && cells[1][1] == seed && cells[2][0] == seed);
    }

    // Print the current state of the game board
    public void print() {
        String board = """
                     
                     1     2     3
                   +-----------------+
                1  |  %s  |  %s  |  %s  |
                   +-----------------+
                2  |  %s  |  %s  |  %s  |
                   +-----------------+
                3  |  %s  |  %s  |  %s  |
                   +-----------------+
                   
                """;
        System.out.printf(board, cells[0][0], cells[0][1], cells[0][2], cells[1][0], cells[1][1], cells[1][2], cells[2][0], cells[2][1], cells[2][2]);
    }
}
