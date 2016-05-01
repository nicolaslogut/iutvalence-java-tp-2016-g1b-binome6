package fr.iutvalence.logutamilhaud.battleship;
/*
 * Inherited class from Boat.
 */
public class Cruiser extends Boat
{

	/** constant which set the size of the boat. */
	private final static int SIZE=2;
	/**
	 * Constructor
	 */
	public Cruiser()
	{
		this.size=SIZE;
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

}
