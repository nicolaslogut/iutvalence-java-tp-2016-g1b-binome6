package fr.iutvalence.logutamilhaud.battleship;

/**
 * Player for the game.
 *
 * @author logut
 * @version 25/03
 */
public class Player {
    /** Name of player. */
    private String name;

    /**
     * Initialize the name of a player.
     *
     * @param name name of a player
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Get the name of the player.
     *
     * @return name of the player
     */
    public String getName() {
        return name;
    }
}
