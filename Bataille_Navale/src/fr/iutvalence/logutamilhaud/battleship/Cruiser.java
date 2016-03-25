package fr.iutvalence.logutamilhaud.battleship;
/*
 * Inherited class from Boat.
 */
public class Cruiser extends Boat
{
	/**
	 * Constructor
	 * @param size size of the cruiser.
	 * @param nbLife actual life of the cruiser.
	 * @param id Id of the boat.
	 */
	public Cruiser(int size, int nbLife, char id)
	{
		this.size=2;
		this.life=2;
		this.id='C';
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
