package fr.iutvalence.logutamilhaud.battleship;

/**
 * Main of the application..
 * @author logut
 * @version 25/03
 */
public class Battleship 
{
    /**
     * Run the game.
     *
     * @param args Useless
     */
    public static void main(String[] args) {
        Game game = new Game("Joueur 1", "Joueur 2"); 
        game.run();
    }
}
