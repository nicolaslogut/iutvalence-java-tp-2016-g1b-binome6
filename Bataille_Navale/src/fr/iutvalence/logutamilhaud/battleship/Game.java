package fr.iutvalence.logutamilhaud.battleship;
import static fr.iutvalence.logutamilhaud.battleship.Orientation.BOTTOM;
import static fr.iutvalence.logutamilhaud.battleship.Orientation.LEFT;
import static fr.iutvalence.logutamilhaud.battleship.Orientation.NOTHING;
import static fr.iutvalence.logutamilhaud.battleship.Orientation.RIGHT;
import static fr.iutvalence.logutamilhaud.battleship.Orientation.TOP;
import java.util.Scanner;
/**
 * game of battleship
 * @author logut
 * @version 25/03
 */
public class Game 
{
	
    /** First player. */
    private Player player1;
    /** Second player. */
    private Player player2;
    /** Grid of shot fired by player1  */
    private Board  playedPositionPlayer1;
    /** Grid of ship position of player1 */
    private Board  boatPositionPlayer1;
    /** Grid of shot fired by player2  */
    private Board  playedPositionPlayer2;
    /** Grid of ship position of player2 */
    private Board  boatPositionPlayer2;
    /** Actual player. */
    private int currentPlayer;
    /**
     * Create a game with 2 players, and initialize the board.
     *
     * @param name1 name of the first player.
     * @param name2 name of the second player.
     */
    public Game(String name1, String name2) 
    {
        this.player1 = new Player(name1);
        this.player2 = new Player(name2);
        this.playedPositionPlayer1 = new Board();
        this.playedPositionPlayer2 = new Board(); 
        this.boatPositionPlayer1 = new Board();
        this.boatPositionPlayer2 = new Board();
     
    }

    /** Start the game. */
    public void run() 
    {
    	Boat[] boats1 = new Boat[]{new Cruiser(),  new Cruiser(), new Submarine(), new Submarine(), new Destroyer()};
        Boat[] boats2 = new Boat[]{new Cruiser(),  new Cruiser(), new Submarine(), new Submarine(), new Destroyer()};
         
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Joueur 1 veuillez saisir vos bateaux");
        
        for(int i =0;i<5;i++)
        {
			System.out.println("Veuillez saisir une position X :");
			int X = scan.nextInt();
			System.out.println("Veuillez saisir une position Y :");
			int Y = scan.nextInt();
			System.out.println("Veuillez saisir une orientation :");
			String orientation= scan.nextLine();
        	
			if(orientation=="RIGHT")
			{
				try {
					boatPositionPlayer1.putABoat(boats1[i], X, Y, RIGHT);
				} catch (InvalidPositionException | OutOfRangeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(orientation=="LEFT")
			{
				try {
					boatPositionPlayer1.putABoat(boats1[i], X, Y, LEFT);
				} catch (InvalidPositionException | OutOfRangeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(orientation=="TOP")
			{
				try {
					boatPositionPlayer1.putABoat(boats1[i], X, Y, TOP);
				} catch (InvalidPositionException | OutOfRangeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(orientation=="BOTTOM")
			{
				try {
					boatPositionPlayer1.putABoat(boats1[i], X, Y, BOTTOM);
				} catch (InvalidPositionException | OutOfRangeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
        }
        
        System.out.println("Joueur é veuillez saisir vos bateaux");
        for(int i =0;i<5;i++)
        {
			System.out.println("Veuillez saisir une position X :");
			int X = scan.nextInt();
			System.out.println("Veuillez saisir une position Y :");
			int Y = scan.nextInt();
			System.out.println("Veuillez saisir une orientation :");
			String orientation= scan.nextLine();
        	
			if(orientation=="RIGHT")
			{
				try {
					boatPositionPlayer2.putABoat(boats2[i], X, Y, RIGHT);
				} catch (InvalidPositionException | OutOfRangeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(orientation=="LEFT")
			{
				try {
					boatPositionPlayer2.putABoat(boats2[i], X, Y, LEFT);
				} catch (InvalidPositionException | OutOfRangeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(orientation=="TOP")
			{
				try {
					boatPositionPlayer2.putABoat(boats2[i], X, Y, TOP);
				} catch (InvalidPositionException | OutOfRangeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(orientation=="BOTTOM")
			{
				try {
					boatPositionPlayer2.putABoat(boats2[i], X, Y, BOTTOM);
				} catch (InvalidPositionException | OutOfRangeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
        }



        
		currentPlayer=1;
		
		while(true)
		{
					
			System.out.println("Veuillez saisir une position X :");
			int X = scan.nextInt();
			System.out.println("Veuillez saisir une position Y :");
			int Y = scan.nextInt();
			
			boatPositionPlayer2.takeAShot(X, Y, playedPositionPlayer1);
			
			if(boatPositionPlayer2.checkVitctory()==true)
			{
				break;
			}
			else
			{
				currentPlayer=2;
			}
			
			
			System.out.println("Veuillez saisir une position X :");
			X = scan.nextInt();
			System.out.println("Veuillez saisir une position Y :");
			Y = scan.nextInt();
			
			boatPositionPlayer1.takeAShot(X, Y, playedPositionPlayer2);
			scan.close();
			
			if(boatPositionPlayer1.checkVitctory()==true)
			{
				break;
			}
			else
			{
				currentPlayer=1;
			}
		}
		System.out.println("Victory player ");
		if(currentPlayer==1)
		{
			System.out.println(player1.getName());
		}
		else
		{
			System.out.println(player2.getName());
		}
	
    }
}
