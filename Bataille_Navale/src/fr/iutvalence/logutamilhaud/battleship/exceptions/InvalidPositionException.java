package fr.iutvalence.logutamilhaud.battleship.exceptions;
/**
 * Exception who deal with boats who are on an other boat.
 * @author amilhaum
 *
 */
@SuppressWarnings("serial")
public class InvalidPositionException extends Exception {
	public InvalidPositionException(String message) {
		super(message);
	}

}
