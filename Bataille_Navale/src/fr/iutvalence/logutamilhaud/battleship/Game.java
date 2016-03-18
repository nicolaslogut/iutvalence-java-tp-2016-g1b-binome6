package fr.iutvalence.logutamilhaud.battleship;

/**
 * game of batlleship
 * @author logut
 * @version 18/03
 */
public class Game {
    /** First player. */
    private Player player1;
    /** Second player. */
    private Player player2;
    /** Grid of shot fired by player1  */
    private Board  playedPositionPlayer1;
    /** grid of ship position of player1 */
    private Board  boatPositionPlayer1;
    /** Grid of shot fired by player2  */
    private Board  playedPositionPlayer2;
    /** grid of ship position of player2 */
    private Board  boatPositionPlayer2;

    /**
     * Create a game with 2 players, and initialize the board.
     *
     * @param name1 name of the first player.
     * @param name2 name of the second player.
     */
    public Game(String name1, String name2) {
        this.player1 = new Player(name1);
        this.player2 = new Player(name2);
        this.playedPositionPlayer1 = new Board();
        this.playedPositionPlayer2 = new Board();
        this.boatPositionPlayer1 = new Board();
        this.boatPositionPlayer2 = new Board();
    }

    /** Start the game. */
    public void run() 
    {
    	// Itinitialiser la partie : demander la position des bateaux pour chaque joueur.
    	
    	
    	// Démarrage de la partie
    	
    }
}
