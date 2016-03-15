package fr.iutvalence.logutamilhaud.battleship;

/**
 * TODO.
 *
 * @author TODO
 * @version TODO
 */
public class Boat {
	/** Type of the boat. */
	public final char boatType;
	/** Size of the boat. */
	public final int size;
	/** The life of the boat.  */
	public int life;
	// TODO What is it?
	/** The id of boat. */
	public char id;
	
	/**
	 * Create a boat TODO
	 * 
	 * @param boatType TODO
	 * @param size TODO
	 * @param id TODO
	 * @param nbLife TODO
	 */
	public Boat(char boatType, int size, char id, int nbLife)
	{
		this.boatType = boatType;
		this.size = size;
		this.life=nbLife;	
		this.id=id;
	}
}
