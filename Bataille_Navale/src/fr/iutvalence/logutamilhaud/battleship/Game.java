package fr.iutvalence.logutamilhaud.battleship;
import java.util.Scanner; 

/**
 * game of batlleship
 * @author logut
 * @version 25/03
 */
public class Game 
{
	
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
    
    /** first cruiser of the player1 */
    private Boat cruiser1Player1;
    /** second cruiser of the player1 */
    private Boat cruiser2Player1;
    /** destoyer of the player1 */
    private Boat destoyerPlayer1;
    /** first submarine of the player1 */
    private Boat submarine1Player1;
    /** second submarine of the player1 */
    private Boat submarine2Player1;
    
    /** first cruiser of the player2 */
    private Boat cruiser1Player2;
    /** second cruiser of the player2 */
    private Boat cruiser2Player2;
    /** destoyer of the player2 */
    private Boat destoyerPlayer2;
    /** first submarine of the player2 */
    private Boat submarine1Player2;
    /** second submarine of the player2 */
    private Boat submarine2Player2;


    /**
     * Create a game with 2 players, and initialize the board.
     *
     * @param name1 name of the first player.
     * @param name2 name of the second player.
     */
    public Game(String name1, String name2) 
    {
        this.player1 = new Player(name1);
        this.player2 = new Player(name2);
        this.playedPositionPlayer1 = new Board();
        this.playedPositionPlayer2 = new Board();
        this.boatPositionPlayer1 = new Board();
        this.boatPositionPlayer2 = new Board();
        Scanner userInput = new Scanner(System.in);
        System.out.println("Veuillez saisir une position :");
        String str = userInput.nextLine();
        System.out.println("Veuillez saisir une orientation :");
        String orientation = userInput.nextLine();
        
        
    }

    /** Start the game. */
    public void run() 
    {
    	// Itinitialiser la partie : demander la position des bateaux pour chaque joueur.
    	
    	
    	// Démarrage de la partie
    	
    }
}
