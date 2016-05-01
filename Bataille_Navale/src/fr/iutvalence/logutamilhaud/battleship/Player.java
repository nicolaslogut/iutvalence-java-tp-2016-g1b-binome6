package fr.iutvalence.logutamilhaud.battleship;

/**
 * Player for the game
 *
 * @author logut
 * @version 25/03
 */
public class Player {
	/** Name of player. */
	public String name; 

	/**
	 * Initialize the name of a player.
	 * @param name name of a player
     */
	public Player(String name) 
	{
		this.name = name;
	}
	/**
	 * Get the name of the player.
	 * @return name of the player
	 */
	public String getName() 
	{
		return name;
	}
	/**
	 * Set the name of the player
	 * @param name of the player
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public Player() 
	{
		this.name = null;
	}
}
