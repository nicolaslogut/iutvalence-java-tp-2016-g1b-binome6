package fr.iutvalence.logutamilhaud.battleship;

/**
 * TODO.
 *
 * @author TODO
 * @version TODO
 */
public class Game {
    /** First player. */
    private Player player1;
    /** Second player. */
    private Player player2;
    // TODO Only one board?
    /** Board. */
    private Board  board;

    /**
     * Create a game with 2 players.
     *
     * @param name1 TODO
     * @param name2 TODO
     */
    public Game(String name1, String name2) {
        this.player1 = new Player(name1);
        this.player2 = new Player(name2);
        this.board = new Board();
    }

    /** Start the game. */
    public void run() {
        // TODO
    }
}
