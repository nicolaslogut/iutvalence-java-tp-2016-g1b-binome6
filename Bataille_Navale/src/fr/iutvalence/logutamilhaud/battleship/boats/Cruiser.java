package fr.iutvalence.logutamilhaud.battleship.boats;

/**
 * Heritate from boat, a different boat.
 *
 * @author Amilhaud
 * @version final
 */
public class Cruiser extends Boat {

    /** Constant which set the size of the boat. */
    private static final int SIZE = 2;
    /** Constant which represent the boat on the board. */
    private static final char ID = 'C';
    /** Name of the boat. */
    private final static String NAME_OF_THE_BOAT = "Cruiser";
	 
    /**
     * Constructor
     */
    public Cruiser() {
		super(SIZE, ID, NAME_OF_THE_BOAT);
	}
}
