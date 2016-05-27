package fr.iutvalence.logutamilhaud.battleship.exceptions;
/**
 * Exception who deeal with player who want to put a boat on an other boat.
 * @author amilhaum
 *
 */
@SuppressWarnings("serial")
public class OccuppedPosition extends Exception {

	public OccuppedPosition(String message) {
		super(message);
	}

}
