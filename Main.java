import app.Game;
import app.Player;
import app.Seed;

// Entry point for the Tic-Tac-Toe game
public class Main {
    public static void main(String[] args) {
        // Create a new game with two players and start the game
        Game game = new Game(new Player[]{new Player(Seed.X), new Player(Seed.O)});
        game.start();
    }
}
