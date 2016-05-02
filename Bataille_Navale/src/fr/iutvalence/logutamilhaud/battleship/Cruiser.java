package fr.iutvalence.logutamilhaud.battleship;

/**
 * TODO.
 *
 * @author TODO
 * @version TODO
 */
public class Cruiser extends Boat {

    /** Constant which set the size of the boat. */
    private static final int SIZE = 2;

    // TODO Create a constructor in Boat and call it from the subclasses.
    /**
     * Constructor
     */
    public Cruiser() {
        size = SIZE;
        id = 'C';
        nameOfBoat = "Cruiser";
    }

    // TODO Why is it in this class and not in Boat?
    /**
     * Get size of the boat.
     *
     * @return size
     */
    public int getSize() {
        return size;
    }
}
