package fr.iutvalence.logutamilhaud.battleship.boats;

/**
 * Heritate from boat, a different boat.
 *
 * @author Amilhaud
 * @version final
 */
public class Destroyer extends Boat
{
    /** Constant which set the size of the boat. */
    private static final int SIZE = 3;
    /** Constant which represent the boat on the board. */
    private static final char ID = 'D';
    /** Name of the boat. */
    private final static String NAME_OF_THE_BOAT = "Destroyer";
    
    
    /**
     * Constructor
     */
    public Destroyer() {
		super(SIZE, ID, NAME_OF_THE_BOAT);
	}


}
