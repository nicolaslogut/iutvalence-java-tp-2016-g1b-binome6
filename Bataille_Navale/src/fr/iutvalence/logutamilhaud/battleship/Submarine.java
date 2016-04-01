package fr.iutvalence.logutamilhaud.battleship;
/*
 * Inherited class from Boat.
 */
public class Submarine extends Boat
{
	/** constant which set the life and the size (which are equal) of the boat. */
	private final static int LIFE_AND_SIZE=1;
	/**
	 * Constructor
	 */
	public Submarine()
	{
		this.size=LIFE_AND_SIZE;
		this.life=LIFE_AND_SIZE;
		this.id='S';
	}
	/**
	 * Get size of the boat.
	 * @return size
	 */
	public int getSize()
	{
		return this.size;
	}
	/**
	 * get life of the boat.
	 * @return life
	 */
	public int getLife()
	{
		return this.size;
	}

}
