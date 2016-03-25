package fr.iutvalence.logutamilhaud.battleship;
/*
 * Inherited class from Boat.
 */
public class Destroyer extends Boat
{
	/**
	 * Constructor
	 * @param size size of the destroyer.
	 * @param nbLife actual life of the destroyer.
	 * @param id Id of the boat.
	 */
	public Destroyer(int size, int nbLife, char id)
	{
		this.size=3;
		this.life=3;
		this.id='D';
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
