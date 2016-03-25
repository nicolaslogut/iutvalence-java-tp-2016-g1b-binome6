package fr.iutvalence.logutamilhaud.battleship;
/*
 * Inherited class from Boat.
 */
public class Submarine extends Boat
{
	/**
	 * Constructor
	 * @param size size of the submarine.
	 * @param nbLife actual life of the submarine.
	 * @param id Id of the boat.
	 */
	public Submarine(int size, int nbLife, char id)
	{
		this.size=1;
		this.life=1;
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
