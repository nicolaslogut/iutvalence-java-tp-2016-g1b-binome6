package fr.iutvalence.logutamilhaud.battleship;

/**
 * Boat of the game.
 *
 * @author logut
 * @version 18/03
 */
public class Boat {
	/** Type of the boat. */
	public final char boatType;
	/** Size of the boat. */
	public final int size;
	/** The life of the boat.  */
	public int life;
	/** The id of boat(destoyer ("d"), boat("b"), ..... */
	public char id;
	
	/**
	 * Create a boat.
	 * 
	 * @param boatType type of the boat.
	 * @param size size of the boat.
	 * @param id id of the boat.
	 * @param nbLife how much shot the boat can take before sinking.
	 */
	public Boat(char boatType, int size, char id, int nbLife)
	{
		this.boatType = boatType;
		this.size = size;
		this.life=nbLife;	
		this.id=id;
	}
}
