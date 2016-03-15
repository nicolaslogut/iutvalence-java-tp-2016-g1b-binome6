package fr.iutvalence.logutamilhaud.battleship;

/**
 * The fr.iutvalence.logutamilhaud.battleship.Boat class
 * @author logutn
 *
 */
public class Boat
{
	/**
	 * The type of boat
	 */
	public final char boatType;
	
	/**
	 * The size of boat
	 */
	public final int size;
	
	/**
	 * The life of boat
	 */
	public int life;
	
	/**
	 * The id of boat
	 */
	public char id;
	
	/**
	 * This allow us to create a boat
	 * 
	 * @param boatType
	 * @param size
	 * @param id
	 * @param nbLife
	 */
	public Boat(char boatType, int size, char id, int nbLife)
	{
		this.boatType = boatType;
		this.size = size;
		this.life=nbLife;	
		this.id=id;
	}

	/**
	 * 
	 * @return life
	 */
	public int getLife()
	{
		return life;
	}
	
	/**
	 * @return id
	 */
	public char getId()
	{
		return id;
	}

	/**
	 * 
	 * @return boatType
	 */
	public char getBoatType()
	{
		return boatType;
	}

	/**
	 * 
	 * @return size
	 */
	public int getLength()
	{
		return size;
	}
	
	
}
