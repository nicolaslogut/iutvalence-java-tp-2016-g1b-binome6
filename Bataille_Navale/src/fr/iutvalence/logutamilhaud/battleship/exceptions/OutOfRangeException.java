package fr.iutvalence.logutamilhaud.battleship.exceptions;
/**
 * Exceptions who deal with position who are out of the grid.
 * @author amilhaum
 *
 */
@SuppressWarnings("serial")
public class OutOfRangeException extends Exception {
	public OutOfRangeException(String message) {
		super(message);
	}

}
