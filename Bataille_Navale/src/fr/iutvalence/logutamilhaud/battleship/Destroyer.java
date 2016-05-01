package fr.iutvalence.logutamilhaud.battleship;
/*
 * Inherited class from Boat.
 */
public class Destroyer extends Boat
{
	/** constant which set the size of the boat. */
	private final static int SIZE=3;
	/**
	 * Constructor
	 */
	public Destroyer()
	{
		this.size=SIZE;
		this.id='D';
		this.nameOfBoat="Destroyer";
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
