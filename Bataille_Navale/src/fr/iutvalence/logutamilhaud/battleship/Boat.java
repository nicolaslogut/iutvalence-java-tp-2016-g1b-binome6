package fr.iutvalence.logutamilhaud.battleship;

/**
 * Boat of the game.
 *
 * @author logut
 * @version 25/03
 */
abstract class Boat {
	/** Size of the boat. */
	public  int size;
	/** The life of the boat.  */
	public int life;
	/** The id of boat(destoyer ("d"), boat("b"), ..... */
	public char id;
}
