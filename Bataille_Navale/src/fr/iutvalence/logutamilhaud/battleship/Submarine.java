package fr.iutvalence.logutamilhaud.battleship;
/*
 * Inherited class from Boat.
 */
public class Submarine extends Boat
{
	/** constant which set the life and the size (which are equal) of the boat. */
	private final static int SIZE=1;
	/**
	 * Constructor
	 */
	public Submarine()
	{
		this.size=SIZE; 
		this.id='S';
		this.nameOfBoat="Submarine";
	}
	/**
	 * Get size of the boat.
	 * @return size
	 */
	public int getSize()
	{
		return this.size;
	}


}
