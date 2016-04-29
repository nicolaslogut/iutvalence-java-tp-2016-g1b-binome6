package fr.iutvalence.logutamilhaud.battleship;
/*
 * Inherited class from Boat.
 */
public class Cruiser extends Boat
{

	/** constant which set the life and the size (which are equal) of the boat. */
	private final static int LIFE_AND_SIZE=2;
	/**
	 * Constructor
	 */
	public Cruiser()
	{
		this.size=LIFE_AND_SIZE;
		this.life=LIFE_AND_SIZE; 
		this.id='C';
		this.nameOfBoat="Cruiser";
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
