package fr.iutvalence.logutamilhaud.battleship;

// TODO Create a dedicated package for the boats
/**
 * Boat of the game.
 *
 * @author logut
 * @version 25/03
 */
abstract class Boat {
    /** Size of the boat. */
    protected int    size;
    /* TODO This isn't indicated by the class? */
    /** The id of boat(destoyer ("d"), boat("b"), ..... */
    protected char   id;
    /** Name of the boat. */
    protected String nameOfBoat;

    public String getNameOfBoat() {
        return nameOfBoat;
    }
}
