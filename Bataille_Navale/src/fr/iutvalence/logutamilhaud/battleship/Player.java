package fr.iutvalence.logutamilhaud.battleship;

import static fr.iutvalence.logutamilhaud.battleship.Orientation.BOTTOM;
import static fr.iutvalence.logutamilhaud.battleship.Orientation.LEFT;
import static fr.iutvalence.logutamilhaud.battleship.Orientation.NOTHING;
import static fr.iutvalence.logutamilhaud.battleship.Orientation.RIGHT;
import static fr.iutvalence.logutamilhaud.battleship.Orientation.TOP;

import java.util.Scanner;

/**
 * Player for the game.
 *
 * @author logut
 * @version 06/05
 */
public class Player {
    /** Name of player. */
    private String name;
    Scanner scan = new Scanner(System.in);
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
    
	/**
	 * A method to put all his boat for the player.
	 * @param player the player who puts his boat
	 * @param boats	table of all the boat of the player
	 * @param boatPosition the board where the boats are put
	 */
	public void playerPutABoat(Boat boats[], Board boatPosition){

        System.out.println(getName() + " please put your boat on the grid");

        int i = 0;
        while (i < 1) {
            System.out.printf("Boat select : " + boats[i].getNameOfBoat() + ". size : " +boats[i].getSize());
            System.out.println(" ");
            
            System.out.println("Please choose a column :");
            int X = scan.nextInt();
            while ((X < 0) || (X > 9)) {
                System.out.println("Please choose a valid column :");
                X = scan.nextInt();
            }
            
            System.out.println("Please choose a line :");
            int Y = scan.nextInt();
            while ((Y < 0) || (Y > 9)) {
                System.out.println("Please choose a valid line :");
                Y = scan.nextInt();
            }
            
            scan.nextLine();
            System.out.println("Please choose a orientation (RIGHT, LEFT, TOP, BOTTOM, NOTHING) :");
            String orientation = scan.nextLine();

            while ((Orientation.valueOf(orientation) != RIGHT) && (Orientation.valueOf(orientation) != LEFT) &&
                   (Orientation.valueOf(orientation) != TOP) && (Orientation.valueOf(orientation) != BOTTOM) &&
                   (Orientation.valueOf(orientation) != NOTHING)) {
                System.out.println("Please choose a valid orientation (RIGHT, LEFT, TOP, BOTTOM, NOTHING) :");
                orientation = scan.nextLine();
            }
            try {
            	boatPosition.putABoat(boats[i], X, Y, Orientation.valueOf(orientation));
            	boatPosition.displayBoard();
                i++;
            }
            catch (InvalidPositionException | OutOfRangeException e1) {
                System.err.println(e1.getMessage());
            }
        }
        
	}
	/**
	 * A player play a turn.
	 * @param boardShot The grid who is shot.
	 * @return the player who play the turn
	 */
	public String playATurn(Board boardShot, Board playedPosition){
		
		// modifier takeAShot ajouter try/catch (voir playerPutAboat)
		String testShot;
		
		while(true){
			int X = 0;
			int Y = 0;
			System.out.printf(" ");
			System.out.printf("Coup joue " + getName() );
	
	        System.out.println(" ");
	        System.out.println(" ");
	        System.out.printf("Please choose a column : ");
	        X = scan.nextInt();
	        System.out.println(" ");
	        System.out.printf("Please choose a line : ");
	        Y = scan.nextInt();
	        System.out.println(" ");
	
	        try {
				testShot = succeed(boardShot.takeAShot(X, Y, playedPosition));
				playedPosition.displayBoard();
				break;
			} 
	        catch (OccuppedPosition e) {
				System.err.println(e.getMessage());
			}  
		}
		
        System.out.println(testShot);
        return getName();
	}
	
	
	public String succeed(boolean testShot){
		if (testShot) {
            return "You got it !";
        }
        else {
            return "You miss this one";
        }
	}
}
