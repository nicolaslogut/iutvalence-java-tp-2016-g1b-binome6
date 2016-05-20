package fr.iutvalence.logutamilhaud.battleship;

import java.util.Scanner;

/**
 * Main of the application.
 * @author logut
 * @version 06/05
 */
public class Battleship 
{
    /**
     * Run the game.
     *
     * @param args Useless
     */
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	
    	System.out.print("Please choose a name: ");
    	String name1 = scan.nextLine();
    	System.out.print("Please choose a name: ");
    	String name2 = scan.nextLine();

        Game game = new Game(name1, name2);
        game.run();
        scan.close();
    }
}
