package fr.iutvalence.logutamilhaud.battleship;

/**
 * Heritate from boat, a different boat.
 *
 * @author Amilhaud
 * @version final
 */
public class Submarine extends Boat {
   
	
    /** Constant which set the size of the boat. */
    private static final int SIZE = 1;
    /** Constant which represent the boat on the board. */
    private static final char ID = 'S';
    /** Name of the boat. */
    private final static String NAME_OF_THE_BOAT = "Submarine";
    
    /**
     * Constructor
     */
    public Submarine() {
		super(SIZE, ID, NAME_OF_THE_BOAT);
	}
}
