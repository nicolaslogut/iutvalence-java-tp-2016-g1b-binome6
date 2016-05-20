package fr.iutvalence.logutamilhaud.battleship.boats;


/**
 * Boat of the game.
 *
 * @author logut
 * @version 25/03
 */
public abstract class Boat {
    /** Size of the boat. */
    public int    size;
    /** The id of boat(destoyer ("d"), boat("b"), the symbol who gonna be on the board. */
    public char id;
    /** Name of the boat. */
    public String nameOfBoat;

    public Boat(int size, char id, String name){
        this.size = size;
        this.id = id;
        this.nameOfBoat = name;
    }
    /**
     * Get the name of the boat.
     * @return name of the boat
     */
    public String getNameOfBoat() {
        return nameOfBoat;
    }
    /**
     * Get size of the boat.
     *
     * @return size
     */
	public int getSize() {
		return size;
	}
	/**
	 * Get id of the boat.
	 * @return id
	 */
	public char getId() {
		return id;
	}

    
}
