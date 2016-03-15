package fr.iutvalence.logutamilhaud.battleship;

/**
 * The fr.iutvalence.logutamilhaud.battleship.Game class
 * @author logutn
 *
 */
public class Game
{
	/**
	 * The first player
	 */
	private Player player1;
	/**
	 * The second player
	 */
	private Player player2;
	/**
	 * The board
	 */	
	private Board board;

	/**
	 * This method allow us to start a game with 2 players 
	 * @param name1
	 * @param name2
	 */
	public Game(String name1, String name2)
	{
		this.player1 = new Player(name1);
		this.player2 = new Player(name2);
		this.board = new Board();
}
	/**
	 * The method 
	 */
	public void run()
	{
	
		
	}

}
