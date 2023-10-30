package app;

// Represents the possible states of a cell in the Tic-Tac-Toe game
public enum Seed {
    X,   // Represents the X player's move
    O,   // Represents the O player's move
    EMPTY; // Represents an empty cell

    @Override
    public String toString() {
        if (this == EMPTY) {
            return " ";
        }
        return this.name();
    }
}
